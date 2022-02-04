package com.mycompany.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired private UserRepository repo;
	
	public List<User> listAll() {
		return (List<User>) repo.findAll();
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}
	
}
