package com.javazhan.controller;

import com.javazhan.domain.Blog;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yando on 2017/11/13.
 */
@RestController
@RequestMapping(value = "/blog")
public class BlogController {

    @ApiOperation(value = "获取单个博客", notes = "根据Id获取博客")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Blog getBlogById(@PathVariable Long id) {
        Blog blog = new Blog() ;
        return blog ;
    }

    @ApiOperation(value = "获取所有博客")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Blog> getBlogList() {
        List<Blog> list = new ArrayList<Blog>() ;
        return list ;
    }
}
