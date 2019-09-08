package com.cong.checktime.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user_report")
public class ReportEntity {
    @Id
    @GenericGenerator(name = "uid" ,strategy = "uuid")
    @GeneratedValue(generator = "uid")
    @Column(length = 32)
    private String reportId;
    /**消费时间*/
    @Column(length = 64)
    private String reportTime;
    /**记录时间*/
    @Column(length = 64)
    private String recordTime;
    /**报账类型*/
    @Column(length = 64)
    private String reportType;
    /**报账原因说明*/
    private String reportWhy;
    /**金额*/
    @Column()
    private double reportMoney;
    /**备注*/
    @Column(columnDefinition = "text")
    private String reportInfo;
    @Column(length = 64)
    private String startLocation;
    @Column(length = 64)
    private String endLocation;
    @Column(length = 64)
    private String checkStaue;
    /**报账人*/
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;
    public String getCheckStaue() {
        return checkStaue;
    }

    public void setCheckStaue(String checkStaue) {
        this.checkStaue = checkStaue;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }


    public String getReportWhy() {
        return reportWhy;
    }

    public void setReportWhy(String reportWhy) {
        this.reportWhy = reportWhy;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public double getReportMoney() {
        return reportMoney;
    }

    public void setReportMoney(double reportMoney) {
        this.reportMoney = reportMoney;
    }

    public String getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(String reportInfo) {
        this.reportInfo = reportInfo;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
