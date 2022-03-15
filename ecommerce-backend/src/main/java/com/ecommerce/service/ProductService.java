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

    @Autowired
    CategoryService categoryService;

    public List<Product> allProducts() {
        var productList = new ArrayList<Product>();
        productRepository.findByActive(true).forEach(product -> productList.add(product));
        return productList;
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(
                ()-> new EcommerceNotFoundException("The product with id " + productId + " doesn't exist.")
        );
    }

    public Double getPrice(Long productId) {
        Product product = getProduct(productId);
        return product.getPrice();
    }

    public String deleteProduct(Long productId) {
        Product product = getProduct(productId);
        productRepository.deleteById(productId);
        return "Product successfully deleted!";
    }

    public String updateProduct(Long productId, Product product, Long categoryId) {
        Product oldProduct = getProduct(productId);
        product.id = productId;
        product.category = categoryService.getCategory(categoryId);
        productRepository.save(product);
        return "Product successfully updated!";
    }
}
