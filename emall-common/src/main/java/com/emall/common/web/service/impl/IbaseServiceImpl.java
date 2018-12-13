package com.emall.common.web.service.impl;

import com.emall.common.core.exception.ApplicationException;
import com.emall.common.log.LogUtils;
import com.emall.common.web.mapper.BaseMapper;
import com.emall.common.web.model.Generic;
import com.emall.common.web.model.PageInfo;
import com.emall.common.web.model.ResponseCode;
import com.emall.common.web.service.IBaseService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IbaseServiceImpl
 * @Description 通用业务层接口实现类
 * @Author weibin
 * @Date 2018/12/10 18:30
 * @Version 1.0
 **/
public abstract class IbaseServiceImpl<M extends BaseMapper<T>, T> implements IBaseService<T> {

    // 返回一个BaseMapper对象,方便基本方法的操作
    abstract public M getMapper();

    @Override
    public void save(T entity) {
        try{
            getMapper().insert(entity);
        }catch (Exception e){
            LogUtils.errorLog(ResponseCode.INSERT_EXCEPTION.getMessage(),e);
            throw new ApplicationException(ResponseCode.INSERT_EXCEPTION);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED,timeout = 20,rollbackFor = ApplicationException.class)
    @Override
    public void batchSave(Collection<T> entities) {
        try{
            getMapper().batchInserts(entities);
        }catch (Exception e){
            LogUtils.errorLog(ResponseCode.INSERT_BATCH_EXCEPTION.getMessage(),e);
            throw new ApplicationException(ResponseCode.INSERT_BATCH_EXCEPTION);
        }
    }

    @Override
    public void delete(T entity) {
        try{
            getMapper().deleteByEntity(entity);
        }catch (Exception e){
            LogUtils.errorLog(ResponseCode.DELETE_EXCEPTION.getMessage(),e);
            throw new ApplicationException(ResponseCode.DELETE_EXCEPTION);
        }
    }

    @Override
    public void deleteById(Serializable id) {
        try{
            getMapper().deleteById(id);
        }catch (Exception e){
            LogUtils.errorLog(ResponseCode.DELETE_EXCEPTION.getMessage(),e);
            throw new ApplicationException(ResponseCode.DELETE_EXCEPTION);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED,timeout = 20,rollbackFor = ApplicationException.class)
    @Override
    public void batchDelete(Collection<Serializable> ids) {
        try{
            getMapper().batchDeleteByIds(ids);
        }catch (Exception e){
            LogUtils.errorLog(ResponseCode.DELETE_BATCH_EXCEPTION.getMessage(),e);
            throw new ApplicationException(ResponseCode.DELETE_BATCH_EXCEPTION);
        }
    }

    @Override
    public void updateById(T entity) {
        try{
            getMapper().updateById(entity);
        }catch (Exception e){
           LogUtils.errorLog(ResponseCode.UPDATE_EXCEPTION.getMessage(),e);
           throw new ApplicationException(ResponseCode.UPDATE_EXCEPTION);
        }
    }

    @Override
    public void updateFilterNullById(T entity) {
        try{
            getMapper().updateFilterNullById(entity);
        }catch (Exception e){
            LogUtils.errorLog(ResponseCode.UPDATE_EXCEPTION.getMessage(),e);
            throw new ApplicationException(ResponseCode.UPDATE_EXCEPTION);
        }
    }

    @Override
    public void update(T entity) {
        try{
            getMapper().update(entity);
        }catch (Exception e){
            LogUtils.errorLog(ResponseCode.UPDATE_EXCEPTION.getMessage(),e);
            throw new ApplicationException(ResponseCode.UPDATE_EXCEPTION);
        }
    }

    @Override
    public void updateFilterNull(T entity) {
        try{
            getMapper().updateFilterNull(entity);
        }catch (Exception e){
            LogUtils.errorLog(ResponseCode.UPDATE_EXCEPTION.getMessage(),e);
            throw new ApplicationException(ResponseCode.UPDATE_EXCEPTION);
        }
    }

    @Override
    public T selectOne(T entity) {
        return getMapper().selectOne(entity);
    }

    @Override
    public T selectById(Serializable id) {
        return getMapper().selectById(id);
    }

    @Override
    public T selectOne(Map<String, Object> params) {
        return getMapper().selectOne(params);
    }

    @Override
    public List<T> selectList(Collection<Serializable> ids) {
        return getMapper().batchQueryByIds(ids);
    }

    @Override
    public List<T> selectList(T entity) {
        return getMapper().selectByEntity(entity);
    }

    @Override
    public List<T> selectList(Map<String, Object> params) {
        return getMapper().selectByMap(params);
    }

    @Override
    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    public PageInfo<T> selectPage(PageInfo<T> pageInfo,Generic condition) {
        List<T> data = getMapper().selectPage(condition);
        Long total = getMapper().selectCount(condition);
        pageInfo.setPageNum(condition.getPageNum());
        pageInfo.setPageSize(condition.getPageSize());
        pageInfo.setRows(data);
        pageInfo.setTotals(null == total ? 0 : total);
        return pageInfo;
    }
}
