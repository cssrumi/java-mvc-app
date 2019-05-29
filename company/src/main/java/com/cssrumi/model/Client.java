package com.cssrumi.model;

import lombok.*;

@Setter
@Getter
public class Client extends Person {
    public Client(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
