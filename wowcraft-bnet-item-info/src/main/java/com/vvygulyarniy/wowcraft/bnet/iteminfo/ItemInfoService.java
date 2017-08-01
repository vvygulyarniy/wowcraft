package com.vvygulyarniy.wowcraft.bnet.iteminfo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController()
@RequestMapping("/items")
public class ItemInfoService {
    private static final String REST_ENDPOINT = "https://eu.api.battle.net/wow/item/{itemId}?locale={locale}&apikey={apiKey}";
    private final String key;
    private final RestTemplate restTemplate;

    public ItemInfoService(@Value("${bnet.key}") String key, RestTemplate restTemplate) {
        this.key = key;
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> itemInfo(@PathVariable("id") Long itemId,
                                      @RequestParam(value = "locale", defaultValue = "ru_RU") String locale) throws IOException {
        try {
            return new ResponseEntity<>(restTemplate.getForObject(REST_ENDPOINT, ItemInfo.class, itemId, locale, key),
                                        HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>("Item with ID=" + itemId + "info not found: " + e.getMessage(), NOT_FOUND);
        }
    }

}
