package com.cong.checktime.controller;

import com.cong.checktime.entity.ReportEntity;
import com.cong.checktime.entity.UserEntity;
import com.cong.checktime.service.IReportService;
import com.cong.checktime.service.ISelectService;
import com.cong.checktime.util.StringInfos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.List;

@RestController
public class ReportController {
    @Autowired
    IReportService reportService;
    @Autowired
    ISelectService selectService;
    @Autowired
    ObjectMapper objectMapper;
@RequestMapping(value = "saveReport")
public String saveReport(String reportInfo, HttpServletRequest request) throws IOException {
    String info ="";
    ReportEntity reportEntity = objectMapper.readValue(reportInfo,ReportEntity.class);
    reportEntity.setRecordTime(new Timestamp(System.currentTimeMillis()).toString());
    UserEntity userEntity= (UserEntity) request.getSession().getAttribute("user");
    reportEntity.setUserEntity(userEntity);
    reportEntity.setCheckStaue("0");
    ReportEntity report=reportService.saveReport(reportEntity);
    if (report==null){
        info= StringInfos.SAVE_FAIL;
    }
    return info;
}
@RequestMapping("findAll")
public  String findAll(String page,String limit) throws JsonProcessingException {
    Pageable pageable = PageRequest.of(Integer.parseInt(page)-1,Integer.parseInt(limit));
    Page<ReportEntity> reportEntities =reportService.findAllReport(pageable);
    for (ReportEntity r:reportEntities.getContent()
         ) {
        r.setReportType(selectService.findValue("BZ",r.getReportType()));
    }
   String info= objectMapper.writeValueAsString(reportEntities.getContent());
    info= "{\"code\":0,\"msg\":\"\",\"count\":"+reportEntities.getTotalElements()+",\"data\":"+info+"}";
    return info;

}


@RequestMapping("downLoad")
    public void downLoad(HttpServletResponse response) throws IOException {
    List<ReportEntity> reportEntities =reportService .findAll();
    if (reportEntities==null){
        return;
    }
    //创建excel
    Workbook workbook = new HSSFWorkbook();
    //创建工作簿
    Sheet sheet = workbook.createSheet("newSheet");
    Row rowInit =sheet.createRow(0);
    rowInit.createCell(0).setCellValue("申请人");
    rowInit.createCell(1).setCellValue("消费时间");
    rowInit.createCell(2).setCellValue("上报时间");
    rowInit.createCell(3).setCellValue("消费类型");
    rowInit.createCell(4).setCellValue("消费原因");
    rowInit.createCell(5).setCellValue("消费金额");
    rowInit.createCell(6).setCellValue("备注");
    rowInit.createCell(7).setCellValue("起点");
    rowInit.createCell(8).setCellValue("终点");

   for (int i = 0;i<reportEntities.size();i++){
       Row row =sheet.createRow(i+1);
       row.createCell(0).setCellValue(reportEntities.get(i).getUserEntity().getUserName());
       row.createCell(1).setCellValue(reportEntities.get(i).getReportTime());
       row.createCell(2).setCellValue(reportEntities.get(i).getRecordTime());
       row.createCell(3).setCellValue(selectService.findValue("BZ",reportEntities.get(i).getReportType()));
       row.createCell(4).setCellValue(reportEntities.get(i).getReportWhy());
       row.createCell(5).setCellValue(reportEntities.get(i).getReportMoney());
       row.createCell(6).setCellValue(reportEntities.get(i).getReportInfo());
       row.createCell(7).setCellValue(reportEntities.get(i).getStartLocation());
       row.createCell(8).setCellValue(reportEntities.get(i).getEndLocation());

   }
    response.setContentType("application/vnd.ms-excel;charset=utf-8");
    response.setHeader("Content-Disposition", "attachment;filename="
            + new String((System.currentTimeMillis() + ".xls").getBytes(), "iso-8859-1"));
    OutputStream outputStream = response.getOutputStream();
   workbook.write(outputStream);
}

}
