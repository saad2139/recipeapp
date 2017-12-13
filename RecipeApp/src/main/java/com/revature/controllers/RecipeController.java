package com.revature.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Recipe;
import com.revature.entities.User;
import com.revature.services.RecipeService;

@RestController
@RequestMapping("recipe")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200") // angular
public class RecipeController {
	@Autowired
	private RecipeService rs;

	@GetMapping("allRecipes")
	public List<Recipe> getAllRecipes() throws SQLException {
		byte[] bytes;
		List<Recipe> resp = rs.viewAllRecipes();
		for (Recipe recipe : resp) {
			//bytes = (recipe.getImage().getBytes(1, (int) recipe.getImage().length()));
		}
		return resp;
	}
//	@PostMapping("userRecipes")
//	public List<Recipe> getUserRecipes(@RequestBody User u){
//		return rs.getUserRecipe(46);
//	}

	@PostMapping("addRecipe")
	public Recipe addRecipe(@RequestBody Recipe r) {
		return rs.addRecipe(r);
	}
	
	@GetMapping("{id}")
	public Recipe getRecipeByRecipeId(@PathVariable int id) {
		return rs.getRecipeById(id);
	}
}
