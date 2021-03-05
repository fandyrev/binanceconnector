package org.fandyrev.binanceconnector.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "book_depth_message")
public class BookDepthMessage extends Message{
    @JsonProperty("T")
    @Column(name = "transaction_time")
    private Date transactionTime;
    @JsonProperty("U")
    @Column(name = "first_update_id_in_event")
    private Long firstUpdateIDInEvent;
    @JsonProperty("u")
    @Column(name = "final_update_id_in_event")
    private Long finalUpdateIDInEvent;
    @JsonProperty("pu")
    @Column(name = "final_update_id_in_last_stream")
    private Long finalUpdateIdInLastStream;
    @JsonProperty("b")
    @Column(name = "bids_to_be_updated")
    private Float[][] bidsToBeUpdated;
    @JsonProperty("a")
    @Column(name = "asks_to_be_updated")
    private Float[][] asksToBeUpdated;

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Long getFirstUpdateIDInEvent() {
        return firstUpdateIDInEvent;
    }

    public void setFirstUpdateIDInEvent(Long firstUpdateIDInEvent) {
        this.firstUpdateIDInEvent = firstUpdateIDInEvent;
    }

    public Long getFinalUpdateIDInEvent() {
        return finalUpdateIDInEvent;
    }

    public void setFinalUpdateIDInEvent(Long finalUpdateIDInEvent) {
        this.finalUpdateIDInEvent = finalUpdateIDInEvent;
    }

    public Long getFinalUpdateIdInLastStream() {
        return finalUpdateIdInLastStream;
    }

    public void setFinalUpdateIdInLastStream(Long finalUpdateIdInLastStream) {
        this.finalUpdateIdInLastStream = finalUpdateIdInLastStream;
    }

    public Float[][] getBidsToBeUpdated() {
        return bidsToBeUpdated;
    }

    public void setBidsToBeUpdated(Float[][] bidsToBeUpdated) {
        this.bidsToBeUpdated = bidsToBeUpdated;
    }

    public Float[][] getAsksToBeUpdated() {
        return asksToBeUpdated;
    }

    public void setAsksToBeUpdated(Float[][] asksToBeUpdated) {
        this.asksToBeUpdated = asksToBeUpdated;
    }

    @Override
    public String toString() {
        return "BookDepthMessage{" +
                "eventType='" + getEventType() + '\'' +
                ", eventTime=" + getEventTime() +
                ", transactionTime=" + transactionTime +
                ", symbol='" + getSymbol() + '\'' +
                ", firstUpdateIDInEvent=" + firstUpdateIDInEvent +
                ", finalUpdateIDInEvent=" + finalUpdateIDInEvent +
                ", finalUpdateIdInLastStream=" + finalUpdateIdInLastStream +
                ", bidsToBeUpdated=" + Arrays.toString(bidsToBeUpdated) +
                ", asksToBeUpdated=" + Arrays.toString(asksToBeUpdated) +
                '}';
    }
}
