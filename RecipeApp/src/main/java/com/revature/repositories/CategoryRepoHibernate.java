package com.revature.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
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
//		String hql = "SELECT categoryId, categoryName FROM Category ";
//		Query query = sf.getCurrentSession().createQuery(hql);
//		List<Category> results = query.list();
//		return results;
		
		Criteria cr = sf.getCurrentSession().createCriteria(Category.class)
			    .setProjection(Projections.projectionList()
			      .add(Projections.property("categoryName"), "categoryName")
			      .add(Projections.property("categoryId"), "categoryId"))
			    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			   
//			    .setResultTransformer(Transformers.aliasToBean(Category.class));

			  List<Category> list = cr.list();
			  return list;
	}

}
