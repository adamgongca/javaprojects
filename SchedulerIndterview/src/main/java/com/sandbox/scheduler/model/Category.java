package com.sandbox.scheduler.model;

/**
 * Created by pchurchward on 2017-07-20.
 */
public enum Category {

    RED(1),
    GREEN(2),
    BLUE(3);

    private int value;

    public int getValue() {
        return value;
    }

    private Category(int value) {
        this.value = value;
    }
}
