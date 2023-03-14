package com.atlas.java.pattern.behavioral.chain_of_responsibility;

/**
 * @author sunwenming
 * @date 2023/3/14.
 */
public class Trouble {

    public int getNumber() {
        return number;
    }

    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Trouble{" +
                "number=" + number +
                '}';
    }

}
