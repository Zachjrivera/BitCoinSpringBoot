package com.zach.bitcoinrefresh;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Ticker {
    private String base;
    private String target;
    private int price;
    private int volume;
    private int change;
    private static final Logger log = LoggerFactory.getLogger(BitcoinrefreshApplication.class);


    public Ticker(){}


    public Ticker(String base, String target, int price, int volume, int change) {
        this.base = base;
        this.target = target;
        this.price = price;
        this.volume = volume;
        this.change = change;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "base='" + base + '\'' +
                ", target='" + target + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", change=" + change +
                '}';
    }

    @Scheduled(fixedRate = 30000)
    public void update(){
        RestTemplate restTemplate = new RestTemplate();
        Ticker ticker = restTemplate.getForObject("https://api.cryptonator.com/api/ticker/btc-usd",Ticker.class);
        log.info(ticker.toString());
    }
}
