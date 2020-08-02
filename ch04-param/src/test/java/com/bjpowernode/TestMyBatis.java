package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudentById(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(1002);
        System.out.println("student="+student);

    }

    //    多个参数命名
    @Test
    public void testselectMultiParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiParam("李四",20);
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }

    //    <!--按对象传参-->
    @Test
    public  void testselectMultiObject(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        QueryParam param = new QueryParam();
        param.setParamName("张三");
        param.setParamAge(28);
        List<Student> students = dao.selectMultiObject(param);
        for (Student stu:students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();

    }

    //    <!--按对象传参-->
    @Test
    public  void testselectMultiStudents() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("张三");
        student.setAge(28);
        List<Student> students = dao.selectMultiStudents(student);
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }

    //    <!--$替换列名-->
    @Test
    public  void testselectUse$Order() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$Order("name");
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }

    //    <!--Like-->
    @Test
    public  void testselectLikeOne() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //准备好like的内容
        String name="%李%";
        List<Student> students = dao.selectLikeOne(name);
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }
}
