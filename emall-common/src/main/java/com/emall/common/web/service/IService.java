package com.emall.common.web.service;

import java.util.List;

/**
 * @ClassName IService
 * @Description Service 抽象接口
 * @Author weibin
 * @Date 2018/12/7 18:32
 * @Version 1.0
 **/
public interface IService<T,PK> {

    /**
     * 插入数据
     * @param data 数据
     * @return 返回操作记录数
     */
    int insert(T data);

    /**
     * 批量插入数据
     * @param datas 数据
     * @return 返回操作记录数
     */
    int insertBatch(List<T> datas);

    /**
     * 更新数据
     * 主键为更新条件，其他为数据
     * @param data 数据
     * @return 更新结果行数
     */
    int update(T data);

    /**
     * 通过主键删除记录
     * @param ids  主键
     * @return    删除行数
     */
    int delete(PK... ids);

    /**
     * 通过主键使记录无效（相当于逻辑删除）
     * @param ids  主键
     * @return    更新结果行数
     */
    int disable(PK... ids);

    /**
     * 通过主键使记录有效（相当于恢复逻辑删除）
     * @param ids  主键
     * @return    更新结果行数
     */
    int enable(PK... ids);

    /**
     * 通过主键获取数据
     * @param id  主键
     * @return    一行数据
     */
    T get(PK id);

    /**
     * 通过主键获取数据
     * @param ids  主键
     * @return List 如果无数据时，返回是长度为0的List对象
     */
    List<T> getByIds(PK... ids);

    /**
     * 通过Model获取数据
     * @param data  Model数据，非空字段都做为条件查询
     * @return    数据列表
     */
    List<T> selectAll(T data);

}
