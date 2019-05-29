package com.cssrumi.model;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

    public String toString() {
        return firstName + " " + lastName;
    }
}
