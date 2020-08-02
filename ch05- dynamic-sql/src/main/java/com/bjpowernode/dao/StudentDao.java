package com.bjpowernode.dao;


import com.bjpowernode.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudentIf(Student student);
    List<Student> selectForeachOne(List<Integer> idlist);
    List<Student> selectForeachTwo(List<Student> stulist);

}

