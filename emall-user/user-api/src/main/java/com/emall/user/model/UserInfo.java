package com.emall.user.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;

/**
 * @ClassName UserInfo
 * @Description 用户实体
 * @Author weibin
 * @Date 2018/11/26 21:46
 * @Version 1.0
 **/
public class UserInfo implements Serializable {

    @JsonSerialize(using=ToStringSerializer.class)
    private Long id;

    private String name;

    private int age = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
