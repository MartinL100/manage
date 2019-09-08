package com.cong.checktime.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class PowerEntity {
    @Id
    @GenericGenerator(name = "uid",strategy = "uuid")
    @GeneratedValue(generator = "uid")
    @Column(length = 32)
    private String powerId;
    @OneToOne
    private RoleEntity roleEntity;
    @Column(length = 64)
    private String powerName;
    @Column(length = 128)
    private String powerSource;
    @Column(length = 32)
    private String powerTag;

    public String getPowerId() {
        return powerId;
    }

    public void setPowerId(String powerId) {
        this.powerId = powerId;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    public String getPowerTag() {
        return powerTag;
    }

    public void setPowerTag(String powerTag) {
        this.powerTag = powerTag;
    }
}
