package com.agb.apirestlinkedin.service;

import com.agb.apirestlinkedin.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProducts();

    Product findById(Long id);
}
