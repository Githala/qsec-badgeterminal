package nl.arnedeboth.qsec.badgeterminal.exceptions;

public class UserProviderException extends Exception {

  public UserProviderException(String message) {
    super(message);
  }

  public UserProviderException(String message, Throwable cause) {
    super(message, cause);
  }
}
