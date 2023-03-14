package com.atlas.java.pattern.behavioral.chain_of_responsibility;

import com.atlas.java.pattern.behavioral.chain_of_responsibility.sub.LimitSupport;
import com.atlas.java.pattern.behavioral.chain_of_responsibility.sub.NoSupport;
import com.atlas.java.pattern.behavioral.chain_of_responsibility.sub.OddSupport;
import com.atlas.java.pattern.behavioral.chain_of_responsibility.sub.SpecialSupport;

/**
 * @author sunwenming
 * @date 2023/3/14.
 */
public class Main {

    public static void main(String[] args) {
        Support a = new NoSupport("A");
        Support b = new LimitSupport("B", 100);
        Support c = new SpecialSupport("C", 429);
        Support d = new LimitSupport("D", 200);
        Support e = new OddSupport("E");
        Support f = new LimitSupport("F", 300);

        a.setNext(b).setNext(c).setNext(d).setNext(e).setNext(f);

        for (int i = 0; i < 500; i += 33) {
            a.support(new Trouble(i));
        }
    }

}
