import java.util.List;

public class User {
  private int id;

  public String getName() {
    return name;
  }

  public String getBadgeId() {
    return badgeId;
  }

  public List<String> getGroups() {
    return groups;
  }

  private String name;
  private String badgeId;
  private List<String> groups;

  public User(int id, String name, String badgeId, List<String> groups){
    this.id = id;
    this.name = name;
    this.badgeId = badgeId;
    this.groups = groups;
  }



  public boolean inGroup(String group)
  {
    return this.groups.contains(group);
  }

  public int getId() {
    return id;
  }

  public String toString()
  {
    return String.format("User - id: %d - name: %s - badgeId: %s", id, name, badgeId);
  }
}
