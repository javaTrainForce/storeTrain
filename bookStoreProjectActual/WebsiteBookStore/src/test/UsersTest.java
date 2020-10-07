package test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UsersTest {
public static void main(String[] args) {
		
		Users user1 = new Users();
		user1.setEmail("you@gmail.com");
		user1.setFullName("president otto");
		user1.setPassword("yeswecan");
		
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WebsiteBookStore");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(user1);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("A users object was persisted.");
		
	}
}
