package com.agb.apirestlinkedin.controller;

import com.agb.apirestlinkedin.entity.Product;
import com.agb.apirestlinkedin.exception.ProductNotFoundException;
import com.agb.apirestlinkedin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllProducts() {

        List<Product> products = productService.findAllProducts();

        if(products.isEmpty()) {

            throw new ProductNotFoundException("Product isn't found");
        }

        return products;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findProductById(@PathVariable Long id) {

        Product product = productService.findById(id);

        if(product == null) {

            /*throw new ProductNotFoundException("Product with this id,  isn't found");*/

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with this id ins't found");
        }
        return product;
    }
}
