package com.yui.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.yui.dao.UserDao;
import com.yui.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	@Override
	public User findById(Integer id) {
		return entityManager.find(User.class, id);
	}


	@Override
	public User save(User user) {
	
		return entityManager.merge(user);
		
	}

	@Override
	public User findByAccount(String account) {
		
		return null;
		
	}
	@Override
	public List<User> getAll() {
		Query query = entityManager.createQuery("select u from User u");
		@SuppressWarnings("unchecked")
		List<User> results = query.getResultList();
		return results;
	}
	

}
