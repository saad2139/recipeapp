package com.revature.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Recipe;

@RestController
@RequestMapping("recipe")
public class RecipeController {
	
	@Autowired
	private RecipeService rs;
	
	@GetMapping("allRecipes")
	public List<Recipe> getAllRecipes(){
		return rs.viewAllRecipes();
	}
	
	@PostMapping("createRecipe")
	public Recipe addRecipe(@RequestBody Recipe r) {
		return rs.addRecipe(r);
	}
}
