package com.Mitanand.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mitanand.CRUD.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{
	public Category findById(int category);
}
