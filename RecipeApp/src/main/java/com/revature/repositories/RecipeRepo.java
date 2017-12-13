package com.revature.repositories;

import java.util.List;

import com.revature.entities.Recipe;
import com.revature.entities.User;

public interface RecipeRepo {
	
	//view recipes based on user id
	List<Recipe> findByUserId(int u);
	
	//view all recipes
	List<Recipe> findAll();	
	
	//view recipes based on rating
	List<Recipe> findGreaterThanRating(int rating);
	
	//view top upvoted/liked recipes in the week
	List<Recipe> mostUpvoted();
	
	//add a new recipe
	Recipe save(Recipe r);

	Recipe getRecipeById(int id);

		
}
