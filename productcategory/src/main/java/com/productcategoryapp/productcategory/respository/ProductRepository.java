package com.productcategoryapp.productcategory.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcategoryapp.productcategory.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}

