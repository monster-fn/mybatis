package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {

    public List<Student> selectStudents();

    //插入方法
    public int insertStudent(Student student);
}
