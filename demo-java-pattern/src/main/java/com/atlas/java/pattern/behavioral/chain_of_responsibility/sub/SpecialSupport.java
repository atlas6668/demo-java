package com.atlas.java.pattern.behavioral.chain_of_responsibility.sub;

import com.atlas.java.pattern.behavioral.chain_of_responsibility.Support;
import com.atlas.java.pattern.behavioral.chain_of_responsibility.Trouble;

/**
 * @author sunwenming
 * @date 2023/3/14.
 */
public class SpecialSupport extends Support {

    private int number;

    public SpecialSupport(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() == number) {
            return true;
        }
        return false;
    }
}
