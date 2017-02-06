package identification;

import nl.arnedeboth.qsec.badgeterminal.User;
import nl.arnedeboth.qsec.badgeterminal.exceptions.UserProviderException;
import nl.arnedeboth.qsec.badgeterminal.provider.IUserProvider;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ExceptionUserProvider implements IUserProvider {

  @Override
  public User getUserWithBadgeId(String badgeId) throws UserProviderException {
    throw new UserProviderException("test exception");
  }
}
