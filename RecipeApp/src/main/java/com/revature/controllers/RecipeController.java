package com.revature.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Recipe;
import com.revature.services.RecipeService;

@RestController
@RequestMapping("recipe")
@CrossOrigin(allowCredentials="true", origins="http://localhost:4200")//angular
public class RecipeController {
	private Logger log = Logger.getRootLogger();

	@Autowired
	private RecipeService rs;
	
	@GetMapping("allRecipes")
	public List<Recipe> getAllRecipes(){
		return rs.viewAllRecipes();
	}
	
	@PostMapping("addRecipe")
	public Recipe addRecipe(@RequestBody Recipe r) {
		log.trace("recipe sent" + r);
		return rs.addRecipe(r);
	}
}
