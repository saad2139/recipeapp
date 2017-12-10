package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Category;
import com.revature.repositories.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired 
	CategoryRepo cr;
	
	public List<Category> findAll() {
		return cr.findAll();
	}

}
