package com.cong.checktime.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_select")
public class SelectEntity {
    @Id
    @GenericGenerator(name = "uid",strategy = "uuid")
    @GeneratedValue(generator = "uid")
    @Column(length = 32)
    private String selectId;
    @Column(length = 64)
    private String selectName;
    @Column(length = 64)
    private String selectKey;
    @Column(length = 64)
    private String selectValue;

    public String getSelectId() {
        return selectId;
    }

    public void setSelectId(String selectId) {
        this.selectId = selectId;
    }

    public String getSelectName() {
        return selectName;
    }

    public void setSelectName(String selectName) {
        this.selectName = selectName;
    }

    public String getSelectKey() {
        return selectKey;
    }

    public void setSelectKey(String selectKey) {
        this.selectKey = selectKey;
    }

    public String getSelectValue() {
        return selectValue;
    }

    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
    }
}
