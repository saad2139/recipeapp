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
		return (List<Recipe>) cr.list();
	}

	@Override
	@Transactional
	public List<Recipe> findAll() {
		return (List<Recipe>) sf.getCurrentSession().createCriteria(Recipe.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
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
		session.save(r); // ***save the recipe
		r.getRecipeId();
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
}
