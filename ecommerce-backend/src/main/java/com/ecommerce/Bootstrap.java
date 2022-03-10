package com.ecommerce;

import com.ecommerce.DAO.CategoryRepository;
import com.ecommerce.DAO.ProductRepository;
import com.ecommerce.domain.Product;
import com.ecommerce.domain.strategy.Category;
import com.ecommerce.domain.strategy.Home;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap implements InitializingBean {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    Category home;

    private void createProduct(String name, String description, Double price, Integer stock, String image, Category category){
        Product product = new Product(name,description,price,stock,image,category);
        productRepository.save(product);
    }

    private void createProducts(){
        createProduct("Table","A table of dark wood",5000.00,100,"https://www.graindesigns.com/wp-content/uploads/elementor/thumbs/52-Trestle-Rustic-Oak-Dark-Wood-Dining-Room-Table-with-Wood-Pedestal-Style-Base-and-Bench-p61i2dkv36x436gl9coqx0970neeme16mx4afhgd5s.jpg",home);
        createProduct("Chair","A comfortable chair", 2500.00,100,"https://cdn.shopify.com/s/files/1/0124/5662/4187/products/102078ba05f00ead3aec6f240ab7ebaf_46b686dd-2ac4-4d7b-9ac1-001770a055f5_1000x1000.jpg?v=1620184068",home);
//        createProduct("Stove","A big silver stove",15000.00,70,"https://www.vietworldkitchen.com/wp-content/uploads/2020/09/stove-tall.jpeg");
//        createProduct("Fridge","A double door fridge",45000.00,50,"https://storage.beko.co.uk/assets/beko/support/buying-guides/refrigeration/American-Style-Fridge-Freezers.jpg");
//        createProduct("Football ball","An original ball used in a official match",7000.00,2,"https://images.unsplash.com/photo-1614632537190-23e4146777db?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8NXx8fGVufDB8fHx8&w=1000&q=80");
//        createProduct("Goal","A garden goal",9000.00,10,"https://m.media-amazon.com/images/I/61YmDqSIFwL.jpg");
//        createProduct("Rimel","waterproof rimel",1300.00,110,"https://jchstore.com.ar/wp-content/uploads/2021/07/image_eddcfffd-eeba-4bd2-9dc4-59884a5ca492-300x300.jpg");
//        createProduct("Lip","Lip with a heart",700.00,45,"https://images.ctfassets.net/wlke2cbybljx/3dojyLrc244vRcgYPPUBZb/84d900f9c95007305d6fcc5e9ef589bf/Nude-Romance-Medium-Model.png?q=80&fm=png");
    }

    private void createCategories(){
        home = new Home(2,20,22);
        categoryRepository.save(home);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("//////////////////Creating Categories//////////////////");
        createCategories();
        System.out.println("//////////////////Creating Products//////////////////");
        createProducts();
    }
}
