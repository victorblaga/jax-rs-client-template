package org.home;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import static org.junit.Assert.*;

public class AzureClientImplTest {

    @Test
    public void simpleResponse() {
        Client client = getClient();
        AzureClient azureClient = new AzureClientImpl(client, "http://localhost:5000");
        SimpleResponse simpleResponse = azureClient.simpleResponse();
        assertEquals("value", simpleResponse.getKey());
    }

    private Client getClient() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(JacksonProvider.class);
        clientConfig.register(JacksonFeature.class);

        return ClientBuilder.newBuilder().withConfig(clientConfig).build();
    }
}