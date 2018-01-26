package com.javakz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 10:35 2018/1/26
 * @Modified By:
 */
@RestController
public class IndexRestController {

    @RequestMapping(value = "/indexRest")
    public String index() {
        return "indexRest";
    }
}
