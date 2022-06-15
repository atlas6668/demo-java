package com.atlas.java.pattern.creational.abstract_factory.listfactory;

import sun.exercise.pattern.creational.abstract_factory.factory.Factory;
import sun.exercise.pattern.creational.abstract_factory.factory.Link;
import sun.exercise.pattern.creational.abstract_factory.factory.Page;
import sun.exercise.pattern.creational.abstract_factory.factory.Tray;

/**
 * Created by sunwenming on 2018/1/21.
 */
public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String autor) {
        return new ListPage(title, autor);
    }
}
