package com.cong.checktime.controller;

import com.cong.checktime.entity.UserEntity;
import com.cong.checktime.service.IUserService;
import com.cong.checktime.util.StringInfos;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;

@RestController
public class UserController {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    IUserService userService;
@RequestMapping("login")
    public String login(String data, HttpServletRequest request) throws IOException {
    UserEntity userEntity = objectMapper.readValue(data,UserEntity.class);
         String info = "";
        String userName=userEntity.getUserName();
        String passWord=userEntity.getPwd();
        UserEntity user=userService.login(passWord,userName);
      if (user==null){
          info= StringInfos.PASSWORD_ERROR;
      }else {
          request.getSession().setAttribute("user",user);
          info=StringInfos.LOGIN_SUCESSES;
      }
        return info;
    }

    @RequestMapping("register")
    public String register(String userInfo) throws IOException {
    String info ="";
        UserEntity userEntity =objectMapper.readValue(userInfo,UserEntity.class);
        userEntity.setRegisterTime(new Date(System.currentTimeMillis()).toString());
        UserEntity user= userService.register(userEntity);
        if (user==null){
            info = StringInfos.REGISTER_FAILE;
        }
    return info;
    }

}
