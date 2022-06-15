package com.atlas.java.io.serializable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunwenming on 2017/12/2.
 */
public class JSONutil {

    public static void store(List<Member> members) throws IOException {
        File file = new File("/Users/sunwenming/Downloads/javatrip/Members.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for(Member member : members){
            bufferedWriter.write(new StringBuffer("{")
                    .append("\"").append("name").append("\"")
                    .append(":")
                    .append("\"").append(member.getName()).append("\"")
                    .append(",")
                    .append("\"").append("mobile").append("\"")
                    .append(":")
                    .append("\"").append(member.getMobile()).append("\"")
                    .append(",")
                    .append("\"").append("birth").append("\"")
                    .append(":")
                    .append(member.getBirth())
                    .append("}").append(";").append("\r\n").toString());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public static List<Member> load() throws IOException, ClassNotFoundException {
        File file = new File("/Users/sunwenming/Downloads/javatrip/Members.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<Member> members = new ArrayList<Member>();
        String str;
        String[] arr;
        Member member;
        while(null != (str = bufferedReader.readLine()) && str.length() > 0){
            member = new Member();
            arr = str.substring(str.length() > 2 ? 1 : str.length() - 1, str.length() - 2).split(",");
            member.setName(arr[0].split(":")[1]);
            member.setMobile(arr[1].split(":")[1]);
            member.setBirth(Integer.parseInt(arr[2].split(":")[1]));
            members.add(member);
        }
        bufferedReader.close();
        return members;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Member> members = new ArrayList<Member>();
        Member member0 = new Member();
        member0.setName("洪君君");
        member0.setMobile("13388428688");
        member0.setBirth(19830218);
        members.add(member0);
        Member member1 = new Member();
        member1.setName("施任远");
        member1.setMobile("13735510833");
        member1.setBirth(19920401);
        members.add(member1);
        Member member2 = new Member();
        member2.setName("陈圆圆");
        member2.setMobile("13457063402");
        member2.setBirth(19920218);
        members.add(member2);
        JSONutil.store(members);

        members = JSONutil.load();
        for(Member member : members){
            System.out.print(member.getName());
            System.out.print(" ");
            System.out.print(member.getMobile());
            System.out.print(" ");
            System.out.println(member.getBirth());
        }


    }

}
