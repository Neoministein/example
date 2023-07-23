package com.neo.example.issue.helidon;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import jakarta.inject.Inject;
import jakarta.websocket.*;
import jakarta.ws.rs.client.WebTarget;
import org.glassfish.tyrus.client.ClientManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.List;
import java.util.Map;

@HelidonTest
class IssueTest {

    @Inject
    protected WebsocketEndpoint websocketEndpoint;

    @Inject
    protected WebTarget webTarget;

    protected Map<String, List<String>> messageMap;

    @Test
    void test() throws Exception {
        Session session_1 = connectToWebsocket("websocket/id-1");
        session_1.getBasicRemote().sendText("A message 1");

        Session session_2 = connectToWebsocket("websocket/id-2");
        session_2.getBasicRemote().sendText("A message 1");

        Thread.sleep(1000);

        messageMap = websocketEndpoint.getMessageMap();
        Assertions.assertEquals("A message 1", messageMap.get("id-1").get(0));
        session_2.close();

        messageMap = websocketEndpoint.getMessageMap();
        Assertions.assertEquals("A message 1", messageMap.get("id-1").get(0)); //<-- Throws NullPointerException for messageMap
    }

    public Session connectToWebsocket(String path) {
        Endpoint endpoint = new Endpoint() {
            @Override
            public void onOpen(Session session, EndpointConfig config) {}
        };

        try {
            return ClientManager.createClient().connectToServer(endpoint, new URI("ws://127.0.0.1:" + webTarget.getUri().getPort() + "/" + path));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
