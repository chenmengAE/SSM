package com.hkd.mapper;

import com.hkd.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProductMapper {
    void insertProduct(Product product);

    void deleteProductById(@Param("productId") Integer id);

    void updateProduct(Product product);

    List<Product> selectProducts();

    List<Product> selectProductByName(@Param("productName") String productname);

    Product selectProductById(@Param("productId") Integer id);

    void deleteProducts(Integer[] ids);

    List<Product> selectProductByPrice(Integer price);

    List<Product> selectProductByNameAndPrice(@Param("productName") String productName, @Param("price") Double price, @Param("operation") Integer operation);

}
