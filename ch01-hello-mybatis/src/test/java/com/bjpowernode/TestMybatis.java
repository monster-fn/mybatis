package com.bjpowernode;

import com.bjpowernode.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void testInsert() throws IOException {
        //1.定义mybatis主配置文件的位置，从类路径根目录开始,即target/classes之后
        String config = "mybatis.xml";

        //2.读取config表示的文件org.apache.ibatis.io.Resources,注意包名
        InputStream in = Resources.getResourceAsStream(config);

        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);

        //5.【重要】获取SqlSession对象
        SqlSession sqlSession = factory.openSession();

        //6.【重要】指定执行Sql语句的标识。   sql映射文件中的namespace+"."+标签的id值
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "insertStudent";

        //7.通过sqlId找到sql语句并执行
        Student student = new Student();
        student.setId(1004);
        student.setName("lbfei");
        student.setEmail("lb@qq.com");
        student.setAge(20);
        int nums = sqlSession.insert(sqlId,student);
        //mybatis默认不是自动提交事务的，在insert,update,delete之后要手动提交
        sqlSession.commit();


        //8.输出结果
        System.out.println("执行insert的结果="+nums);

        //9.关闭Sqlsession对象
        sqlSession.close();
    }
}
