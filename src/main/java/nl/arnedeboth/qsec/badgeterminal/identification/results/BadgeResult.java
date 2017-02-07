package nl.arnedeboth.qsec.badgeterminal.identification.results;


/* BadgeResult
 * This abstract class represents a result after someone badged. This can either result in an authentication or an error.
 * This base class can be extended for different types of results that can happen after a badge action.
 */
public abstract class BadgeResult {
  public boolean equals(Object other)
  {
    if (other == null) return false;
    if (!(other instanceof BadgeResult)) return false;

    return true;
  }
}
