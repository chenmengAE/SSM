package com.hkd.test;

import com.hkd.mapper.ProductMapper;
import com.hkd.pojo.Product;
import com.hkd.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ProductTest {

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.insertProduct(new Product(null,"看见1",123.00,13,"荆钗书写"));
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.deleteProductById(1);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.updateProduct(new Product(51,"看见2",123.00,13,"拆将书写"));
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> java = mapper.selectProductByName("看见1");
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        java.forEach(System.out::println);
    }

    @Test
    public void test5(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> products = mapper.selectProducts();
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        products.forEach(System.out::println);
    }

    @Test
    public void test6(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        Product product = mapper.selectProductById(2);
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
        System.out.println(product);
    }

}
