package com.zach.bitcoinrefresh;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SchedualeClass {
    private static final Logger log = LoggerFactory.getLogger(BitcoinrefreshApplication.class);

    @Scheduled(fixedRate = 2000)
    public  void bitcoinupdate(){
        RestTemplate restTemplate = new RestTemplate();
        Bitcoin bitcoin = restTemplate.getForObject("https://api.cryptonator.com/api/ticker/btc-usd", Bitcoin.class);
        log.info(bitcoin.toString());
    }



}
