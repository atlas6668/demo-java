package com.atlas.java.pattern.creational.prototype;

/**
 * Created by sunwenming on 2018/1/12.
 */
public class Prototype implements Cloneable {

    private int count;

    private ShallowCopy shallowCopy;

    private static Prototype prototype = new Prototype(0, new ShallowCopy());

    private Prototype(int count, ShallowCopy shallowCopy){
        this.count = count;
        this.shallowCopy = shallowCopy;
    }

    public Prototype clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
//        prototype.shallowCopy = this.shallowCopy.clone();
        return prototype;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p0 = Prototype.prototype;
        Prototype p1 = p0.clone();
        System.out.println(p0 == p1);
        System.out.println(p0.count == p1.count);
        System.out.println(p0.shallowCopy == p1.shallowCopy);
    }

}

class ShallowCopy implements Cloneable {

    public ShallowCopy clone() throws CloneNotSupportedException {
        return (ShallowCopy) super.clone();
    }

}