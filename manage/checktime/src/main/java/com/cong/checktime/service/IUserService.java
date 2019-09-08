package com.cong.checktime.service;

import com.cong.checktime.entity.UserEntity;

public interface IUserService {
    /**
     * 注册
     * @param userEntity
     * @return
     */
    UserEntity register(UserEntity userEntity);

    /**
     * 登录
     * @param userName
     * @param pwd
     * @return
     */
    UserEntity login(String pwd, String userName);
}
