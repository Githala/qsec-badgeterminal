package nl.arnedeboth.qsec.badgeterminal.listeners.http;

import nl.arnedeboth.qsec.badgeterminal.logger.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static spark.Spark.*;

@WebSocket
public class WebSocketHandler {

  private static List<Session> sessions = new LinkedList<>();

  @OnWebSocketConnect
  public void onConnect(Session session) throws Exception {
    sessions.add(session);
  }

  @OnWebSocketClose
  public void onClose(Session session, int statusCode, String reason)
  {
    sessions.remove(session);
  }

  public static void broadcastMessage(String message)
  {
    sessions.stream().filter(Session::isOpen).forEach(session -> {
      try {
        session.getRemote().sendString(message);
      } catch (IOException e) {
        Logger.log("Warning", "Error sending broadcast to session. Closing session now.");
        session.close();
        sessions.remove(session);
      }
    });
  }

}
