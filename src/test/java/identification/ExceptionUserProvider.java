package identification;

import nl.arnedeboth.qsec.badgeterminal.identification.User;
import nl.arnedeboth.qsec.badgeterminal.exceptions.UserProviderException;
import nl.arnedeboth.qsec.badgeterminal.provider.IUserProvider;

public class ExceptionUserProvider implements IUserProvider {

  @Override
  public User getUserWithBadgeId(String badgeId) throws UserProviderException {
    throw new UserProviderException("test exception");
  }
}
