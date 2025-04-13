package com.productcategoryapp.productcategory.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productcategoryapp.productcategory.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
