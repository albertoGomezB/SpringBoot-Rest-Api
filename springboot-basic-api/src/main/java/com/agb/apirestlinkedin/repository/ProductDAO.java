package com.agb.apirestlinkedin.repository;

import com.agb.apirestlinkedin.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {
}
