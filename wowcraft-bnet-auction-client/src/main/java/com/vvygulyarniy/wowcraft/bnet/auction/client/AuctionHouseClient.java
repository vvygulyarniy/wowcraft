package com.vvygulyarniy.wowcraft.bnet.auction.client;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vvygulyarniy.wowcraft.bnet.auction.client.model.Auction;
import com.vvygulyarniy.wowcraft.bnet.auction.client.model.Realm;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class AuctionHouseClient {
    public static final String ENDPOINT = "https://eu.api.battle.net/wow/auction/data/{server}?locale={locale}&apikey={bnetKey}";
    private final RestTemplate restTemplate;
    private final String bnetKey;

    public AuctionHouseClient(RestTemplate restTemplate, String bnetKey) {
        this.restTemplate = restTemplate;
        this.bnetKey = bnetKey;
    }

    public Collection<Auction> getAllAuctions(String realm) throws IOException {
        AuctionResponse mainResponse = restTemplate.getForObject(ENDPOINT, AuctionResponse.class,
                                                                 realm, "ru_RU", bnetKey);

        AuctionsDataResponse data = restTemplate.getForObject(mainResponse.getFiles().get(0).getUrl(),
                                                              AuctionsDataResponse.class);
        return data.getAuctions();
    }


    private static class AuctionResponse {
        private final List<AuctionResponseFile> files;

        @JsonCreator
        private AuctionResponse(@JsonProperty("files") List<AuctionResponseFile> files) {
            this.files = files;
        }

        List<AuctionResponseFile> getFiles() {
            return files;
        }
    }

    private static class AuctionResponseFile {
        private final String url;

        @JsonCreator
        @JsonIgnoreProperties(ignoreUnknown = true)
        private AuctionResponseFile(@JsonProperty("url") String url) {
            this.url = url;
        }

        String getUrl() {
            return url;
        }
    }

    private static class AuctionsDataResponse {
        private final List<Realm> realms;
        private final List<Auction> auctions;

        @JsonCreator
        private AuctionsDataResponse(@JsonProperty("realms") List<Realm> realms,
                                     @JsonProperty("auctions") List<Auction> auctions) {
            this.realms = realms;
            this.auctions = auctions;
        }

        public List<Auction> getAuctions() {
            return auctions;
        }
    }
}
