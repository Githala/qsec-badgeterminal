package nl.arnedeboth.qsec.badgeterminal.identification;

import nl.arnedeboth.qsec.badgeterminal.User;

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
