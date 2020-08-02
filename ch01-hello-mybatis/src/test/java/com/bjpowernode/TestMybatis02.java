package com.bjpowernode;

import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis02 {

    @Test
    public void testInsert() throws IOException {

        //5.【重要】获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //6.【重要】指定执行Sql语句的标识。   sql映射文件中的namespace+"."+标签的id值
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";


        //7.通过sqlId找到sql语句并执行
        List<Student> studentList = sqlSession.selectList(sqlId);

        //8.输出结果
        studentList.forEach(stu-> System.out.println(stu));

        //9.关闭Sqlsession对象
        sqlSession.close();
    }
}
