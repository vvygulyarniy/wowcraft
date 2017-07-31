package com.vvygulyarniy.wowcraft.marketprice;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

public class RequestSender {

    private final HttpClient httpClient;

    public RequestSender(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String request(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        return IOUtils.toString(response.getEntity().getContent());
    }
}
