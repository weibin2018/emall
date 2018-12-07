package com.emall.common.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName GenericModel
 * @Description 通用实体对象
 * @Author weibin
 * @Date 2018/12/7 20:00
 * @Version 1.0
 **/
@Data
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
    protected String createdBy;

    /**
     * 创建日期
     */
    //@JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonDateFormat(value = "yyyy-MM-dd HH:mm:ss")
    protected Timestamp creationDate;

    /**
     * 修改人
     */
    //@JsonIgnore
    @JsonUserFormat
    protected String updatedBy;

    /**
     * 修改日期
     */
    //@JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonDateFormat(value = "yyyy-MM-dd HH:mm:ss")
    protected Timestamp updationDate;

    /**
     * 是否可用
     */
    //@JsonIgnore
    protected Long enabledFlag = 1L;
}
