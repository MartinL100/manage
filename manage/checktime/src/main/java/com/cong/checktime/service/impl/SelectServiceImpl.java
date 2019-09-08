package com.cong.checktime.service.impl;

import com.cong.checktime.dao.ISelectDao;
import com.cong.checktime.entity.SelectEntity;
import com.cong.checktime.service.ISelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "selectService")
public class SelectServiceImpl implements ISelectService {
    @Autowired
    ISelectDao selectDao;
    @Override
    public void addSelect(SelectEntity selectEntity) {
        selectDao.save(selectEntity);
    }

    @Override
    public void delSelect(String selectId) {
        selectDao.deleteById(selectId);
    }

    @Override
    public List<SelectEntity> findAllByName(String selectName) {
        return selectDao.findBySelectName(selectName);
    }

    public List<SelectEntity> findAll(){
        return (List<SelectEntity>) selectDao.findAll();
    }

    @Override
    public String findValue(String selectName, String selectKey) {

        return selectDao.findBySelectNameAndSelectKey(selectName,selectKey).getSelectValue();
    }
}
