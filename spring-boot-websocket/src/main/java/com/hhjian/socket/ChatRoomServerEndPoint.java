package com.hhjian.socket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>聊天室</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.22
 * {@link ServerEndpoint}
 */
@ServerEndpoint("/chat/{username}")
public class ChatRoomServerEndPoint {

    private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        String sessionId = session.getId();
        livingSessions.put(sessionId, session);
        sendTextAll("欢迎 用户 [" + username + "] 来到聊天室!");
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, Session session, String message) {
        sendTextAll("用户 [" + username + "]:" + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        String sessionId = session.getId();
        livingSessions.remove(sessionId);
        sendTextAll("用户 [" + username + "] 已经离开聊天室了！");
    }

    /**
     * 指定session发送消息
     *
     * @param session
     * @param message
     */
    private void sendText(Session session, String message) {
        RemoteEndpoint.Basic basic = session.getBasicRemote();
        try {
            basic.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消息广播
     *
     * @param message
     */
    private void sendTextAll(String message) {
        livingSessions.forEach((sessionId, session) -> sendText(session, message));
    }
}
