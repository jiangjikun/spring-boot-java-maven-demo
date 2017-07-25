package com.spiderdt.common.controller;

import com.spiderdt.common.components.Slog;
import com.spiderdt.common.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kun on 2017/7/17.
 */
// @RestController 相当于@Controller和 @ResponseBody的结合
@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    Slog slog;
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        slog.info("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
