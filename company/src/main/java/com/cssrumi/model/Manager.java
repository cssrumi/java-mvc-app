package com.cssrumi.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Manager extends Employee {

    public Manager(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
