package com.cssrumi.model;

public class Wage {
    // prawie jak struktura :)
    public float basic;
    public float bonus;
    public float other;

    public Wage(float basic) {
        this.basic = basic;
        bonus = 0f;
        other = 0f;
    }
}
