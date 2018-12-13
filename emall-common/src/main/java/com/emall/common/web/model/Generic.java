package com.emall.common.web.model;

/**
 * @ClassName Generic
 * @Description 通用http 请求对象封装
 * @Author weibin
 * @Date 2018/12/10 18:24
 * @Version 1.0
 **/
public abstract class Generic{

    // 当前页
    private int pageNum = 1;
    // 每页查询数
    private int pageSize = 10;
    // 是否从ES 查询
    private String eaQuery = "N";

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getEaQuery() {
        return eaQuery;
    }

    public void setEaQuery(String eaQuery) {
        this.eaQuery = eaQuery;
    }
}
