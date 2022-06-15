package com.atlas.java.pattern.creational.abstract_factory.factory;

import java.util.Vector;

/**
 * Created by sunwenming on 2018/1/21.
 */
public abstract class Tray extends Item {
    protected Vector tray = new Vector();
    public Tray(String caption){
        super(caption);
    }
    public void add(Item item){
        tray.add(item);
    }
}
