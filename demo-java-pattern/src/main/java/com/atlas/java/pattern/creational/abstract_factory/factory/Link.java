package com.atlas.java.pattern.creational.abstract_factory.factory;

/**
 * Created by sunwenming on 2018/1/21.
 */
public abstract class Link extends Item {
    protected String url;
    public Link(String caption, String url){
        super(caption);
        this.url = url;
    }
}
