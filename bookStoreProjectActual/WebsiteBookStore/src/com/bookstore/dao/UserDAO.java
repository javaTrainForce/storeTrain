package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;
import com.mysql.cj.xdevapi.Schema.CreateCollectionOptions;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	public Users create(Users users) {
		return super.create(users);
	}

	@Override
	public Users update(Users t) {
		return super.update(t);
	}

	@Override
	public Users get(Object userId) {  // RUft ID ab 
		
		return super.find(Users.class, userId);
	}

	@Override
	public void delete(Object id) {
		
	 super.delete(Users.class, id);
		
	}

	@Override
	public List<Users> listAll() {
		
		return super.findWithNamedQuery("Users.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Users.countAll");
		
	}

}
