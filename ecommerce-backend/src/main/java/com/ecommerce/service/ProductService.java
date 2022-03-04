package com.ecommerce.service;

import com.ecommerce.DAO.ProductRepository;
import com.ecommerce.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> allProducts() {
        var productList = new ArrayList<Product>();
        productRepository.findAll().forEach(product -> productList.add(product));
        return productList;
    }

}
