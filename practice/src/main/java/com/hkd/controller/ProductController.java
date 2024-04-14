package com.hkd.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hkd.pojo.Product;
import com.hkd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @RequestMapping("/selectAllProducts")
    public String selectAllProducts(@RequestParam(value = "currentPage",required = true, defaultValue = "1") Integer currentPage, Model model){
        Page<Object> objects = PageHelper.startPage(currentPage, 3);
        List<Product> products = productService.listProducts();

        PageInfo<Product> PageInfo = new PageInfo<Product>(products);

        model.addAttribute("PageInfo",PageInfo);

        model.addAttribute("methodName","selectAllProducts");

        return "forward:/product/productList.jsp";
    }
    @RequestMapping("/selectProductById")
    public String selectProductById(Integer id,Map map){
        Product product = productService.getProductById(id);
        System.out.println(product);
        map.put("product",product);
        return "forward:/product/updateProduct.jsp";
    }

    @RequestMapping("/deleteProductById")
    public String deleteProductById(Integer id){
        productService.removeProduct(id);

        return "redirect:/product/selectAllProducts.do";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/product/selectAllProducts.do";
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(Integer productId,String productName,Double price,Integer inventory,String description){
        productService.updateProduct(new Product(productId,productName,price,inventory,description));
        return "redirect:/product/selectAllProducts.do";
    }

    @RequestMapping("/deleteProducts")
    public String deleteProducts(Integer[] ids){
        for (int i = 0 ; i< ids.length ;i++){

            productService.removeProduct(ids[i]);
        }
       System.out.println(ids);

        return "redirect:/product/selectAllProducts.do";
    }

    @RequestMapping("selectProductByNameAndPrice")
    public String selectProductByNameAndPrice(@RequestParam(value = "currentPage",required = true,defaultValue = "1") Integer currentPage,String productName,Double price , Integer operation ,Model model){
        PageHelper.startPage(currentPage,3);
        List<Product> products = productService.listProductByNameAndPrice(productName, price,operation);

        System.out.println(products);
        PageInfo<Product> PageInfo = new PageInfo<Product>(products);
        model.addAttribute("PageInfo",PageInfo);
        model.addAttribute("methodName","selectProductByNameAndPrice");
        return "forward:/product/productList.jsp";
    }

}
