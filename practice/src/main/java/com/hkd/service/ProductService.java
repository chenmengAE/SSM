package com.hkd.service;

import com.hkd.pojo.Product;

import java.util.List;

public interface ProductService{
    public void removeProduct(Integer id);

    //添加
    public void saveProduct(Product product);
    //更新
    public  void updateProduct(Product product);
    //提供名字查询
    List<Product> listProductsByName(String productName);
    //查询所有
    List<Product> listProducts();
    //提供id查询
    Product getProductById(Integer id);

    public void removeProducts(Integer[] ids);

    List<Product> listProductByPrice(Integer price);

    List<Product> listProductByNameAndPrice(String productName,Double price,Integer operation);

    /*
    * 分页查询 使用PAGEHELPER
    * */
    List<Product> listProductsByPage(Integer page,Integer size);
}
