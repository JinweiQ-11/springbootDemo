package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.dao.ProjectDao;
import org.example.entity.Product;
import org.example.entity.Project;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/3/24 23:05
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public List<Product> getProductList(Map queryMap) {
        return productDao.getProductList(queryMap);
    }

    @Override
    public void updateProduct(Map input) {
        productDao.updateProductList(input);
    }

    @Override
    public void insertProductList(Map<String, Object> map) {
        productDao.insertProductList(map);
    }

}
