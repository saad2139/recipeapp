package com.revature.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Recipe;
import com.revature.entities.User;
import com.revature.repositories.RecipeRepo;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepo rr;
		
	public List<Recipe> viewAllRecipes(){
		return rr.findAll();
	}

	public Recipe addRecipe(Recipe r) {
		return rr.save(r);
	}
	
	public List<Recipe> getUserRecipe(int u){
		return rr.findByUserId(u);
	}

	public Recipe getRecipeById(int id) {
		return rr.getRecipeById(id);
	}

	
}
