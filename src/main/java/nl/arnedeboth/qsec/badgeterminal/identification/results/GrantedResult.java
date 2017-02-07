package nl.arnedeboth.qsec.badgeterminal.identification.results;

import nl.arnedeboth.qsec.badgeterminal.identification.User;

/* GrantedResult
 * The identification was successful and the user has the proper permissions.
 */
public class GrantedResult extends IdentificationResult {

  public GrantedResult(User user) {
    super(user);
  }

  @Override
  public boolean equals(Object other)
  {
    if (other == null) return false;
    if (!(other instanceof GrantedResult)) return false;

    return super.equals(other);
  }
}
