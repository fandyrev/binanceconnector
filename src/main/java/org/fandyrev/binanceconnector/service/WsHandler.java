package org.fandyrev.binanceconnector.service;

import org.springframework.web.socket.*;

public class WsHandler implements WebSocketHandler {
    private final String SUBSCRIBE = "{\n" +
            "\"method\": \"SUBSCRIBE\",\n" +
            "\"params\":\n" +
            "[\n" +
            "\"btcusdt@aggTrade\",\n" +
            "\"btcusdt@depth20\"\n" +
            "],\n" +
            "\"id\": 1\n" +
            "}";
    private MessageService service;

    public WsHandler(MessageService service) {
        this.service = service;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println("Connect to server");
        TextMessage message = new TextMessage(SUBSCRIBE);
        webSocketSession.sendMessage(message);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        service.save(webSocketMessage.getPayload().toString());
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
