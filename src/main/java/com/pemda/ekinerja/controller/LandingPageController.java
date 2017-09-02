package com.pemda.ekinerja.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bagus on 30/08/17.
 */
@Controller
public class LandingPageController {
    public static final Logger LOGGER = LoggerFactory.getLogger(LandingPageController.class);

    @RequestMapping("/")
    String home(ModelMap modal) {
        LOGGER.info("home redirect");
        modal.addAttribute("title","E-Kinerja Web APP");
        return "index";
    }

    @RequestMapping("/test")
    String test() {
        LOGGER.info("send test.ftl file");
        return "test";
    }

    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }
}
