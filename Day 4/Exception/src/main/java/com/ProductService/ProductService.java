package com.ProductService;

import java.util.List;
import java.util.Optional;

import com.ProductModel.Product;



public interface ProductService {
    Optional<Product> getProductById(String id);
    List<Product> getAllProducts();
    Product AddNewProduct(Product product);
    void UpdateProduct(String id,Product product);
    Boolean DeleteProduct(String id);


}

