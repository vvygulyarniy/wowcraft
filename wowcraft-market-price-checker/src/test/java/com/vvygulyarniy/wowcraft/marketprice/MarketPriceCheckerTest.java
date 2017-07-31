package com.vvygulyarniy.wowcraft.marketprice;

import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

public class MarketPriceCheckerTest {

    @Test
    public void name() throws Exception {
        String data = new MarketPriceChecker("f9cpez2y8nrgn2ge73ttxxqfyw9uxx4n",
                                             new RequestSender(HttpClients.createMinimal())).auctionInfoAsJson("blackscar", "ru_RU");
        System.out.println(data);
    }
}