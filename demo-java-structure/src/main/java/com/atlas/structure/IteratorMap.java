package com.atlas.structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by sunwenming on 2017/9/11.
 */
public class IteratorMap {

    public static void main(String[] args){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < 10; i++){
            map.put(i, -i);
        }

        // 1
        for(Integer i : map.keySet()){
            System.out.println("1 --> " + i + ":" + map.get(i));
        }
        // 2
        Iterator<Integer> iterator = map.keySet().iterator();
        int i;
        while(iterator.hasNext()){
            i = iterator.next();
            System.out.println("2 --> " + i + ":" + map.get(i));
        }
        // 3
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println("3 --> " + entry.getKey() + ":" + entry.getValue());
        }
    }
}
