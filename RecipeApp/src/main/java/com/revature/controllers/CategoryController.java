package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Category;
import com.revature.services.CategoryService;

@RestController
@RequestMapping("categories")
@CrossOrigin(allowCredentials="true", origins="http://localhost:4200")//angular
public class CategoryController {
	
	@Autowired
	private CategoryService cs;
	
	@GetMapping
	public List<Category> getAllCategories(){
		return cs.findAll();
	}
}
