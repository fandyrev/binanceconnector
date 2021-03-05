package org.fandyrev.binanceconnector.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "aggregate_trade_message")
public class AggregateTradeMessage extends Message{
    @JsonProperty("a")
    @Column(name = "aggregate_trade_id")
    private Long aggregateTradeID;
    @JsonProperty("p")
    @Column(name = "price")
    private Float price;
    @JsonProperty("q")
    @Column(name = "quantity")
    private Float quantity;
    @JsonProperty("f")
    @Column(name = "first_trade_id")
    private Long firstTradeID;
    @JsonProperty("l")
    @Column(name = "last_trade_id")
    private Long lastTradeID;
    @JsonProperty("T")
    @Column(name = "trade_time")
    private Date tradeTime;
    @JsonProperty("m")
    @Column(name = "buyer_market")
    private Boolean buyerMarket;

    public Long getAggregateTradeID() {
        return aggregateTradeID;
    }

    public void setAggregateTradeID(Long aggregateTradeID) {
        this.aggregateTradeID = aggregateTradeID;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Long getFirstTradeID() {
        return firstTradeID;
    }

    public void setFirstTradeID(Long firstTradeID) {
        this.firstTradeID = firstTradeID;
    }

    public Long getLastTradeID() {
        return lastTradeID;
    }

    public void setLastTradeID(Long lastTradeID) {
        this.lastTradeID = lastTradeID;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Boolean getBuyerMarket() {
        return buyerMarket;
    }

    public void setBuyerMarket(Boolean buyerMarket) {
        this.buyerMarket = buyerMarket;
    }

    @Override
    public String toString() {
        return "AggregateTradeMessage{" +
                "eventType='" + getEventType() + '\'' +
                ", eventTime=" + getEventTime() +
                ", symbol='" + getSymbol() + '\'' +
                ", aggregateTradeID=" + aggregateTradeID +
                ", price=" + price +
                ", quantity=" + quantity +
                ", firstTradeID=" + firstTradeID +
                ", lastTradeID=" + lastTradeID +
                ", tradeTime=" + tradeTime +
                ", buyerMarket=" + buyerMarket +
                '}';
    }
}
