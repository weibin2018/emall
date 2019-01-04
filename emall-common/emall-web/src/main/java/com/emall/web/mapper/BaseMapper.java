package com.emall.web.mapper;

import com.emall.web.model.GenericBO;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BaseMapper
 * @Description 持久层操作通用接口
 * @Author weibin
 * @Date 2018/12/10 16:26
 * @Version 1.0
 **/
public interface BaseMapper<T> {

    /**
     *@Description 插入一条记录
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 16:46
     *@Return int
     **/
    int insert(T entity);
    /**
     *@Description 批量插入
     *@Param [entities]
     *@Author weibin
     *@Date 2018/12/10 16:49
     *@Return int
     **/
    int batchInserts(Collection<T> entities);

    /**
     *@Description 根据 ID 删除
     *@Param [id]
     *@Author weibin
     *@Date 2018/12/10 16:46
     *@Return int
     **/
    int deleteById(Serializable id);

    /**
     *@Description 通过条件删除记录
     *@Param [whereConditions]
     *@Author weibin
     *@Date 2018/12/10 16:50
     *@Return int
     **/
    int deleteByMap(@Param("columnMap") Map<String, Object> whereConditions);
    /**
     *@Description 通过条件删除
     *@Param [entities]
     *@Author weibin
     *@Date 2018/12/10 16:52
     *@Return int
     **/
    int deleteByEntity(@Param("entity") T entity);

    /**
     *@Description 删除（根据ID 批量删除）
     *@Param [idList]
     *@Author weibin
     *@Date 2018/12/10 16:51
     *@Return int
     **/
    int batchDeleteByIds(@Param("idList") Collection<? extends Serializable> idList);
    /**
     *@Description 通过ID禁用记录
     *@Param [id]
     *@Author weibin
     *@Date 2018/12/10 17:14
     *@Return int
     **/
    int disableById(Serializable id);
    /**
     *@Description 通过ID批量禁用记录
     *@Param [ids]
     *@Author weibin
     *@Date 2018/12/10 17:17
     *@Return int
     **/
    int disableByIds(Collection<Serializable> ids);
    /**
     *@Description 通过ID启用记录
     *@Param [id]
     *@Author weibin
     *@Date 2018/12/10 17:17
     *@Return int
     **/
    int enableById(Serializable id);
    /**
     *@Description 通过ID批量启用记录
     *@Param [ids]
     *@Author weibin
     *@Date 2018/12/10 17:18
     *@Return int
     **/
    int enableByIds(Collection<Serializable> ids);

    /**
     *@Description 根据 ID 修改
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 16:51
     *@Return int
     **/
    int updateById(@Param("entity") T entity);
    /**
     *@Description 更新记录，排除NULL 字段
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:49
     *@Return int
     **/
    int updateFilterNullById(@Param("entity") T entity);

   /**
    *@Description 通过指定条件修改
    *@Param [entity, whereConditions]
    *@Author weibin
    *@Date 2018/12/10 16:53
    *@Return int
    **/
    int updateByMap(@Param("entity") T entity, @Param("whereConditions") Map whereConditions);
    /**
     *@Description 修改记录
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 16:55
     *@Return int
     **/
    int update(@Param("entity") T entity);
    /**
     *@Description 更新记录，排除NULL 字段
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 18:49
     *@Return int
     **/
    int updateFilterNull(@Param("entity") T entity);
    /**
     *@Description 通过主键ID查询
     *@Param [id]
     *@Author weibin
     *@Date 2018/12/10 16:55
     *@Return T
     **/
    T selectById(Serializable id);

    /**
     *@Description 查询（根据ID 批量查询）
     *@Param [idList]
     *@Author weibin
     *@Date 2018/12/10 16:56
     *@Return java.util.List<T>
     **/
    List<T> batchQueryByIds(@Param("idList") Collection<? extends Serializable> idList);

    /**
     *@Description 查询（根据 whereConditions 条件）
     *@Param [whereConditions]
     *@Author weibin
     *@Date 2018/12/10 16:57
     *@Return java.util.List<T>
     **/
    List<T> selectByMap(@Param("whereConditions") Map<String, Object> whereConditions);

    /**
     *@Description 查询（根据 entity 条件）
     *@Param [whereConditions]
     *@Author weibin
     *@Date 2018/12/10 16:57
     *@Return java.util.List<T>
     **/
    List<T> selectByEntity(@Param("entity") T entity);

    /**
     *@Description 根据条件查询一条记录
     *@Param [whereConditions]
     *@Author weibin
     *@Date 2018/12/10 16:59
     *@Return T
     **/
    T selectOne(@Param("whereConditions") Map<String, Object> whereConditions);

    /**
     *@Description 根据entity 查询一条记录
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 16:59
     *@Return T
     **/
    T selectOne(@Param("entity") T entity);

    /**
     *@Description 根据 where 条件查询总记录数
     *@Param [whereConditions]
     *@Author weibin
     *@Date 2018/12/10 17:01
     *@Return java.lang.Integer
     **/
    Long selectCount(@Param("whereConditions") Map<String, Object> whereConditions);

    /**
     *@Description 根据entity 查询总记录数
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 17:02
     *@Return java.lang.Long
     **/
    Long selectCount(@Param("entity") T entity);
    /**
     *@Description generic 查询总记录数
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 17:02
     *@Return java.lang.Long
     **/
    Long selectCount(@Param("generic") GenericBO generic);

    /**
     *@Description 查询全部
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 17:04
     *@Return java.util.List<T>
     **/
    List<T> selectAll();
    /**
     *@Description 查询全部
     *@Param [entity]
     *@Author weibin
     *@Date 2018/12/10 17:05
     *@Return java.util.List<java.lang.Object>
     **/
    List<Object> selectObjs();

    /**
     *@Description 根据 where 条件，查询全部记录（并翻页）
     *@Param [page, whereConditions]
     *@Author weibin
     *@Date 2018/12/10 17:10
     *@Return com.emall.common.web.model.PageInfo<T>
     **/
     List<T> selectPage(@Param("condition") GenericBO condition);

}
