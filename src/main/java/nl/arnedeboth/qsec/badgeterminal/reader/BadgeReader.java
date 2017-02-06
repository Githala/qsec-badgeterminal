package nl.arnedeboth.qsec.badgeterminal.reader;

import nl.arnedeboth.qsec.badgeterminal.identification.BadgeResult;
import nl.arnedeboth.qsec.badgeterminal.identification.GrantedResult;
import nl.arnedeboth.qsec.badgeterminal.identification.IdentificationHandler;
import nl.arnedeboth.qsec.badgeterminal.identification.IdentificationResult;

import java.util.Scanner;

public class BadgeReader {

  private IdentificationHandler identificationHandler;

  public BadgeReader(IdentificationHandler identificationHandler)
  {
    this.identificationHandler = identificationHandler;
  }

  public void run()
  {
    Scanner s = new Scanner(System.in);

    while(true)
    {
      String badgeId = s.nextLine();
      System.out.println("Emulating badge with id: "+badgeId);

      BadgeResult result = identificationHandler.identify(badgeId);
      System.out.println(result instanceof GrantedResult ? "Access granted" : "Access denied");
    }
  }

}
