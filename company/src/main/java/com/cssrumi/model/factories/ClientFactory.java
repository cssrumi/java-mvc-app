package com.cssrumi.model.factories;

import com.cssrumi.model.Client;

public class ClientFactory {
    public static Client getClient(String firstName, String lastName) {
        return new Client(firstName, lastName);
    }
}
