package com.pemda.ekinerja;

import com.pemda.ekinerja.service.EmailService;
import com.pemda.ekinerja.service.implementation.FastEmailService;
import com.pemda.ekinerja.service.implementation.GmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EkinerjaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EkinerjaApplication.class,args);

//		EmailApplication emailApplication = (EmailApplication) ctx.getBean("EmailApplication");
//		emailApplication.sendEmail();
//
//		ReportApplication reportApplication = (ReportApplication) ctx.getBean("ReportApplication");
//		reportApplication.createReport();
	}

}
