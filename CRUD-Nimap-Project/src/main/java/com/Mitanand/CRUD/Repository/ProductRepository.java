package com.Mitanand.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mitanand.CRUD.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public Product findById(int product);

}
