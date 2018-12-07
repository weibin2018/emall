package com.emall.common.web.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @ClassName GenericService
 * @Description Service基础类，封装单表的insert/update/delete操作
 * @Author weibin
 * @Date 2018/12/7 18:29
 * @Version 1.0
 **/
public abstract class GenericService<T, PK> implements IService<T,PK>{

    private BaseMapper<T> baseMapper;

    public GenericService(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int insert(T data) {
        setDefault(data, true);
        return this.baseMapper.insert(data);
    }

    @Override
    public int insertBatch(List<T> datas) {
        return 0;
    }

    @Override
    public int update(T data) {
        return 0;
    }

    @Override
    public int delete(PK... ids) {
        return 0;
    }

    @Override
    public int disable(PK... ids) {
        return 0;
    }

    @Override
    public int enable(PK... ids) {
        return 0;
    }

    @Override
    public T get(PK id) {
        return null;
    }

    @Override
    public List<T> getByIds(PK... ids) {
        return null;
    }

    @Override
    public List<T> selectAll(T data) {
        return null;
    }
}
