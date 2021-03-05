package org.fandyrev.binanceconnector;

import org.fandyrev.binanceconnector.service.MessageService;
import org.fandyrev.binanceconnector.service.WsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
public class BinanceconnectorApplication {
    private final String WS_URL = "wss://fstream.binance.com/ws/";
    @Autowired
    private MessageService service;

    public static void main(String[] args) {
        SpringApplication.run(BinanceconnectorApplication.class, args);
    }

    @Bean
    public WebSocketConnectionManager wsConnectionManager() {
        WebSocketConnectionManager manager = new WebSocketConnectionManager(
                new StandardWebSocketClient(),
                new WsHandler(service),
                this.WS_URL);

        manager.setAutoStartup(true);

        return manager;
    }
}
