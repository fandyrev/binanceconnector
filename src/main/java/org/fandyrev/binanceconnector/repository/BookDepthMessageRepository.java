package org.fandyrev.binanceconnector.repository;

import org.fandyrev.binanceconnector.model.BookDepthMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDepthMessageRepository extends JpaRepository<BookDepthMessage, Long> {
}
