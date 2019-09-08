package com.cong.checktime.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_user")
public class UserEntity {
    @Id
   @GenericGenerator(name = "uid",strategy = "uuid")
   @GeneratedValue(generator = "uid")
   @Column(length = 32)
    private String userId;
    @Column(length = 64)
    private String userName;
    @Column(length = 64)
    private String realName;
    @Column(length = 128)
    private String tel;
    @Column(length = 64)
    private  String pwd;
    @Column(length = 64)
    private String registerTime;
    @OneToMany(mappedBy = "userEntity")
    @JsonIgnore
    private List<ReportEntity>reportEntities;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }


    public List<ReportEntity> getReportEntities() {
        return reportEntities;
    }

    public void setReportEntities(List<ReportEntity> reportEntities) {
        this.reportEntities = reportEntities;
    }
}
