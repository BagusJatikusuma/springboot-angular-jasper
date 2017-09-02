package com.pemda.ekinerja;

import com.pemda.ekinerja.model.Employee;
import com.pemda.ekinerja.service.EmployeeService;
import com.pemda.ekinerja.utilities.DateConverter;
import com.pemda.ekinerja.wrapper.report.EmployeeReportBean;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.view.JasperDesignViewer;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by bagus on 30/08/17.
 */
@Component("ReportApplication")
public class ReportApplication {
    @Autowired
    private EmployeeService employeeService;

    public void createReport() {
        List<Employee> employees = employeeService.getAll();
        List<EmployeeReportBean> employeeReportBeans = new ArrayList<>();

        for (Employee employee : employees) {
            employeeReportBeans.add(new EmployeeReportBean(
                    employee.getId(),
                    employee.getName(),
                    employee.getBirthday(),
                    employee.getLocation(),
                    employee.getJabatan().getName(),
                    employee.getDepartement().getName()
            ));
        }

        InputStream employeeReportStream = getClass().getClassLoader().getResourceAsStream("xml/EmployeeReport.jrxml");

        if (employeeReportStream == null)
            System.out.println("file not found");

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);

            JRSaver.saveObject(jasperReport, "employeeReport.jasper");
            JRDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(employeeReportBeans);

            Map parameters = new HashMap();
            parameters.put("title","PT. SEJAHTERA SELALU");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            parameters.put("report_description",
                            "laporan data karyawan periode : "
                            +DateConverter.getMonthAsString(calendar)
                            + " - "
                            + DateConverter.getYearAsString(calendar));

            parameters.put("header_column_id", "id");
            parameters.put("header_column_name", "name");
            parameters.put("header_column_birthday", "birth day");
            parameters.put("header_column_address", "address");
            parameters.put("header_column_jabatan", "jabatan");
            parameters.put("header_column_departement", "departement");

            JasperPrint jasperPrint = JasperFillManager.
                    fillReport(
                        jasperReport,
                        parameters,
                        beanCollectionDataSource);

            JRPdfExporter exporter = new JRPdfExporter();

            try {
                File employeeReportPdf = File.createTempFile(
                        "employee_report.",
                        ".pdf",
                        new File("/home/bagus"));
                JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(employeeReportPdf));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
