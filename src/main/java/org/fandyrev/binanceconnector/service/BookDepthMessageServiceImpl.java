package org.fandyrev.binanceconnector.service;

import org.fandyrev.binanceconnector.model.BookDepthMessage;
import org.springframework.stereotype.Service;

@Service
public class BookDepthMessageServiceImpl implements BookDepthMessageService {
    private BookDepthMessage bookDepthMessage;

    @Override
    public BookDepthMessage getBookDepthMessage() {
        return bookDepthMessage;
    }

    @Override
    public synchronized void putBookDepthMessage(BookDepthMessage message) {
        if(bookDepthMessage == null || bookDepthMessage.getTransactionTime().getTime() < message.getTransactionTime().getTime()){
            bookDepthMessage = message;
        }
    }
}
