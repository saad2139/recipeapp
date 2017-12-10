package com.revature.repositories;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Category;

@Repository
public class CategoryRepoHibernate implements CategoryRepo {
	
	@Autowired
	private SessionFactory sf;
	
	@Transactional
	@Override
	public List<Category> findAll() {
		String hql = "SELECT categoryId, categoryName FROM Category ";
		Query query = sf.getCurrentSession().createQuery(hql);
		List<Category> results = query.list();
		return results;
	}

}
