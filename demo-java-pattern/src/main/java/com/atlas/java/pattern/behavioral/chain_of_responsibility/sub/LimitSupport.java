package com.atlas.java.pattern.behavioral.chain_of_responsibility.sub;

import com.atlas.java.pattern.behavioral.chain_of_responsibility.Support;
import com.atlas.java.pattern.behavioral.chain_of_responsibility.Trouble;

/**
 * @author sunwenming
 * @date 2023/3/14.
 */
public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        }
        return false;
    }
}
