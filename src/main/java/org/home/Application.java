package org.home;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Application {
    public static void main(String[] args) {
        Client client = getClient();
        AzureClient azureClient = new AzureClientImpl(client, "http://localhost:5000");
        System.out.println(azureClient.simpleResponse());
    }

    private static Client getClient() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(JacksonFeature.class);

        return ClientBuilder.newBuilder().withConfig(clientConfig).build();
    }
}
