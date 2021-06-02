package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

@RestController
public class Controller {

	@Autowired
	UserService ser;

	@Autowired
	UserRepository repo;

	@RequestMapping(path = "")
	public String welome() {
		return "welcome to spring boot demo";
	}

	@PostMapping(path = "adduser")
	public String addUser(@RequestBody User user) {
		try {

			ser.saveUser(user);
		} catch (Exception e) {
			return "" + e;
		}

		return "user added successfully";

	}


	@PostMapping(path = "update") 
	public String updateUser(@RequestBody User user) 
	{ 
		try 
		{

			ser.updateUser(user); 
		} 
		catch (Exception e) 
		{ 
			return ""+e; 
		}

		return "user updated successfully";


	}


	@GetMapping(path = "list")
	public Map<String, Object> listUser() {
		Map<String, Object> data = new HashMap<String, Object>();

		List<User> detail = new ArrayList<User>();

		try {
			detail = repo.findAll();
		} catch (Exception e) {
			data.put("exception", "" + e);
		}

		data.put("userList", detail);

		return data;

	}

	@PostMapping(path = "delete")
	public String deleteUser(@RequestBody User user) {
		try 
		{

			repo.deleteById(user.getUserId());
		} catch (Exception e) 
		{
			return "" + e;
		}

		return "user deleted successfully";

	}

}
