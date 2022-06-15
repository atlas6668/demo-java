package com.atlas.java.pattern.creational.abstract_factory.factory;

/**
 * Created by sunwenming on 2018/1/21.
 */
public abstract class Item {
    protected String caption;
    public Item(String caption){
        this.caption = caption;
    }
    public abstract String makeHTML();
}
