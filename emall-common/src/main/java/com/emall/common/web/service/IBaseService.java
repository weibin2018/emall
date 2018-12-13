package com.emall.common.web.service;


import com.emall.common.web.model.Generic;
import com.emall.common.web.model.PageInfo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GenericService
 * @Description Service基础类，封装单表的insert/update/delete操作
 * @Author weibin
 * @Date 2018/12/7 18:29
 * @Version 1.0
 **/
public interface IBaseService<T>{

    /**
     *@Description 保存记录
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:03
     *@Return void
     **/
    void save(T entity);
    /**
     *@Description 批量保存
     *@Param [entities]
     *@Author weibin
     *@Date 2018/12/10 18:40
     *@Return void
     **/
    void batchSave(Collection<T> entities);
    /**
     *@Description 删除记录
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:08
     *@Return void
     **/
    void delete(T entity);

    /**
     *@Description 删除记录
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:08
     *@Return void
     **/
    void deleteById(Serializable id);
    /**
     *@Description 批量删除
     *@Param [ids]
     *@Author weibin
     *@Date 2018/12/10 18:10
     *@Return void
     **/
    void batchDelete(Collection<Serializable> ids);
    /**
     *@Description 根据ID更新
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:11
     *@Return void
     **/
    void updateById(T entity);
    /**
     *@Description 根据ID更新,排除Null
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:11
     *@Return void
     **/
    void updateFilterNullById(T entity);
    /**
     *@Description 更新
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:12
     *@Return void
     **/
    void update(T entity);
    /**
     *@Description 更新排除null
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:13
     *@Return void
     **/
    void updateFilterNull(T entity);
    /**
     *@Description 查询记录 （按搜索条件）
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:16
     *@Return T
     **/
    T selectOne(T entity);
    /**
     *@Description 通过ID查询 （按ID查询）
     *@Param [id]
     *@Author weibin
     *@Date 2018/12/10 18:16
     *@Return T
     **/
    T selectById(Serializable id);
    /**
     *@Description 查询单条记录（按搜索条件）
     *@Param [params]
     *@Author weibin
     *@Date 2018/12/10 18:17
     *@Return T
     **/
    T selectOne(Map<String,Object> params);
    /**
     *@Description 通过ID获取多条记录
     *@Param [ids]
     *@Author weibin
     *@Date 2018/12/10 18:19
     *@Return List<T>
     **/
    List<T> selectList(Collection<Serializable> ids);
    /**
     *@Description 按条件查询
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:19
     *@Return java.util.List<T>
     **/
    List<T> selectList(T entity);
    /**
     *@Description 按条件查询
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:19
     *@Return java.util.List<T>
     **/
    List<T> selectList(Map<String,Object> params);
    /**
     *@Description 查询所有记录
     *@Param []
     *@Author weibin
     *@Date 2018/12/10 18:20
     *@Return java.util.List<T>
     **/
    List<T> selectAll();

    /**
     *@Description 分页查询
     *@Param [condition]
     *@Author weibin
     *@Date 2018/12/10 18:22
     *@Return com.emall.common.web.model.PageInfo<T>
     **/
    PageInfo<T> selectPage(PageInfo<T> pageInfo,Generic condition);
}
