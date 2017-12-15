package com.revature.repositories;

import java.net.URI;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Recipe;
import com.revature.entities.User;

@Repository
public class UserRepoHibernate implements UserRepo {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public User findByCredential(String username, String password) {
		Session session = sf.getCurrentSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("username", username));
		cr.add(Restrictions.eq("password", password));

		return (User) cr.uniqueResult();
	}

	@Override
	@Transactional
	public User registration(User newUser) {
		sf.getCurrentSession().save(newUser);
		return newUser;
	}

	@Override
	@Transactional
	public int userId(String username, String password) {
		Session session = sf.getCurrentSession();
		Criteria cr = session.createCriteria(User.class).setProjection(Projections.id());
		cr.add(Restrictions.eq("username", username));
		cr.add(Restrictions.eq("password", password));
		return (int) cr.uniqueResult();
	}

	@Override
	@Transactional
	public User getUser(int id) {
		Session session = sf.getCurrentSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("id", id));
		return (User) cr.uniqueResult();
	}

}
