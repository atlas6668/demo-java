package com.atlas.java.io.serializable;

import java.io.Serializable;

/**
 * Created by sunwenming on 2017/12/2.
 */
public class Member implements Serializable {

    private static final long serialVersionUID = -5522615225280711491L;

    private String name;

    private String mobile;

    private int birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }
}
