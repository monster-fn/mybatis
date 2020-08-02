package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

public Student selectStudentById(Integer id);
List<Student> selectMultiParam(@Param("myname") String name,
                               @Param("myage") Integer age);
List<Student> selectMultiObject(QueryParam param);
List<Student> selectMultiStudents(Student student);
List<Student> selectUse$Order(@Param("col") String  colName);
List<Student> selectLikeOne(String name);
}
