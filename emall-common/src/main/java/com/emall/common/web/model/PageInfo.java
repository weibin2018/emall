package com.emall.common.web.model;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageInfo
 * @Description 分页对象
 * @Author weibin
 * @Date 2018/12/10 17:08
 * @Version 1.0
 **/
public class PageInfo<T> implements Serializable {

    //当前页
    private int pageNum = 1;
    //每页查询数
    private int pageSize = 10;
    //分页数据
    private List<T> rows;
    //总记录
    private long totals = 0;
    //总页码
    private int pages;
    //是否有上一页
    private boolean hasPrevPage = false;
    //是否有下一页
    private boolean hasNextPage = true;
    //是否是首页
    private boolean firstPage = true;
    //是否最后一页
    private boolean lastPage = false;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if(pageNum > 1){
            this.pageNum = pageNum;
            this.firstPage = false;
            this.hasPrevPage = true;
        }else{
            this.hasPrevPage = false;
            this.firstPage = true;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize > 0){
            this.pageSize = pageSize;
        }
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotals() {
        return totals;
    }

    public void setTotals(long totals) {
        this.totals = totals;
        if(totals % pageSize == 0){
            if(pageNum == totals / pageSize){
                this.hasNextPage = false;
                this.lastPage = true;
            }else{
                this.hasNextPage = true;
                this.lastPage = false;
            }
            this.pages = (int)totals / pageSize;
        }else{
            if(pageNum == (totals / pageSize + 1)){
                this.hasNextPage = false;
                this.lastPage = true;
            }else{
                this.hasNextPage = true;
                this.lastPage = false;
            }
            this.pages = (int)(totals / pageSize + 1);
        }
    }

    public int getPages() {
        return pages;
    }

    public boolean isHasPrevPage() {
        return hasPrevPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }
}
