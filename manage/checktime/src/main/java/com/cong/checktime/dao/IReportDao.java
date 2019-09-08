package com.cong.checktime.dao;
import com.cong.checktime.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IReportDao extends CrudRepository<ReportEntity,String>, JpaRepository<ReportEntity,String> {

}
