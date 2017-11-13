package com.javazhan.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javazhan.domain.Student;
import com.javazhan.service.StudentService;

/**
 * Created by yando on 2017/11/10.
 */

@RestController
@RequestMapping(value="student")
public class StudentRestController {

    @Autowired
    private StudentService stuService ;
    /**
     * 查出所有学生
     * @return
     */
    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<Student> getAllStudent() {
        return stuService.getAllStudent() ;
    }

    /**
     * 根据id查出学生
     * @return
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Student getStudentById(@PathVariable Integer id) {
        return stuService.getStudentById(id) ;
    }

    /**
     * 根据id删除学生
     * @return
     */
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteById(@PathVariable Integer id) {
        stuService.deleteById(id) ;
        return "success" ;
    }

    /**
     * 新增一个学生
     * @return
     */
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String create(@ModelAttribute Student student) {
        stuService.create(student) ;
        return "success" ;
    }

    /**
     * 根据Id更新一个学生
     * @return
     */
    @RequestMapping(value="/", method=RequestMethod.PUT)
    public String updateStudentById(@ModelAttribute Student student) {
        stuService.updateStudentById(student) ;
        return "success" ;
    }
}
