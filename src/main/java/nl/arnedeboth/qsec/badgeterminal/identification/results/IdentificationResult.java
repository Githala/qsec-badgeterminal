package nl.arnedeboth.qsec.badgeterminal.identification.results;

import nl.arnedeboth.qsec.badgeterminal.identification.User;

/**
 * The identification result represents a result where an authentication with a user was made.
 * This class can be used to create results where an authentication has taken place. (For example a success result.)
 */
public abstract class IdentificationResult extends BadgeResult {

  private User user;

  public IdentificationResult(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  @Override
  public boolean equals(Object other)
  {
    if (other == null) return false;
    if (!(other instanceof IdentificationResult)) return false;

    IdentificationResult otherIR = (IdentificationResult) other;

    if (user == otherIR.getUser()) return true;
    if (user != null && user.equals(otherIR.getUser())) return true;

    return false;
  }
}
