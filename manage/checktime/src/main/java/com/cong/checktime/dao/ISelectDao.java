package com.cong.checktime.dao;

import com.cong.checktime.entity.SelectEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ISelectDao extends CrudRepository<SelectEntity,String> {
    List<SelectEntity>findBySelectName(String selectKey);
    SelectEntity findBySelectNameAndSelectKey(String selectName, String selectKey);
}
