package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

import javanet.staxutils.StAXReaderToContentHandler;

public class UserDAOTest {

		private static EntityManagerFactory entityManagerFactory;
		private static EntityManager entityManager;
		private static UserDAO userDAO;
	
	@BeforeClass
	public static void setupClass() {
	 entityManagerFactory = Persistence.createEntityManagerFactory("WebsiteBookStore");
		entityManager = entityManagerFactory.createEntityManager();
		
		userDAO = new UserDAO(entityManager);
	}
		
	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("ottoNormal@gmx.de");
		user1.setFullName("Max Mustermann");
		user1.setPassword("muster");
		
		user1 = userDAO.create(user1);
		
		assertTrue(user1.getUserId() > 0);
		
	}
	
	@Test
	public void testCreateUsersFieldsNotSet() {
		Users user1 = new Users();
		
		user1 = userDAO.create(user1);
		
		assertTrue(user1.getUserId() > 0);
	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users users = userDAO.get(userId);
		System.out.println(users.getEmail());
		assertNotNull(users);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 99;
		Users users = userDAO.get(userId);
		assertNull(users);
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId = 16;
		userDAO.delete(userId);
		
		Users users = userDAO.get(userId);
		
		assertNull(users);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		assertTrue(totalUsers >=10);
	}
	
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}
	

}
