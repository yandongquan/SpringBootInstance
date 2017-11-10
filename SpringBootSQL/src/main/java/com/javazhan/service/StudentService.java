package com.javazhan.service;

import com.javazhan.domain.Student;

import java.util.List;

/**
 * Created by yando on 2017/11/10.
 */
public interface StudentService {
    /**
     * 新增一个学生
     * @param student
     */
    void create(Student student) ;

    /**
     * 根据id删除一个学生
     * @param id
     */
    void deleteById(int id) ;

    /**
     * 查出所有学生
     * @return
     */
    List<Student> getAllStudent() ;

    /**
     * 根据id查出学生
     * @return
     */
    Student getStudentById(int id) ;

    /**
     * 根据Id更新一个学生
     */
    void updateStudentById(Student student) ;
}
