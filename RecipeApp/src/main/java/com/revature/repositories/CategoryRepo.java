package com.revature.repositories;

import java.util.List;

import com.revature.entities.Category;

public interface CategoryRepo {
	
	List<Category> findAll();
}
