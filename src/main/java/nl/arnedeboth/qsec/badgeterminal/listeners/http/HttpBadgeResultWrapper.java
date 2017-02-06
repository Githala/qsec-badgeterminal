package nl.arnedeboth.qsec.badgeterminal.listeners.http;

import nl.arnedeboth.qsec.badgeterminal.identification.results.BadgeResult;


public class HttpBadgeResultWrapper {
  private BadgeResult result;
  private String resultType;

  public HttpBadgeResultWrapper(BadgeResult result) {
    this.result = result;
    this.resultType = result.getClass().getSimpleName();
  }
}
