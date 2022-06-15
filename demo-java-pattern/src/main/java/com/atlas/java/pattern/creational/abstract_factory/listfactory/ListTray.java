package com.atlas.java.pattern.creational.abstract_factory.listfactory;

import sun.exercise.pattern.creational.abstract_factory.factory.Item;
import sun.exercise.pattern.creational.abstract_factory.factory.Tray;

import java.util.Iterator;

/**
 * Created by sunwenming on 2018/1/21.
 */
public class ListTray extends Tray {
    public ListTray(String caption){
        super(caption);
    }
    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption).append("\n");
        buffer.append("<ul>\n");
        Iterator iterator = tray.iterator();
        while(iterator.hasNext()){
            Item item = (Item) iterator.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("</li>\n");
        return buffer.toString();
    }
}
