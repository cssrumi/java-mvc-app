package com.cssrumi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Operation extends BaseEntity {

    private String name;
    private float value;

    public String toString() {
        return name + " : " + value;
    }
}
