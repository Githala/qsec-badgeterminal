package nl.arnedeboth.qsec.badgeterminal.listeners.http;

import com.google.gson.Gson;
import nl.arnedeboth.qsec.badgeterminal.identification.results.BadgeResult;
import nl.arnedeboth.qsec.badgeterminal.listeners.IBadgeListener;

import static spark.Spark.*;

/**
 * Created by vlan on 2/5/17.
 */
public class HttpBadgeListener implements IBadgeListener {

  private static Gson gson = new Gson();

  public HttpBadgeListener()
  {
    staticFileLocation("/public");
    webSocket("/listen", WebSocketHandler.class);

    init();
  }

  public void sendBadgeResult(BadgeResult result)
  {
    HttpBadgeResultWrapper wrapper = new HttpBadgeResultWrapper(result);
    WebSocketHandler.broadcastMessage(gson.toJson(wrapper));
  }
}
