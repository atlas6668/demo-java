package com.atlas.java.io.serializable;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by sunwenming on 2017/12/2.
 */
public class IOutil {

    public static void store(Member member) throws IOException {
        File file = new File("/Users/sunwenming/Downloads/javatrip/Member.temp");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(member);
        objectOutputStream.close();
    }

    public static Member load() throws IOException, ClassNotFoundException {
        File file = new File("/Users/sunwenming/Downloads/javatrip/Member.temp");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object o = objectInputStream.readObject();
        Member member = (Member) o;
        objectInputStream.close();
        return member;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Member member = new Member();
        member.setName("陈圆圆");
        member.setMobile("13457063402");
        member.setBirth(19920218);
        IOutil.store(member);

        member = IOutil.load();
        System.out.print(member.getName());
        System.out.print(" ");
        System.out.print(member.getMobile());
        System.out.print(" ");
        System.out.println(member.getBirth());

    }

}
