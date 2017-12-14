package com.revature.repositories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Category;
import com.revature.entities.Ingredient;
import com.revature.entities.Recipe;
import com.revature.entities.User;

import ch.qos.logback.core.net.SyslogOutputStream;

@Repository
@Transactional
public class RecipeRepoHibernate implements RecipeRepo {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public List<Recipe> findByUserId(int id) {
		Session session = sf.getCurrentSession();
		Criteria cr = session.createCriteria(Recipe.class);
		cr.add(Restrictions.eq("creator", id));
		return (List<Recipe>)cr.list();
	}

	@Override
	@Transactional
	public List<Recipe> findAll() {
		return (List<Recipe>)sf.getCurrentSession().createCriteria(Recipe.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	@Transactional
	public List<Recipe> findGreaterThanRating(int rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Recipe> mostUpvoted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Recipe save(Recipe r, int id) {
		Session session = sf.getCurrentSession();
		System.out.println("you are here--------------------------------------------------------------------------------------------");
		//cannot save the recipe because the category and ingredients need the id of the recipe to be saved

		//Set<Ingredient> ingredientList = r.getIngridients();

		//r.setCategories(r.getCategories());
//		
//		Set<Category> catList =  r.getCategories();
//		for(Category c: catList) {
//			Category cat = (Category) session.get(Category.class, c.getCategoryId());
//			Set<Recipe> listRe = cat.getRecipes();
//			System.out.println("Current Recipes" + listRe + "---------------------------------------");
//			if(listRe == null) {
//				Set<Recipe> recipe = new HashSet<Recipe>();
//				recipe.add(r);
//			} else {
//				listRe.add(r);
//			}
//			System.out.println("category================================================" + cat);
//			cat.setRecipes(listRe);
//			System.out.println("after categories are modified----------------------------------------");
//		}
		
//		r.setCategories(r.getCategories());
//		r.setIngredients(r.getIngridients());
		

		
		session.save(r);	//***save the recipe

		
		return r;
	}
//	@Transactional
//	private void saveCategories(int recipeId, Set<Category> categories) {
//		Session session = sf.getCurrentSession();
//		Recipe recipe = (Recipe) session.get(Recipe.class, recipeId);
//		System.out.println(recipe.getCategories() + "________________________CATEGORIES_AFTER_SAVE__________________");
//		Set<Category> catList =  recipe.getCategories();
//		for(Category c: catList) {
//			c.getRecipes().add(recipe);
//		}
//		System.out.println(catList + "________________________CATEGORIES_AFTER_SAVE_in categorie_________________");
//	}

	@Override
	@Transactional
	public Recipe getRecipeById(int id) {
		Session session = sf.getCurrentSession();
		Criteria cr = session.createCriteria(Recipe.class);
		cr.add(Restrictions.eq("recipeId", id));
		return (Recipe) cr.uniqueResult();
	}
}
