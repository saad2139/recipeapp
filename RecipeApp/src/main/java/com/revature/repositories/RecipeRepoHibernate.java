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
		return (List<Recipe>)sf.getCurrentSession().createCriteria(Recipe.class).list();
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
		User creator = (User) session.load(User.class, id); //*******this works
		//cannot save the recipe because the category and ingredients need the id of the recipe to be saved
		r.setCreator(creator); //*******Set the creator of the recip
		session.save(r);	//***save the recipe
//		Recipe recipe = (Recipe) session.get(Recipe.class, recipeId);
//		System.out.println(recipe +"------------------------------------------------------");
//		recipe.setingredients(ingredients);
//		System.out.println(recipe +"-update-----------------------------------------------------");
		return r;
	}

	@Override
	@Transactional
	public Recipe getRecipeById(int id) {
		Session session = sf.getCurrentSession();
		Criteria cr = session.createCriteria(Recipe.class);
		cr.add(Restrictions.eq("recipeId", id));
		return (Recipe) cr.uniqueResult();
	}

//	@Override
//	public Recipe save(Recipe r, int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
