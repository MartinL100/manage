package com.cong.checktime.service;
import com.cong.checktime.entity.ReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IReportService {
    /**
     * 增加记录
     * @param reportEntity
     * @return
     */
    ReportEntity saveReport(ReportEntity reportEntity);

    /**
     * 分页查找所有记录
     * @return
     */
    Page<ReportEntity> findAllReport(Pageable pageable);

    /**
     * 查找所有记录
     * @return
     */
    List<ReportEntity> findAll();

}
