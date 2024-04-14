package com.hkd.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;


public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("读取主配文异常" + e);
        }
        //获取SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    public static SqlSession getSqlSession() {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    return sqlSession;

    }

    public static void closeSqlSession(SqlSession sqlSession){
        if (sqlSession==null) {
            sqlSession.close();
        }
    }
}
