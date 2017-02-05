package nl.arnedeboth.qsec.badgeterminal;

import nl.arnedeboth.qsec.badgeterminal.configuration.Configuration;

public class Main {

  public static void main(String[] args)
  {
    Configuration configuration = Configuration.fromArgs(args);
    new BadgeService(configuration).run();
  }

}
