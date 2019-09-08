package com.cong.checktime.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

public class RoleEntity {
    @Id
    @GenericGenerator(name = "uid",strategy = "uuid")
    @GeneratedValue(generator = "uid")
    @Column(length = 32)
    private String roleId;
    @Column(length = 32)
    private String roleName;
    @OneToOne
    @JoinColumn()
    private UserEntity userEntity;
    @OneToMany(mappedBy = "roleEntity")
    private List<PowerEntity>powerEntities;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<PowerEntity> getPowerEntities() {
        return powerEntities;
    }

    public void setPowerEntities(List<PowerEntity> powerEntities) {
        this.powerEntities = powerEntities;
    }
}
