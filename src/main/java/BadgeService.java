import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BadgeService {

  // TODO: Make this configurable.
  // Show data to the operator or not.
  private static boolean showOperator = true;


  public static boolean identify(String badgeID)
  {
    User user = getUserWithBadgeId(badgeID);

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

  private static boolean checkPermission(User user)
  {
    // TODO: write permission logic

    if (user == null) return false;

    return user.inGroup("admin");
  }


  private static User getUserWithBadgeId(String badgeId)
  {
    Optional<User> result = getUsers().stream().filter(u -> badgeId.equals(u.getBadgeId())).findFirst();
    return result.isPresent() ? result.get() : null;
  }

  private static List<User> getUsers()
  {
    return Arrays.asList(new User[] {
        new User(1, "Viktor Lantsov", "12345", Arrays.asList(new String[] {"admin", "red-brotherhood"})),
        new User(2, "John Doe", "23451", Arrays.asList(new String[] {"guest1"})),
        new User(3, "Jane Doe", "34512", Arrays.asList(new String[] {"guest2"})),
    });
  }
}
