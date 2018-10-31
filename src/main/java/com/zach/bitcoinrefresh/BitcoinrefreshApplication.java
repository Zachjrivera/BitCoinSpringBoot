package com.zach.bitcoinrefresh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class BitcoinrefreshApplication {
	private static final Logger log = LoggerFactory.getLogger(BitcoinrefreshApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BitcoinrefreshApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder ) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Ticker ticker = restTemplate.getForObject(

					"http://api.icndb.com/jokes/random", Ticker.class);
			log.info(ticker.toString());
		};
	}
}