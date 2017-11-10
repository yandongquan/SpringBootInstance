package com.javazhan.controller;

import com.javazhan.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yando on 2017/11/10.
 */
@Controller
public class ExceptionController {

    @RequestMapping("/nException")
    public String nException() throws Exception {
        throw new Exception("这里有个错误异常") ;
    }

    @RequestMapping("/jsonException")
    public String jsonException() throws MyException {
        throw new MyException("这里有个错误异常");
    }
}
