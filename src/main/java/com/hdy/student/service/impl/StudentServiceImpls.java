package com.hdy.student.service.impl;

import com.hdy.student.mapper.MStudentMapper;
import com.hdy.student.model.MStudent;
import com.hdy.student.model.MStudentExample;
import com.hdy.student.service.StudentServices;
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
public class StudentServiceImpls implements StudentServices {

    @Autowired
    private MStudentMapper mStudentMapper;

    @Override
    public List<MStudent> selAll() {
        MStudentExample example = new MStudentExample();
        List<MStudent> mStudents = mStudentMapper.selectByExample(example);
        return mStudents;
    }

    @Override
    public int insStu(MStudent stu) {
        int i = mStudentMapper.insertSelective(stu);
        return i;
    }


    @Override
    public int updById(MStudent stu) {
        MStudentExample example = new MStudentExample();
        example.or().andNameEqualTo(stu.getName());
        int i = mStudentMapper.updateByExampleSelective(stu, example);
        return i;
    }

    @Override
    public int delStuById(int id) {
        MStudentExample example = new MStudentExample();
        example.or().andUuidEqualTo(id + "");
        int i = mStudentMapper.deleteByExample(example);
        return i;
    }

    @Override
    public List<MStudent> selById(int id) {
        MStudentExample example = new MStudentExample();
        example.or().andUuidEqualTo(id + "");
        return mStudentMapper.selectByExample(example);
    }

}
