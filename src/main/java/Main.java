import java.util.Scanner;

public class Main {

  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);

    while(true)
    {
      String badgeId = s.nextLine();
      System.out.println("Emulating badge with id: "+badgeId);

      boolean result = BadgeService.identify(badgeId);
      System.out.println(result ? "Access granted" : "Access denied");
    }
  }

}
