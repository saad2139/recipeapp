package com.revature.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Recipe;

@Repository
public class RecipeRepoHibernate implements RecipeRepo {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public List<Recipe> findByUserId(int id) {
		Session session = sf.getCurrentSession();
		Criteria cr = session.createCriteria(Recipe.class);
		cr.add(Restrictions.eq("id", id));
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
	public Recipe save(Recipe r) {
		sf.getCurrentSession().save(r);
		return r;
	}

}
