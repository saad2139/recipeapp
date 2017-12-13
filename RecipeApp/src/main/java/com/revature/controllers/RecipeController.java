package com.revature.controllers;

import java.util.List;

import org.apache.log4j.Logger;
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
import com.revature.services.UserService;

@RestController
@RequestMapping("recipe")
@CrossOrigin(allowCredentials="true", origins="http://localhost:4200")//angular
public class RecipeController {
	private Logger log = Logger.getRootLogger();

	@Autowired
	private RecipeService rs;
	@Autowired
	private UserService us;
	
	@GetMapping("allRecipes")
	public List<Recipe> getAllRecipes(){
		return rs.viewAllRecipes();
	}
	
	@PostMapping("addRecipe")
	public Recipe addRecipe(@RequestBody Recipe r) {
		int id = r.getCreator().getId();
		log.trace("**********************************************"
				+ "*******************************************recipe sent****************" + r + 
				"#######################################################" + id);
		return rs.addRecipe(r,id);
	}
}
