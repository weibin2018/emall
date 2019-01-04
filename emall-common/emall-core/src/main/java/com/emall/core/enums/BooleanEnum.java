package com.emall.core.enums;

/**
 * @ClassName BooleanEnum
 * @Description boolean 类型枚举类
 * @Author weibin
 * @Date 2018/11/23 14:59
 * @Version 1.0
 **/
public enum BooleanEnum {

    Y("Y","是"),
    N("N","否"),
    TRUE("true","是"),
    FALSE("false","否");

    private String value;
    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private BooleanEnum(String value, String name) {
        this.setValue(value);
        this.setName(name);
    }
}
