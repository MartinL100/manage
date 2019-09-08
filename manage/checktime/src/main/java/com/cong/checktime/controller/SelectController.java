package com.cong.checktime.controller;

import com.cong.checktime.entity.SelectEntity;
import com.cong.checktime.service.ISelectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SelectController {
    @Autowired
    ObjectMapper objectMapper ;
    @Autowired
    ISelectService selectService;
    @RequestMapping(value = "addSelect")
    public String addSelect(String selectInfo) throws IOException {
        String info ="succesess";
        SelectEntity selectEntity = objectMapper.readValue(selectInfo,SelectEntity.class);
        selectService.addSelect(selectEntity);
        return info;
    }


    @RequestMapping(value = "findAllByName/{selectName}")
    public String findAllByName(@PathVariable String selectName) throws JsonProcessingException {
        List<SelectEntity> selectEntities =selectService.findAllByName(selectName);
        return objectMapper.writeValueAsString(selectEntities);
    }
}
