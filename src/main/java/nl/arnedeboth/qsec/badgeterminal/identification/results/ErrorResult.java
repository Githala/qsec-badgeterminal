package nl.arnedeboth.qsec.badgeterminal.identification.results;

/* ErrorResult
 * This is the result of a badge when an error occurred.
 * @message: contains a message on the error that has occurred.
 */

public class ErrorResult extends BadgeResult {
  private String message;

  public ErrorResult(String message)
  {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public boolean equals(Object other)
  {
    if (other == null) return false;
    if (!(other instanceof ErrorResult)) return false;

    ErrorResult otherER = (ErrorResult) other;

    return message.equals(otherER.getMessage());
  }
}
