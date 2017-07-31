package com.vvygulyarniy.wowcraft.marketprice;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RequestSenderTest {
    @Test
    public void makesGetRequestsToGivenUrlUsingHttpClient() throws Exception {
        HttpClient clientMock = mock(HttpClient.class);
        RequestSender sender = new RequestSender(clientMock);

        String url = "http://google.com";
        HttpResponse response = responseWithText("test response");
        when(clientMock.execute(eq(new HttpGet(url)))).thenReturn(response);
        String responseText = sender.request(url);

        assertThat(responseText).isEqualTo("test response");
    }

    private HttpResponse responseWithText(String text) throws IOException {
        HttpResponse response = mock(HttpResponse.class);
        HttpEntity entity = mock(HttpEntity.class);
        when(entity.getContent()).thenReturn(new ByteArrayInputStream(text.getBytes()));
        when(response.getEntity()).thenReturn(entity);
        return response;
    }
}