package com.zach.bitcoinrefresh;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Ticker {
    private String base;
    private String target;
    private double price;
    private double volume;
    private double change;
    private long timestamp;
    private boolean success;
    private String error;
    private static final Logger log = LoggerFactory.getLogger(BitcoinrefreshApplication.class);


    public Ticker(){}


    public Ticker(String base, String target, double price, double volume, double change, long timestamp, boolean success, String error) {
        this.base = base;
        this.target = target;
        this.price = price;
        this.volume = volume;
        this.change = change;
        this.timestamp = timestamp;
        this.success = success;
        this.error = error;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "base='" + base + '\'' +
                ", target='" + target + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", change=" + change +
                ", timestamp=" + timestamp +
                ", success=" + success +
                ", error='" + error + '\'' +
                '}';
    }

    @Scheduled(fixedRate = 30000)
    public void update(){
        RestTemplate restTemplate = new RestTemplate();
        Ticker ticker = restTemplate.getForObject("https://api.cryptonator.com/api/ticker/btc-usd",Ticker.class);
        log.info(ticker.toString());
    }
}
