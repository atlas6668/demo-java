package com.atlas.java.pattern.behavioral.chain_of_responsibility.sub;

import com.atlas.java.pattern.behavioral.chain_of_responsibility.Support;
import com.atlas.java.pattern.behavioral.chain_of_responsibility.Trouble;

/**
 * @author sunwenming
 * @date 2023/3/14.
 */
public class OddSupport extends Support {
    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) {
            return true;
        }
        return false;
    }
}
