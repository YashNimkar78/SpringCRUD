package com.productcategoryapp.productcategory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productcategoryapp.productcategory.model.CategoryDTO;
import com.productcategoryapp.productcategory.model.Product;
import com.productcategoryapp.productcategory.model.ProductDTO;
import com.productcategoryapp.productcategory.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {
		return productService.getAllProducts(page, 10);
	}

	@GetMapping("/{id}")
	public ProductDTO getProductById(@PathVariable Long id) {

		Product product = productService.getProductById(id);
		ProductDTO productDTO = new ProductDTO();
		// Map product and category data into DTO
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setDescription(product.getDescription());
		productDTO.setPrice(product.getPrice());
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(product.getCategory().getId());
		categoryDTO.setName(product.getCategory().getName());
		productDTO.setCategory(categoryDTO);
		return productDTO;

	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
