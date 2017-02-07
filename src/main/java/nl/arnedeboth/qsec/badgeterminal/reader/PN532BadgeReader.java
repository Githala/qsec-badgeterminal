package nl.arnedeboth.qsec.badgeterminal.reader;

import nl.arnedeboth.qsec.badgeterminal.identification.IdentificationHandler;
import nl.arnedeboth.qsec.badgeterminal.identification.results.BadgeResult;
import nl.arnedeboth.qsec.badgeterminal.identification.results.GrantedResult;
import nl.arnedeboth.qsec.badgeterminal.logger.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PN532BadgeReader implements IBadgeReader {

  private IdentificationHandler identificationHandler;

  public PN532BadgeReader(IdentificationHandler identificationHandler)
  {
    this.identificationHandler = identificationHandler;
  }

  public void run()
  {
    Process pn532ReaderProcess;
    try {
      pn532ReaderProcess = new ProcessBuilder("./pn532reader").start();
    } catch (IOException e) {
      e.printStackTrace();
      Logger.log("ERROR", "The pn532reader program could not start.");
      return;
    }

    Scanner s = new Scanner(new InputStreamReader(pn532ReaderProcess.getInputStream()));

    Logger.log("INFO", "Waiting for input from pn532 reader process...");
    while(true)
    {
      String badgeId = s.nextLine();
      System.out.println("Reading badge with id: "+badgeId);

      BadgeResult result = identificationHandler.identify(badgeId);
      System.out.println(result instanceof GrantedResult ? "Access granted" : "Access denied");
    }
  }

}
