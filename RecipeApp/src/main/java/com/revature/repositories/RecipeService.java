package com.revature.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Recipe;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepo rr;
	
//	@Autowired
//	private SessionFactory sf;
	
	public List<Recipe> viewAllRecipes(){
		return rr.findAll();
	}

	public Recipe addRecipe(Recipe r) {
		return rr.save(r);
	}
	
}
