package org.example.dao;

import org.example.entity.Product;
import org.example.entity.User;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    public List<Product> getProductList(Map<String, Object> map);
    public void updateProductList(Map<String, Object> map);
    public void insertProductList(Map<String, Object> map);
}
