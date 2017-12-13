package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Recipe;
import com.revature.repositories.CategoryRepo;
import com.revature.repositories.RecipeRepo;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepo rr;

	public List<Recipe> viewAllRecipes(){
		return rr.findAll();
	}

	public Recipe addRecipe(Recipe r, int id) {
		return rr.save(r,id);
	}
	
}
