package com.tyy.socket;


import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{username}")
public class WebSocketService implements WebSocketUseCase {

    private Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        sessionMap.put(username, session);
        System.out.println("connection established ,user = " + username);
    }

    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        System.out.println("connection closed ,user = " + username);

    }

    @OnMessage
    public void onMsg(Session session, String message, @PathParam("username") String username) {

        System.out.println(message);
        session.getAsyncRemote().sendText("resp");
        session.getAsyncRemote().sendObject("");
        System.out.println("on msg");
    }

    public void sendMiddleMsg(String msg, String userName) {
        Session session = sessionMap.get(userName);
        session.getAsyncRemote().sendObject(msg);
        session.getUserPrincipal().getName();
    }


    @Override
    public void sendMessageToClient(String msg, String userName) {
        sessionMap.get(userName).getAsyncRemote().sendText(msg);
    }

    @Override
    public void sendResultToClient(Object result, String userName) {
        sessionMap.get(userName).getAsyncRemote().sendObject(result);
    }
}
