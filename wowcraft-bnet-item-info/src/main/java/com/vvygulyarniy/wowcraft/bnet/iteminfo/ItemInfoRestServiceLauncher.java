package com.vvygulyarniy.wowcraft.bnet.iteminfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@PropertySource(value = "classpath:bnet.properties")
public class ItemInfoRestServiceLauncher {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ItemInfoRestServiceLauncher.class, args);
    }
}
