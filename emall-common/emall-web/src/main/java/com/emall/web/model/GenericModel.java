package com.emall.web.model;

import com.emall.core.annotation.JsonUserFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName GenericModel
 * @Description 通用实体对象
 * @Author weibin
 * @Date 2018/12/7 20:00
 * @Version 1.0
 **/
public class GenericModel<PK> implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键ID
    @JsonSerialize(using=ToStringSerializer.class)
    protected PK id;

    protected String traceId;

    /**
     * 创建人
     */
    @JsonUserFormat
    protected String createBy;

    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    protected Timestamp createDate;

    /**
     * 修改人
     */
    @JsonUserFormat
    protected String updateBy;

    /**
     * 修改日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    protected Timestamp updateDate;

    /**
     * 是否可用, 1：有效，0：失效
     */
    protected int enabledFlag = 1;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public int getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(int enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}
