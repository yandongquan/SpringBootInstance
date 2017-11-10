package com.java.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.javazhan.RunApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by yando on 2017/11/10.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RunApplication.class)
public class RestTest {
    @Autowired
    private WebApplicationContext context;

    // mock api 模拟http请求
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        //集成Web环境测试（此种方式并不会集成真正的web环境，而是通过相应的Mock API进行模拟测试，无须启动服务器）
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testUserController() throws Exception {
        RequestBuilder request = null ;
        MvcResult mvcResult = null ;
        int status = 500 ;
        // 新增学生
        request = post("/student/").param("name", "李四")
                .param("age", "20")
                .param("address", "哈尔滨") ;
        mvcResult = mvc.perform(request).andReturn() ;
        status = mvcResult.getResponse().getStatus() ;
        if(status==200) {
            String content = mvcResult.getResponse().getContentAsString() ;
            System.out.println("新增学生："+content) ;
        }
        // 查出所有学生
        request = get("/student/") ;
        mvcResult = mvc.perform(request).andReturn() ;
        status = mvcResult.getResponse().getStatus() ;
        if(status==200) {
            String content = mvcResult.getResponse().getContentAsString() ;
            System.out.println("查出所有学生："+content);
        }
        // 根据Id查询学生
        request = get("/student/1") ;
        mvcResult = mvc.perform(request).andReturn() ;
        status = mvcResult.getResponse().getStatus() ;
        if(status==200) {
            String content = mvcResult.getResponse().getContentAsString() ;
            System.out.println("根据Id查询学生："+content) ;
        }

        // 根据Id更新一个学生
        request = put("/student/").param("id", "5")
                .param("name", "李四5")
                .param("age", "25")
                .param("address", "哈尔滨5") ;
        mvcResult = mvc.perform(request).andReturn() ;
        status = mvcResult.getResponse().getStatus() ;
        if(status==200) {
            String content = mvcResult.getResponse().getContentAsString() ;
            System.out.println("根据Id更新一个学生："+content) ;
        }

        // 根据id删除一个学生
        request = delete("/student/6") ;
        mvcResult = mvc.perform(request).andReturn() ;
        status = mvcResult.getResponse().getStatus() ;
        if(status==200) {
            String content = mvcResult.getResponse().getContentAsString() ;
            System.out.println("根据id删除一个学生："+content) ;
        }


    }
}