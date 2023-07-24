package com.neo.example.issue.helidon.workarround;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@ServerEndpoint(value = "/websocket/workaround/{id}")
public class WebsocketEndpointWorkaround {

    @Inject
    protected HelperBean helperBean;

    @OnOpen
    public void onOpen(@PathParam("id") String id, Session session) {
        helperBean.getMessageMap().put(id, new ArrayList<>());
    }

    @OnMessage
    public void onMessage(@PathParam("id") String id, Session session, String message) {
        helperBean.getMessageMap().get(id).add(message);
    }

    public Map<String, List<String>> getMessageMap() {
        return helperBean.getMessageMap();
    }
}