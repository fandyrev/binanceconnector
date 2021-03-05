package org.fandyrev.binanceconnector.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "e")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BookDepthMessage.class, name = "depthUpdate"),
        @JsonSubTypes.Type(value = AggregateTradeMessage.class, name = "aggTrade") }
)
@MappedSuperclass
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnoreProperties
    protected Long id;
    @JsonProperty("e")
    @Transient
    private String eventType;
    @JsonProperty("E")
    @Column(name = "event_time")
    private Date eventTime;
    @JsonProperty("s")
    @Column(name = "symbol")
    private String symbol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return "Message{" +
                "eventType='" + eventType + '\'' +
                ", eventTime=" + eventTime +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
