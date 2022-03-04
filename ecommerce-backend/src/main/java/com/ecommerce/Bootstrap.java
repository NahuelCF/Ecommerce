package com.ecommerce;

import com.ecommerce.DAO.ProductRepository;
import com.ecommerce.domain.Product;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap implements InitializingBean {

    @Autowired
    ProductRepository productRepository;

    private void createProduct(String name, String description, Double price, Integer stock){
        Product product = new Product(name,description,price,stock);
        productRepository.save(product);
    }

    private void createProducts(){
        createProduct("Table","A table of dark wood",5000.00,100);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("//////////////////Creating Products//////////////////");
        createProducts();
    }
}
