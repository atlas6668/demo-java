package com.atlas.java.pattern.creational.abstract_factory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

/**
 * Created by sunwenming on 2018/1/21.
 */
public abstract class Page {
    protected String title;
    protected String autor;
    protected Vector content = new Vector();
    public Page(String title, String autor){
        this.title = title;
        this.autor = autor;
    }
    public void add(Item item){
        content.add(item);
    }
    public abstract String makeHTML();
    public void output(){
        try {
            String filename = title + ".html";
            Writer writer = new FileWriter(filename);
            writer.write(this.makeHTML());
            writer.close();
            System.out.println("已产生" + filename + "。");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
