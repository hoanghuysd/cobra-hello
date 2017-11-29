package org.cobra.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {
    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    // inject via application.properties
    @Value("${welcome.message}")
    private String message = "Hello World";

    @RequestMapping("/hello")
    public String welcome(Map<String, Object> model) {
        logger.info("Welcome {}", "testing");
        model.put("message", this.message);
        return "hello";
    }

}
