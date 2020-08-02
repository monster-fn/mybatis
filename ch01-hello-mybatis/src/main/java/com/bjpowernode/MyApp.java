package com.bjpowernode;

import com.bjpowernode.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {

    public static void main(String[] args) throws IOException {
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
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";

        //7.通过sqlId找到sql语句并执行
        List<Student> studentList = sqlSession.selectList(sqlId);
        //如果是增添数据的语句，应该是:
        //int nums = sqlSession.insert(sqlId,student);
        //nums表示修改数据库记录的条数，sqlId是增添数据对应的SQL语句的sqlId，student是一个实体类对象。
        //mybatis默认不是自动提交事务，完成增删改后应手动提交：
        //sqlSession.commit();

        //8.输出结果
        studentList.forEach(stu-> System.out.println(stu));

        //9.关闭Sqlsession对象
        sqlSession.close();



    }
}
