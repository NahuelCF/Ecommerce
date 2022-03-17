package com.ecommerce.service;

import com.ecommerce.DAO.CategoryRepository;
import com.ecommerce.domain.strategy.Category;
import com.ecommerce.errorHandler.EcommerceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                ()-> new EcommerceNotFoundException("The category with id " + categoryId + " doesn't exist.")
        );
    }
}
