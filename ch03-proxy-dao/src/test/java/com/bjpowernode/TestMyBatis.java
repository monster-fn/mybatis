package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudents(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //调用dao方法，执行数据库操作
        List<Student> studentList = dao.selectStudents();
        for(Student stu:studentList){
            System.out.println(stu);
        }
    }

    @Test
    public  void testInsertStudents(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(1006);
        student.setName("frn");
        student.setEmail("frn@qq.com");
        student.setAge(23);
        //调用dao方法，执行数据库操作
        int nums = dao.insertStudent(student);
        //int nums = sqlSession.insert(sqlId,student);
        //mybatis默认不是自动提交事务的，在insert,update,delete之后要手动提交
        sqlSession.commit();
        System.out.println("添加对象的数量:"+nums);
    }
}
