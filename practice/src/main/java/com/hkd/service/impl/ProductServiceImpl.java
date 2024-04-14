package com.hkd.service.impl;

import com.github.pagehelper.PageHelper;
import com.hkd.mapper.ProductMapper;
import com.hkd.pojo.Product;
import com.hkd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public void removeProduct(Integer id) {
        productMapper.deleteProductById(id);
    }
    @Override
    public void saveProduct(Product product) {
        productMapper.insertProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);

    }

    @Override
    public List<Product> listProducts() {
        List<Product> products = productMapper.selectProducts();
        return products;
    }

    @Override
    public List<Product> listProductsByName(String productName) {
        List<Product> products = productMapper.selectProductByName(productName);
        return products;
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productMapper.selectProductById(id);
        return product;
    }

    @Override
    public void removeProducts(Integer[] ids) {
        productMapper.deleteProducts(ids);
    }

    @Override
    public List<Product> listProductByPrice(Integer price) {
        List<Product> products = productMapper.selectProductByPrice(price);
        return products;
    }

    @Override
    public List<Product> listProductByNameAndPrice(String productName, Double price,Integer operation) {
        List<Product> products = productMapper.selectProductByNameAndPrice(productName, price,operation);

        return products;
    }

    @Override
    public List<Product> listProductsByPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Product> products = productMapper.selectProducts();
        return products;
    }
}
