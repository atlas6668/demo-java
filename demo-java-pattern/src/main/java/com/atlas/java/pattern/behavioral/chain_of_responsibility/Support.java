package com.atlas.java.pattern.behavioral.chain_of_responsibility;

/**
 * @author sunwenming
 * @date 2023/3/14.
 */
public abstract class Support {

    private String name;

    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (null != next) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    /**
     * 解决问题的步骤
     * @param trouble 问题
     * @return
     */
    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + "is resolved by " + this.name + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + "cannot be resolved.");
    }

}
