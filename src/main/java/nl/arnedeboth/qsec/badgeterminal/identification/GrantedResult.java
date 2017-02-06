package nl.arnedeboth.qsec.badgeterminal.identification;

import nl.arnedeboth.qsec.badgeterminal.User;

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
