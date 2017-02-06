package nl.arnedeboth.qsec.badgeterminal.provider;

import nl.arnedeboth.qsec.badgeterminal.identification.User;
import nl.arnedeboth.qsec.badgeterminal.exceptions.UserProviderException;

public interface IUserProvider {
  User getUserWithBadgeId(String badgeId) throws UserProviderException;
}
