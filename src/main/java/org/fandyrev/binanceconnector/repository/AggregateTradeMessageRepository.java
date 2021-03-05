package org.fandyrev.binanceconnector.repository;

import org.fandyrev.binanceconnector.model.AggregateTradeMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AggregateTradeMessageRepository extends JpaRepository<AggregateTradeMessage, Long> {
}
