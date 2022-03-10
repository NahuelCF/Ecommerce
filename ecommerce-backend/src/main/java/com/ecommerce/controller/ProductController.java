package com.ecommerce.controller;

import com.ecommerce.domain.Product;
import com.ecommerce.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/allProducts")
    @ApiOperation("Return all products in database")
    List<Product> getAllProducts() {
        return productService.allProducts();
    }

    @GetMapping("/getProduct/{productId}")
    @ApiOperation("Return a product")
    Product getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/getPrice/{productId}")
    @ApiOperation("Return all products in database")
    Double getPrice(@PathVariable Long productId) {
        return productService.getPrice(productId);
    }
}
