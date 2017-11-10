package com.javazhan.service.impl;

import com.javazhan.domain.Student;
import com.javazhan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yando on 2017/11/10.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate  ;

    @Override
    public void create(Student student) {
        // TODO Auto-generated method stub
        jdbcTemplate.update("insert into student(name, age, address) value(?,?,?)", student.getName(), student.getAge(), student.getAddress()) ;
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        jdbcTemplate.update("delete from student where id = ?", id) ;
    }

    @Override
    public List<Student> getAllStudent() {
        // TODO Auto-generated method stub
        return jdbcTemplate.query("select * from student", new RowMapper()
        {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setAddress(rs.getString("address"));
                return student;
            }
        }) ;
    }

    @Override
    public Student getStudentById(int id) {
        // TODO Auto-generated method stub
        return (Student) jdbcTemplate.query("select * from student where id=?", new ResultSetExtractor() {
            @Override
            public Student extractData(ResultSet rs) throws SQLException {
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setAge(rs.getInt("age"));
                    student.setAddress(rs.getString("address"));
                    return student ;
                }
                return null ;
            }
        }, id);
    }

    @Override
    public void updateStudentById(Student student) {
        // TODO Auto-generated method stub
        jdbcTemplate.update("update student set name=?, age=?, address=? where id =?", student.getName(), student.getAge(), student.getAddress(),student.getId()) ;
    }
}
