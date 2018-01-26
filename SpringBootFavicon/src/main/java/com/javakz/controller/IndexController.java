package com.javakz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 10:35 2018/1/26
 * @Modified By:
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("name","SpringBootFavicon");
        return "index";
    }
}
