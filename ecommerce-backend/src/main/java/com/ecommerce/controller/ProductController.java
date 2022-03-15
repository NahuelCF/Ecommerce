package com.ecommerce.controller;

import com.ecommerce.domain.Product;
import com.ecommerce.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/deleteProduct/{productId}")
    @ApiOperation("Delete a product")
    String deleteProduct(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }

    @PutMapping("/updateProduct/{productId}/{categoryId}")
    @ApiOperation("Update a product")
    String updateProduct(@PathVariable Long productId, @RequestBody Product product, @PathVariable Long categoryId){
        return productService.updateProduct(productId, product, categoryId);
    }

    @GetMapping("/getPrice/{productId}")
    @ApiOperation("Return all products in database")
    Double getPrice(@PathVariable Long productId) {
        return productService.getPrice(productId);
    }
}
