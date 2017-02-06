package nl.arnedeboth.qsec.badgeterminal.identification.results;

public abstract class BadgeResult {
  public boolean equals(Object other)
  {
    if (other == null) return false;
    if (!(other instanceof BadgeResult)) return false;

    return true;
  }
}
