package com.vvygulyarniy.wowcraft.bnet;

import com.vvygulyarniy.wowcraft.bnet.auction.client.AuctionHouseClient;
import com.vvygulyarniy.wowcraft.bnet.auction.client.model.Auction;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import java.util.Collection;

public class AuctionHouseClientTest {
    @Test
    public void name() throws Exception {
        AuctionHouseClient client = new AuctionHouseClient(new RestTemplate(),
                                                           "f9cpez2y8nrgn2ge73ttxxqfyw9uxx4n");

        Collection<Auction> auctions = client.getAllAuctions("blackscar");

        for (Auction auction : auctions) {
            System.out.println(auction);
        }
    }
}