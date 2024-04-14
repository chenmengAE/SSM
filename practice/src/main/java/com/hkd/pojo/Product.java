package com.hkd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable {
    private Integer productId;
    private String productName;
    private Double price;
    private Integer inventory;
    private String description;


}
