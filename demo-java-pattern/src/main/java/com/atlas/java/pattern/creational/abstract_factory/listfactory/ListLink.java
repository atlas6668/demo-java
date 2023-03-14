package com.atlas.java.pattern.creational.abstract_factory.listfactory;

import com.atlas.java.pattern.creational.abstract_factory.factory.Link;

/**
 * Created by sunwenming on 2018/1/21.
 */
public class ListLink extends Link {
    public ListLink(String caption, String url){
        super(caption, url);
    }
    @Override
    public String makeHTML() {
        return "<li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
