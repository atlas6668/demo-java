package com.atlas.java.pattern.creational.abstract_factory.listfactory;

import com.atlas.java.pattern.creational.abstract_factory.factory.Item;
import com.atlas.java.pattern.creational.abstract_factory.factory.Page;

import java.util.Iterator;

/**
 * Created by sunwenming on 2018/1/21.
 */
public class ListPage extends Page {
    public ListPage(String title, String autor){
        super(title, autor);
    }
    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>").append(title).append("</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>").append(title).append("</h1>\n");
        buffer.append("<ul>\n");
        Iterator iterator = content.iterator();
        while(iterator.hasNext()){
            Item item = (Item) iterator.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("<hr><address>").append(autor).append("</address>");
        buffer.append("</body><html>\n");
        return buffer.toString();
    }
}
