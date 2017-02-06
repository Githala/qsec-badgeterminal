package nl.arnedeboth.qsec.badgeterminal.listeners;

import nl.arnedeboth.qsec.badgeterminal.identification.results.BadgeResult;

public interface IBadgeListener {

  void sendBadgeResult(BadgeResult result);

}
