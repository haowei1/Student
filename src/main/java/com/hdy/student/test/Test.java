package com.hdy.student.test;

import com.hdy.student.entity.Student;
import com.hdy.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author m760384371
 * @date 2019/8/13
 */
public class Test {

    @Autowired
    private static StudentService studentServiceImpl;

    public static void main(String[] args) {
//        StudentService studentServiceImpl = SpringUtils.getBean(StudentService.class);
        List<Student> list = studentServiceImpl.selAll();
        System.out.println(list);
    }

}
