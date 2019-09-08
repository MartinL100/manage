package com.cong.checktime.service.impl;


import com.cong.checktime.dao.IUserDao;
import com.cong.checktime.entity.UserEntity;
import com.cong.checktime.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = " userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;
    @Override
    public UserEntity register(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public UserEntity login(String pwd, String userName) {
        return userDao.findByPwdAndUserName(pwd,userName);
    }
}
