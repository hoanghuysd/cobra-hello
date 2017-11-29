package org.cobra.web.controller;



import org.cobra.persistence.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class RestDemoController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger logger = LoggerFactory.getLogger(RestDemoController.class);

    @RequestMapping("/")
    public Student studenta(@RequestParam(value = "name", defaultValue = "HoangHuy") String name) {
        logger.debug("Welcome {}", "testing");
        logger.info("Welcome {}", "testing");
        logger.warn("Welcome {}", "testing");
        logger.error("Welcome {}", "testing");
        logger.trace("Welcome {}", "testing");
        return new Student((int) counter.incrementAndGet(), String.format(template, name), true);
    }

    @RequestMapping("/student")
    public Student student(@RequestParam(value = "name", defaultValue = "HoangHuy") String name) {
        return new Student((int) counter.incrementAndGet(), String.format(template, name), true);
    }
}
