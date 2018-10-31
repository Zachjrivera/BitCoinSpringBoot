package com.zach.bitcoinrefresh;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Bitcoin {
    private Ticker ticker;
    private Long timestamp;
    private Boolean success;
    private String error;


    public Bitcoin(){}

    public Bitcoin(Ticker ticker, Long timestamp, Boolean success, String error) {
        this.ticker = ticker;
        this.timestamp = timestamp;
        this.success = success;
        this.error = error;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    @Override
    public String toString() {
        return "Bitcoin{" +
                "ticker=" + ticker +
                ", timestamp=" + timestamp +
                ", success=" + success +
                ", error='" + error + '\'' +
                '}';
    }
}
