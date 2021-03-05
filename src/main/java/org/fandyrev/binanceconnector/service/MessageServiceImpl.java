package org.fandyrev.binanceconnector.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fandyrev.binanceconnector.repository.AggregateTradeMessageRepository;
import org.fandyrev.binanceconnector.repository.BookDepthMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private AggregateTradeMessageRepository aggregateTradeMessageRepository;
    @Autowired
    private BookDepthMessageRepository bookDepthMessageRepository;
    @Autowired
    private BookDepthMessageService messageService;
    private ObjectMapper mapper;
    private ExecutorService executor;

    public MessageServiceImpl() {
        this.mapper = new ObjectMapper();
        this.executor = Executors.newFixedThreadPool(8);
    }

    @Override
    public void save(String incomingMessage) {
        MessageTask task = new MessageTask(aggregateTradeMessageRepository,
                bookDepthMessageRepository,
                messageService,
                incomingMessage);
        executor.execute(task);
    }
}
