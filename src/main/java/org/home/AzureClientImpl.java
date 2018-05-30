package org.home;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

public class AzureClientImpl implements AzureClient {
    private final Client client;
    private final String baseUrl;

    public AzureClientImpl(Client client, String baseUrl) {
        this.client = client;
        this.baseUrl = baseUrl;
    }

    public SimpleResponse simpleResponse() {
        return client.target(baseUrl).path("/").request(MediaType.APPLICATION_JSON).get(SimpleResponse.class);
    }
}
