package com.emall.common.core.enums;

/**
 * @ClassName EnabledEnum
 * @Description 可用 / 不可用 枚举类
 * @Author weibin
 * @Date 2018/11/23 15:00
 * @Version 1.0
 **/
public enum EnabledEnum {

    ENABLED(1,"可用"),
    DISABLED(0,"不可用");

    private Integer value;
    private String name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private EnabledEnum(Integer value, String name) {
        this.setValue(value);
        this.setName(name);
    }
}
