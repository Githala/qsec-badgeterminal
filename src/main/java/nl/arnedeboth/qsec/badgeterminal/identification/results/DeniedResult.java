package nl.arnedeboth.qsec.badgeterminal.identification.results;

import nl.arnedeboth.qsec.badgeterminal.identification.User;

/* DeniedResult
 * The badgeID does not have permission.
 * Either the user does not have the proper permissions or no matching user was found.
 */
public class DeniedResult extends IdentificationResult {
  public DeniedResult()
  {
    super(null);
  }

  public DeniedResult(User user) {
    super(user);
  }

  @Override
  public boolean equals(Object other)
  {
    if (other == null) return false;
    if (!(other instanceof DeniedResult)) return false;

    return super.equals(other);
  }
}
