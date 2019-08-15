package com.hdy.student.controller;

import com.hdy.student.entity.Student;
import com.hdy.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author m760384371
 * @date 2019/8/13
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentServiceImpl;

    /**
     * helloWorld
     * @return
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/sel")
    @ResponseBody
    public String sel(){
        return studentServiceImpl.selAll().toString();
    }

    /**
     * 根据id查询
     * @return
     */
    @RequestMapping("selId")
    @ResponseBody
    public String selId(){
        return studentServiceImpl.selById(1).toString();
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping("ins")
    @ResponseBody
    public String ins() {
        Student student = new Student("王五", "1", 20, "1843522", "8748", "dt");
        int i = studentServiceImpl.insStu(student);
        if (i > 0) {
            return "Ok";
        }
        return "Err";
    }

    /**
     * 删除
     * @param map
     * @return
     */
    @RequestMapping("del")
    @ResponseBody
    public String del(@RequestBody Map<String, Object> map) {
        int id = (int) map.get("id");
        int i = studentServiceImpl.delStuById(id);
        if (i > 0) {
            return "Ok";
        }
        return "Err";
    }

    /**
     * 更新
     * @return
     */
    @RequestMapping("upd")
    @ResponseBody
    public String upd() {
        Student student = new Student(1,"王五", "1", 20, "1843522", "8748", "大同");
        int i = studentServiceImpl.updById(student);
        if (i > 0) {
            return "Ok";
        }
        return "Err";
    }

    /**
     *
     * 显示 Thymeleaf 页面
     * @param map
     * @return
     */
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("index", "哈哈哈");
        return "show";
    }

}
