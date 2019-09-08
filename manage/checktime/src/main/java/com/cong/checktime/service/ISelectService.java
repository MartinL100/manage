package com.cong.checktime.service;

import com.cong.checktime.entity.SelectEntity;

import java.util.List;

public interface ISelectService {
    /**
     * 添加类型
     * @param selectEntity
     * @return
     */
    void addSelect(SelectEntity selectEntity);

    /**
     * 根据id删除类型
     * @param selectId
     */
    void delSelect(String selectId);

    /**
     * 根据类型查找该类所有下拉
     * @param
     * @return
     */
    List<SelectEntity>findAllByName(String selectName);

    /**
     * 查询所有
     * @return
     */
    List<SelectEntity> findAll();

    String findValue(String selectName, String selectKey);
}
