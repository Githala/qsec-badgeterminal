package nl.arnedeboth.qsec.badgeterminal.identification;

import java.util.Arrays;

/**
 * User
 * The user class that represents a user retrieved from a UserPro
 */
public class User {

  private int id;
  private String firstName;
  private String lastName;
  private String badgeId;
  private int[] groupIds;


  public User(int id, String firstName, String lastName, String badgeId, int[] groupIds)
  {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.badgeId = badgeId;

    this.groupIds = groupIds;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getBadgeId() {
    return badgeId;
  }

  public int[] getGroupIds() {
    return groupIds;
  }

  public boolean inGroup(int group)
  {
    return Arrays.stream(this.groupIds).anyMatch(g -> g == group);
  }

  public String toString()
  {
    return String.format("User - id: %d - name: %s %s - badgeId: %s", id, firstName, lastName, badgeId);
  }


  @Override
  public boolean equals(Object other)
  {
    if (other == null) return false;
    if (!(other instanceof User)) return false;

    User otherUser = (User) other;

    return id == otherUser.getId() &&
           firstName.equals(otherUser.getFirstName()) &&
           lastName.equals(otherUser.getLastName()) &&
           badgeId.equals((otherUser.getBadgeId())) &&
           Arrays.equals(groupIds, otherUser.getGroupIds());
  }
}
