package com.template.demos.admin.dao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public interface BaseDao<T> {

    int save(T t);

    void save(Map<String, Object> map);

    void saveBatch(List<T> list);

    int update(T t);

    int update(Map<String, Object> map);

    int delete(Object id);

    int delete(Map<String, Object> map);

    int deleteBatch(Object[] id);

    T queryObject(Object id);

    List<T> queryList(Map<String, Object> map);
    List<T> queryListCount(Map<String, Object> map, Boolean isCount);
    List<T> queryAll(Map<String, Object> map);
    List<T> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int queryTotal();
}
