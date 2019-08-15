package com.hdy.student.service.impl;

import com.hdy.student.entity.Student;
import com.hdy.student.mapper.StudentMapper;
import com.hdy.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author m760384371
 * @date 2019/8/13
 */
@Service
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selAll() {
        return studentMapper.selAll();
    }

    @Override
    public int insStu(Student stu) {
        return studentMapper.insStu(stu.getName(), stu.getPassword(), stu.getAge(), stu.getPhone(), stu.getEmail(), stu.getCity());
    }

    @Override
    public int updById(Student stu) {
        return studentMapper.updById(stu.getId(), stu.getName(), stu.getPassword(), stu.getAge(), stu.getPhone(), stu.getEmail(), stu.getCity());
    }

    @Override
    public int delStuById(int id) {
        return studentMapper.delStuById(id);
    }

    @Override
    public Student selById(int id) {
        return studentMapper.selById(id);
    }

}
