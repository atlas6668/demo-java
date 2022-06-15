package com.atlas.java.pattern.creational.abstract_factory;

import sun.exercise.pattern.creational.abstract_factory.factory.Factory;
import sun.exercise.pattern.creational.abstract_factory.factory.Link;
import sun.exercise.pattern.creational.abstract_factory.factory.Page;
import sun.exercise.pattern.creational.abstract_factory.factory.Tray;

import java.util.Scanner;

/**
 * Created by sunwenming on 2018/1/21.
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String className = scanner.next();
        Factory factory = Factory.getFactory(className);
        Link asahi = factory.createLink("朝日新闻", "http://www.asahi.com/");
        Link yomiuri = factory.createLink("读卖新闻", "http://www.yomiuri.co.jp/");
        Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");
        Tray trayews = factory.createTray("新闻");
        trayews.add(asahi);
        trayews.add(yomiuri);
        Tray trayyahoo = factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo);
        Tray traysearch = factory.createTray("搜索引擎");
        traysearch.add(google);
        Page page = factory.createPage("LinkPage", "Atlas");
        page.add(trayews);
        page.add(trayyahoo);
        page.add(traysearch);
        page.output();
    }
}
