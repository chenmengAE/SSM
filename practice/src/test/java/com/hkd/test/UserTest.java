package com.hkd.test;

import com.hkd.mapper.UserMapper;
import com.hkd.pojo.User;
import com.hkd.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {
    @Test
   public void test01(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(new User(null,"hkd1","1234"));
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);

    }

    @Test
    public void test2(){
        //测试工具类
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User hkd = mapper.selectUserByNameAndPassword("hkd1", "1234");
        System.out.println(hkd);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
    }
}
