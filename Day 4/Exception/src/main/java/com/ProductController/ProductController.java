package com.ProductController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ProductModel.Product;
import com.ProductService.ProductService;


@RestController
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable String id)
    {
        Optional<Product> product=productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        ArrayList<Product> products= (ArrayList<Product>) productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @PostMapping("/products/add")
    public ResponseEntity<Product> AddProduct(@RequestBody Product product)
    {
            Product product1=productService.AddNewProduct(product);
            return ResponseEntity.ok(product1);
    }

    @PatchMapping("products/put/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable String id,@RequestBody Product product)
    {
        try
        {
            productService.UpdateProduct(id,product);
            return ResponseEntity.ok("Product Details Updated Successfully");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found with ID:"+id);
        }
    }
    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Boolean> DeleteProduct(@PathVariable String id)
    {
        return ResponseEntity.ok(productService.DeleteProduct(id));
    }
}
