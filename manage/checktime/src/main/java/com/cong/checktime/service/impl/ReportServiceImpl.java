package com.cong.checktime.service.impl;

import com.cong.checktime.dao.IReportDao;
import com.cong.checktime.entity.ReportEntity;
import com.cong.checktime.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "reportService")
public class ReportServiceImpl implements IReportService {
    @Autowired
    IReportDao reportDao;
    @Override
    public ReportEntity saveReport(ReportEntity reportEntity) {
        return reportDao.save(reportEntity);
    }

    @Override
    public Page<ReportEntity> findAllReport(Pageable pageable) {
        return (Page<ReportEntity>) reportDao.findAll(pageable);
    }

    @Override
    public List<ReportEntity> findAll() {
        return reportDao.findAll();
    }
}
