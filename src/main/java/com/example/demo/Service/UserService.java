package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;

	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}

	
	public void saveUser(User user)
	{
		repo.save(user);
	}

	
	public void updateUser(User user) 
	{
		User newUser = new User();
		try 
		{
			newUser = repo.findByUserId(user.getUserId());

		} 
		catch (Exception e) 
		{
		System.out.println("exception caught "+e);
		}
		
		newUser.setName(user.getName());
		newUser.setAddresss(user.getAddresss());
		repo.save(newUser);
		
		
	}

}
