package identification;

import nl.arnedeboth.qsec.badgeterminal.identification.User;
import nl.arnedeboth.qsec.badgeterminal.provider.IUserProvider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class TestUserProvider implements IUserProvider {


  private Set<User> users = new HashSet<User>();

  public TestUserProvider()
  {
    users.add(new User(1, "Viktor", "Lantsov", new String[] {"12345"}, new int[] {1 ,2, 3}));
    users.add(new User(2, "John", "Doe", new String[] {"23451"}, new int[] {2} ));
    users.add(new User(3, "Jane", "Doe", new String[] {"34512"}, new int[] {3} ));
    users.add(new User(4, "Denna Maria", "Aska", new String[] {"54321"}, new int[] {1} ));
  }

  public User getUserById(int id) {
    Optional<User> possibleUser =  users.stream().filter(u -> u.getId() == id).findFirst();
    return possibleUser.orElse(null);
  }

  @Override
  public User getUserWithBadgeId(String badgeId) {
    Optional<User> possibleUser = users.stream().filter(u -> Arrays.stream(u.getBadgeIds()).anyMatch(bid -> bid.equals(badgeId))).findFirst();
    return possibleUser.orElse(null);
  }
}
