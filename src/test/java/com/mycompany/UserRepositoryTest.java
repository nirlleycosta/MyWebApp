package com.mycompany;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.mycompany.users.User;
import com.mycompany.users.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	@Autowired
	private UserRepository repo;

	
	  @Test public void testAddUser() { User user = new User();
	  user.setEmail("nirlleypaixao@gmail.com"); user.setPassword("#1992PaixaO*");
	  user.setFirstName("Nirlley"); user.setLastName("Costa");
	  
	  User savedUser = repo.save(user);
	  
	  Assertions.assertThat(savedUser).isNotNull();
	  Assertions.assertThat(savedUser.getId()).isGreaterThan(0); 
	  
	  } 
	 

	@Test
	public void testListAll() {
		Iterable<User> users = repo.findAll();
		Assertions.assertThat(users).hasSizeGreaterThan(0);

		for (User user : users) {
			System.out.println(user);
		}

	}

	/* @Test
	public void testUpdate() {
		Integer userId = 3;
		Optional<User> optionalUser = repo.findById(userId);
		User user = optionalUser.get();
		user.setPassword("meupau");
		repo.save(user);

		User updatedUser = repo.findById(userId).get();
		Assertions.assertThat(updatedUser.getPassword()).isEqualTo("meupau");
	} */

	/*@Test
	public void testDelete() {
		Integer userId = 15;
		repo.deleteById(userId);
		
		Optional<User> optionalUser = repo.findById(userId);
		Assertions.assertThat(optionalUser).isNotPresent();
	} */
}
