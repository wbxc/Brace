package com.xc.brace.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by familylove on 2016/6/3.
 */
public class Person extends BmobObject{

    private String name ;

    private String age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
