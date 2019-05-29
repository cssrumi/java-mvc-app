package com.cssrumi.model;

public enum Contract {

    FULLTIME(0),
    PARTTIME(1),
    CONTRACT(2),;

    private int id;

    Contract(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
