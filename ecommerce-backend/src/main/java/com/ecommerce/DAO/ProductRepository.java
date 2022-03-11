package com.ecommerce.DAO;

import com.ecommerce.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long aLong);

    public List<Product> findByActive(boolean state);
}
