package com.Product.service;

import java.util.List;

import com.Product.Entity.Product;


public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getAllProductsHavingPriceLessThan(double price);

    Product getProductById(long id);
    Product saveProduct(Product product);
    String deleteProduct(long id);

    Product updateProduct(Product product, long id);

}

