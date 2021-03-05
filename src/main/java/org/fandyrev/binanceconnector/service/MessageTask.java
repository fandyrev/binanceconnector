package org.fandyrev.binanceconnector.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fandyrev.binanceconnector.model.AggregateTradeMessage;
import org.fandyrev.binanceconnector.model.BookDepthMessage;
import org.fandyrev.binanceconnector.model.Message;
import org.fandyrev.binanceconnector.repository.AggregateTradeMessageRepository;
import org.fandyrev.binanceconnector.repository.BookDepthMessageRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public class MessageTask implements Runnable{
    private AggregateTradeMessageRepository aggregateTradeMessageRepository;
    private BookDepthMessageRepository bookDepthMessageRepository;
    private ObjectMapper mapper;
    private String incomingMessage;
    private BookDepthMessageService messageService;

    public MessageTask(AggregateTradeMessageRepository aggregateTradeMessageRepository,
                       BookDepthMessageRepository bookDepthMessageRepository,
                       BookDepthMessageService messageService,
                       String incomingMessage) {
        this.aggregateTradeMessageRepository = aggregateTradeMessageRepository;
        this.bookDepthMessageRepository = bookDepthMessageRepository;
        this.incomingMessage = incomingMessage;
        this.mapper = new ObjectMapper();
        this.messageService = messageService;
    }

    @Override
    public void run() {
        try {
            JpaRepository repository = null;
            Message message = mapper.readValue(this.incomingMessage, Message.class);

            if(message instanceof AggregateTradeMessage) {
                repository = aggregateTradeMessageRepository;
            } else {
                repository = bookDepthMessageRepository;
                messageService.putBookDepthMessage((BookDepthMessage) message);
            }

            repository.save(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
