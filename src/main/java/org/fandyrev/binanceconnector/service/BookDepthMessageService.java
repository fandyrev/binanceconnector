package org.fandyrev.binanceconnector.service;

import org.fandyrev.binanceconnector.model.BookDepthMessage;

public interface BookDepthMessageService {
    public BookDepthMessage getBookDepthMessage();
    public void putBookDepthMessage(BookDepthMessage message);
}
