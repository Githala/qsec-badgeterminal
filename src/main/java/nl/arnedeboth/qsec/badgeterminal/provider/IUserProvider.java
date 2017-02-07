package nl.arnedeboth.qsec.badgeterminal.provider;

import nl.arnedeboth.qsec.badgeterminal.identification.User;
import nl.arnedeboth.qsec.badgeterminal.exceptions.UserProviderException;

public interface IUserProvider {

  /**
   * getUserWithBadgeId
   * Will try to find a users with badgeId.
   * @param badgeId The badge id that is used to find a user.
   * @return The user matching the badgeId if it exists, null otherwise.
   * @throws UserProviderException
   */
  User getUserWithBadgeId(String badgeId) throws UserProviderException;
}
