package com.agb.apirestlinkedin.service;

import com.agb.apirestlinkedin.entity.Product;
import com.agb.apirestlinkedin.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductDAO productDAO;


    @Override
    @Transactional(readOnly = true)
    public List<Product> findAllProducts() {

        return (List<Product>) productDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {

        return productDAO.findById(id).orElseThrow();
    }
}
