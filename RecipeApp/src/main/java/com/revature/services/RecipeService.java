package com.revature.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Category;
import com.revature.entities.Ingredient;
import com.revature.entities.Recipe;
import com.revature.repositories.CategoryRepo;
import com.revature.repositories.RecipeRepo;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepo rr;
	
//	@Autowired 
//	private Ingredient ir;
//	
//	@Autowired 
//	private CategoryRepo cr;

	public List<Recipe> viewAllRecipes(){
		return rr.findAll();
	}

	public Recipe addRecipe(Recipe r, int id) {
		Set<Category> categories = r.getCategories();
		Set<Ingredient> ingredients = r.getingredients();
		//r.setCategories(null);
		//r.setingredients(null);
		return rr.save(r,id);
	}
	
	public List<Recipe> getUserRecipe(int u){
		return rr.findByUserId(u);
	}

	public Recipe getRecipeById(int id) {
		return rr.getRecipeById(id);
	}

	
}
