package com.hdy.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class ShowController {

    /**
     * 显示主页面
     * @return
     */
    @RequestMapping("/")
    public String show(){
        return "index";
    }

    /**
     * 显示详情页
     * @param page
     * @return
     */
    @RequestMapping("{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}