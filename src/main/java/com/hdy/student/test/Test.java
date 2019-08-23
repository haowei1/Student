package com.hdy.student.test;

import com.hdy.student.model.MStudent;
import com.hdy.student.model.Student;
import com.hdy.student.service.StudentService;
import com.hdy.student.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author m760384371
 * @date 2019/8/13
 */
public class Test {

    @Autowired
    private static StudentService studentServiceImpl;
    @Autowired
    private static StudentServices studentServiceImpls;

    public static void main(String[] args) {
//        StudentService studentServiceImpl = SpringUtils.getBean(StudentService.class);
        List<Student> list = studentServiceImpl.selAll();
        List<MStudent> mStudents = studentServiceImpls.selAll();
        System.out.println(list);
        System.out.println(mStudents);
    }

}
