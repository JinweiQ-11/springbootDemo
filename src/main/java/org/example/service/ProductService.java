package org.example.service;

import org.example.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Product> getProductList(Map input);
    public void updateProduct(Map input);
    public void insertProductList(Map<String, Object> map);
}
