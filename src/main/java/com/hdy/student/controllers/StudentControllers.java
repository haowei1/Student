package com.hdy.student.controllers;

import com.hdy.student.model.MStudent;
import com.hdy.student.model.ResultType;
import com.hdy.student.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author m760384371
 * @date 2019/8/13
 */
@RestController
@RequestMapping("students")
public class StudentControllers {

    @Autowired
    private StudentServices studentServiceImpls;

    /**
     * 根据id查询
     * @return
     */
    @RequestMapping("selId")
    public String selId(){
        System.out.println("4444444444");
        return studentServiceImpls.selById(6).toString();
    }

    /**
     * 新增学生
     * @param student
     * @return
     */
    @RequestMapping("insStu")
    public String insStu(MStudent student) {
        System.out.println("555555555555555");
        int i = studentServiceImpls.insStu(student);
        if (i > 0) {
            return "200";
        }
        return "Err";
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("del/{id}")
    public String del(@PathVariable int id) {
        System.out.println("222222222222");
        int i = studentServiceImpls.delStuById(id);
        if (i > 0) {
            return "200";
        }
        return "Err";
    }

    /**
     * 更新
     * @return
     */
    @RequestMapping("updStu")
    public String updStu(MStudent student) {
        System.out.println("33333333333");
        int i = studentServiceImpls.updById(student);
        if (i > 0) {
            return "200";
        }
        return "Err";
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/selAll")
    public ResultType show() {
        System.out.println("11111111111");
        ResultType rt = new ResultType();
        rt.setCode(0);
        rt.setMsg("请求成功");
        rt.setData(studentServiceImpls.selAll());
        return rt;
    }

}
