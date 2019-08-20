package com.hdy.student.controller;

import com.hdy.student.entity.ResultType;
import com.hdy.student.entity.Student;
import com.hdy.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author m760384371
 * @date 2019/8/13
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentServiceImpl;

    /**
     * 根据id查询
     * @return
     */
    @RequestMapping("selId")
    public String selId(){
        return studentServiceImpl.selById(1).toString();
    }

    /**
     * 新增学生
     * @param student
     * @return
     */
    @RequestMapping("insStu")
    public String insStu(Student student) {
        int i = studentServiceImpl.insStu(student);
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
        int i = studentServiceImpl.delStuById(id);
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
    public String updStu(Student student) {
        int i = studentServiceImpl.updById(student);
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
        ResultType rt = new ResultType();
        rt.setCode(0);
        rt.setMsg("请求成功");
        rt.setData(studentServiceImpl.selAll());
        return rt;
    }

}
