package nl.arnedeboth.qsec.badgeterminal;

import nl.arnedeboth.qsec.badgeterminal.configuration.Configuration;
import nl.arnedeboth.qsec.badgeterminal.provider.UserProvider;

import java.util.Scanner;

public class BadgeService {

  // TODO: Make this configurable.
  // Show data to the operator or not.
  private static boolean showOperator = true;

  private Configuration configuration;
  private UserProvider userProvider;

  public BadgeService(Configuration configuration)
  {
    this.configuration = configuration;
    this.userProvider = new UserProvider(configuration.getUserServiceUrl());
  }

  public boolean identify(String badgeID)
  {
    User user = userProvider.getUserWithBadgeId(badgeID);

    // if user was not found!
    if (user == null)
    {
      System.out.println("No user matches badgeId: "+badgeID);
      return false;
    }

    System.out.println(user.toString());
    // The user was found. Show user info to the operator if enabled.
    if (showOperator) {
      
    }


    return checkPermission(user);
  }

  private boolean checkPermission(User user)
  {
    // TODO: write permission logic

    if (user == null) return false;

    return user.inGroup(1);
  }

  public void run()
  {

    Scanner s = new Scanner(System.in);

    while(true)
    {
      String badgeId = s.nextLine();
      System.out.println("Emulating badge with id: "+badgeId);

      boolean result = identify(badgeId);
      System.out.println(result ? "Access granted" : "Access denied");
    }
  }



}
