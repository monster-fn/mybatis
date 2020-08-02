package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudentById(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students = dao.selectStudentIf(student);
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }

    }

    //  <!--foreach 1-->
    @Test
    public void testForeachOne(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.selectForeachOne(list);
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }

    }

    //  <!--foreach 2-->
    @Test
    public void testForeachTwo(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> stulist = new ArrayList<>();

        Student s1 = new Student();
        s1.setId(1002);
        stulist.add(s1);

        s1 = new Student();
        s1.setId(1003);
        stulist.add(s1);

        List<Student> students = dao.selectForeachTwo(stulist);
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }

    }

}
