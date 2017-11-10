package com.javazhan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javazhan.domain.Student;

@Controller
public class StudentController {

    @RequestMapping("/getStudentList")
    public String getStudentList(ModelMap map) {
        List<Student> list = new ArrayList<Student>() ;
        for(int i=0; i<=5; i++) {
            Student st = new Student() ;
            st.setId(i+1) ;
            st.setName("章三"+(i+1)) ;
            st.setAge(20+i) ;
            st.setAddress("北京故宫门牌号20"+i) ;
            list.add(st) ;
        }
        map.addAttribute("list", list);
        return "index" ;
    }
}