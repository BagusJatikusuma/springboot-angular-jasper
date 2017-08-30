package com.pemda.ekinerja;

import com.pemda.ekinerja.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bagus on 29/08/17.
 */
@Component("EmailApplication")
public class EmailApplication {
    @Autowired
    EmailService emailService;

    public void sendEmail() {
        emailService.sendEmail();
    }
}
