package com.revature.repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.User;

@Repository
public class UserRepoHibernate implements UserRepo {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public User findByCredential(String username, String password) {
		System.out.println("FIND BY CREDENTIAL ++++++++++++++++++++++++++++++++++++++=");
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

}
