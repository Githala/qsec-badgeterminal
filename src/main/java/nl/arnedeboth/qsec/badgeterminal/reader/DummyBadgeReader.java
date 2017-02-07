package nl.arnedeboth.qsec.badgeterminal.reader;

import nl.arnedeboth.qsec.badgeterminal.identification.results.BadgeResult;
import nl.arnedeboth.qsec.badgeterminal.identification.results.GrantedResult;
import nl.arnedeboth.qsec.badgeterminal.identification.IdentificationHandler;

import java.util.Scanner;

public class DummyBadgeReader implements IBadgeReader {

  private IdentificationHandler identificationHandler;

  public DummyBadgeReader(IdentificationHandler identificationHandler)
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
