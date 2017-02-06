package nl.arnedeboth.qsec.badgeterminal.identification;

import nl.arnedeboth.qsec.badgeterminal.User;
import nl.arnedeboth.qsec.badgeterminal.exceptions.UserProviderException;
import nl.arnedeboth.qsec.badgeterminal.listeners.IBadgeListener;
import nl.arnedeboth.qsec.badgeterminal.logger.Logger;
import nl.arnedeboth.qsec.badgeterminal.provider.IUserProvider;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class IdentificationHandler {

  private IUserProvider userProvider;
  private Set<IBadgeListener> listeners = new ConcurrentSkipListSet<>();

  /* IdentificationHandler
   * Create a new instance of the IdentificationHandler that uses the specified userProvider to fetch the users from.
   */
  public IdentificationHandler(IUserProvider userProvider)
  {
    this.userProvider = userProvider;
  }

  /* identify
   * Identify the badge with badgeId.
   * This function will check if a user with badgeId exists. If not, access is denied.
   * If a user is found the function will check if the user has permission to be allowed access.
   */
  public BadgeResult identify(String badgeID)
  {
    User user = null;

    try {
      user = userProvider.getUserWithBadgeId(badgeID);
    } catch (UserProviderException upe)
    {
      Logger.log("ERROR", upe.getMessage());
      BadgeResult result  = new ErrorResult(upe.getMessage());
      notifyListeners(result);
      return result;
    }

    // Print user data or not found message.
    if (user == null)
    {
      Logger.log("INFO","No user matches badgeId: "+badgeID);
    } else {
      Logger.log("INFO", user.toString());
    }

    boolean access = checkPermission(user);

    BadgeResult result = access ? new GrantedResult(user) : new DeniedResult(user);
    notifyListeners(result);
    return result;
  }

  public void addBadgeListener(IBadgeListener listener)
  {
    listeners.add(listener);
  }

  // Notify all the listeners that a badge attempt has been made and what the result is.
  private void notifyListeners(BadgeResult result)
  {
    listeners.forEach(l -> l.sendBadgeResult(result));
  }

  // checks if a User has the proper permissions.
  private boolean checkPermission(User user)
  {
    // TODO: write permission logic

    if (user == null) return false;

    // For now every user with group 1 has permission.
    // TODO: make configurable which groups/users are allowed access.
    return user.inGroup(1);
  }
}
