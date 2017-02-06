package nl.arnedeboth.qsec.badgeterminal.logger;

public class Logger {

  public static void log(String level, String message)
  {
    System.out.println(level + ": "+message );
  }
}
