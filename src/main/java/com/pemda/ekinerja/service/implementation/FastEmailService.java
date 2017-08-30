package com.pemda.ekinerja.service.implementation;

import com.pemda.ekinerja.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by bagus on 29/08/17.
 */
//@Service("FastEmailService")
public class FastEmailService implements EmailService {
    public static final Logger LOGGER = LoggerFactory.getLogger(FastEmailService.class);

    @Override
    public void sendEmail() {
        LOGGER.info("send email");
    }
}
