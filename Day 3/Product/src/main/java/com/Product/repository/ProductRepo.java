package com.Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Product.Entity.Product;

import java.util.List;

//Create ProductRepo interface extending JpaRepository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price < :price")
    List<Product> findProductsLessThanPrice(@Param("price") Double price);
}