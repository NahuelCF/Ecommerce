package com.ecommerce.DAO;

import com.ecommerce.domain.strategy.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
