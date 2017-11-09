package com.javazhan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yando on 2017/11/9.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/helloWorld")
    public String helloWolrd() {
        return "HelloWorld!!!" ;
    }
}
