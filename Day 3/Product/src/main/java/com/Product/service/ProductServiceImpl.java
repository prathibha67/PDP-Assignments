package com.Product.service;

import com.Product.Entity.Product;
import com.Product.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo repo;
    @Autowired
    public ProductServiceImpl(ProductRepo repo){
        this.repo = repo;
    }
    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public List<Product> getAllProductsHavingPriceLessThan(double price) {
        return repo.findProductsLessThanPrice(price);
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> product = repo.findById(id);
        return product.orElse(null);
    }
    @Override
    public Product saveProduct(Product product) {
        return repo.save(product);

    }
    @Override
    public String deleteProduct(long id) {
        repo.deleteById(id);
        return "Product Deleted";
    }

    @Override
    public Product updateProduct(Product product, long id) {
        Optional<Product> product1 = repo.findById(product.getId());
        if(product1.isPresent()) {
            Product tempProd = product1.get();
            tempProd.setName(product.getName());
            tempProd.setPrice(product.getPrice());
            return repo.save(tempProd);
        }
        return null;
    }

}




