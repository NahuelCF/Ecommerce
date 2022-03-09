package com.ecommerce.service;

import com.ecommerce.DAO.ProductRepository;
import com.ecommerce.domain.Product;
import com.ecommerce.errorHandler.EcommerceNotFoundException;
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

    public Double getPrice(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new EcommerceNotFoundException("The product with id " + productId + " doesn't exist.")
        );
        return product.getPrice();
    }
}
