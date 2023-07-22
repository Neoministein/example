package com.neo.example.issue.helidon;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@ServerEndpoint(value = "/websocket/{id}")
public class WebsocketEndpoint {

    protected Map<String, List<String>> messageMap = new HashMap<>();

    @OnOpen
    public void onOpen(@PathParam("id") String id, Session session) {
        messageMap.put(id, new ArrayList<>());
    }

    @OnMessage
    public void onMessage(@PathParam("id") String id, Session session, String message) {
        messageMap.get(id).add(message);
    }

    public Map<String, List<String>> getMessageMap() {
        return messageMap;
    }
}