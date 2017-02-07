package nl.arnedeboth.qsec.badgeterminal.identification;

import nl.arnedeboth.qsec.badgeterminal.exceptions.UserProviderException;
import nl.arnedeboth.qsec.badgeterminal.identification.results.BadgeResult;
import nl.arnedeboth.qsec.badgeterminal.identification.results.DeniedResult;
import nl.arnedeboth.qsec.badgeterminal.identification.results.ErrorResult;
import nl.arnedeboth.qsec.badgeterminal.identification.results.GrantedResult;
import nl.arnedeboth.qsec.badgeterminal.listeners.IBadgeListener;
import nl.arnedeboth.qsec.badgeterminal.logger.Logger;
import nl.arnedeboth.qsec.badgeterminal.provider.IUserProvider;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * IdentificationHandler
 * This class provides the identifications of badgeIDs passed to it. It will try to find a user that matches the
 * badgeID and will check if the user has the proper permissions.
 */
public class IdentificationHandler {

  private IUserProvider userProvider;
  private Set<IBadgeListener> listeners = new HashSet<>();

  /**
   * IdentificationHandler
   * @param userProvider An implementation of the IUserProvider that will provide the users to identify with..
   */
  public IdentificationHandler(IUserProvider userProvider)
  {
    this.userProvider = userProvider;
  }

  /**
   * identify
   * Identify the badge with badgeId.
   * This function will check if a user with badgeId exists. If not, access is denied.
   * If a user is found the function will check if the user has permission to be allowed access.
   * @param badgeID The badge id that is used to look up a user.
   * @return        A subclass of BadgeResult that represents the result of the identification.
   */
  public BadgeResult identify(String badgeID)
  {
    User user;

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

  /**
   * addBadgeListener
   * Adds a listener to the badge event. Whenever a badge event occurs the listeners will be notified.
   * @param listener The listener that should be notified when a badge event occurs.
   */
  public void addBadgeListener(IBadgeListener listener)
  {
    listeners.add(listener);
  }

  /**
   * removeBadgeListener
   * Removes the listener from the badge event. This listener should no longer be notified.
   * @param listener The listener that should no longer be notified when a badge event occurs.
   */
  public void removeBadgeListener(IBadgeListener listener)
  {
    listeners.remove(listener);
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
