package com.vvygulyarniy.wowcraft.bnet.auction;

import com.vvygulyarniy.wowcraft.bnet.auction.client.AuctionHouseClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@PropertySource("classpath:bnet.properties")
public class AuctionHouseServiceLauncher {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public AuctionHouseClient auctionHouseClient(RestTemplate restTemplate, @Value("${bnet.key}") String bnetKey) {
        return new AuctionHouseClient(restTemplate, bnetKey);
    }

    public static void main(String[] args) {
        SpringApplication.run(AuctionHouseServiceLauncher.class, args);
    }
}
