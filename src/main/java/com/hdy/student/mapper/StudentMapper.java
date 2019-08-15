package com.hdy.student.mapper;

import com.hdy.student.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author m760384371
 * @date 2019/8/13
 */
@Mapper
@Repository
public interface StudentMapper {

    /**
     * 查询全部学生
     * @return
     */
    @Select("select * from student")
    List<Student> selAll();

    /**
     * 添加学生
     * @param name
     * @param password
     * @param age
     * @param email
     * @param city
     * @return
     */
    @Insert("insert into student values (default, #{name}, #{password}, #{age}, #{phone}, #{email}, #{city})")
    int insStu(String name, String password, int age, String phone, String email, String city);

    /**
     * 更新学生信息
     * @param id
     * @param name
     * @param password
     * @param age
     * @param email
     * @param city
     * @return
     */
    @Update("update student set name = #{name}, password = #{password}, age = #{age}, phone = #{phone}, email = #{phone}, city = #{city} where id = #{id}")
    int updById(int id, String name, String password, int age, String phone, String email, String city);

    /**
     * 根据id进行删除
     * @param id 学生id
     * @return
     */
    @Delete("delete from student where id = #{id}")
    int delStuById(int id);

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    @Select("select * from student where id = #{id}")
    Student selById(@Param("id") int id);
}
