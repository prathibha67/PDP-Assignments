package com.Product.controller;


import com.Product.Entity.Product;
import com.Product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Controller {
    // Add controllers here for CRUD operations on Product entity.
    private final ProductService productService;

    public Controller(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/getproducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @PostMapping("/addproduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id ){
        return new ResponseEntity<>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}

