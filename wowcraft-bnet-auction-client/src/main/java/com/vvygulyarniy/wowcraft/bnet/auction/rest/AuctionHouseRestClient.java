package com.vvygulyarniy.wowcraft.bnet.auction.rest;

import com.vvygulyarniy.wowcraft.bnet.auction.client.AuctionHouseClient;
import com.vvygulyarniy.wowcraft.bnet.auction.client.model.Auction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("/rest/auctions")
public class AuctionHouseRestClient {
    private final AuctionHouseClient auction;

    public AuctionHouseRestClient(AuctionHouseClient auction) {
        this.auction = auction;
    }

    @GetMapping
    public Collection<Auction> findAll() throws IOException {
        return auction.getAllAuctions("blackscar");
    }
}
