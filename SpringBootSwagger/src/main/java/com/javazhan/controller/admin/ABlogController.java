package com.javazhan.controller.admin;

import com.javazhan.domain.Blog;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by yando on 2017/11/13.
 */
@RestController
@RequestMapping(value = "/admin/blog")
public class ABlogController {

    static Map<Long, Blog> blogs = Collections.synchronizedMap(new HashMap<Long, Blog>()) ;

    @ApiOperation(value = "后台管理查询所有博客")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Blog> getBlogList() {
        List<Blog> list = new ArrayList<Blog>(blogs.values()) ;
        return list ;
    }

    @ApiOperation(value = "新增博客", notes = "根据博客对象")
    @ApiImplicitParam(name = "blog", value = "博客信息实体blog", required = true, dataType = "Blog")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map addBlog(@RequestBody Blog blog) {
        blogs.put(blog.getId(), blog) ;
        Map map = new HashMap() ;
        map.put("message", "新增成功") ;
        map.put("code", "0000") ;
        return map ;
    }

    @ApiOperation(value = "获取博客信息")
    @ApiImplicitParam(name = "id", value = "博客ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Blog getBlogById(@PathVariable Long id) {
        Blog blog = new Blog() ;
        blog = blogs.get(id) ;
        return blog ;
    }

    @ApiOperation(value = "修改博客信息", notes = "根据传过来的博客对象修改博客信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "博客ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "blog", value = "博客信息实体blog", required = true, dataType = "Blog")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Map updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        Blog b = blogs.get(blog.getId()) ;
        b.setId(blog.getId()) ;
        b.setName(blog.getName()) ;
        blogs.put(b.getId(), b) ;
        Map map = new HashMap() ;
        map.put("message", "修改成功") ;
        map.put("code", "0000") ;
        return map ;
    }

    @ApiOperation(value = "删除博客信息")
    @ApiImplicitParam(name = "id", value = "博客ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map deleteBlog(@PathVariable Long id) {
        blogs.remove(id) ;
        Map map = new HashMap() ;
        map.put("message", "删除成功") ;
        map.put("code", "0000") ;
        return map ;
    }
}
