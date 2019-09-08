package com.cong.checktime.dao;
import com.cong.checktime.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao  extends CrudRepository<UserEntity,String> {
    UserEntity findByPwdAndUserName(String pwd, String userName);
}
