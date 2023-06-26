package com.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.model.User;
import com.register.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public IUserService userService;

private ResponseEntity<?> responseEntity;
	
	@PostMapping("/adduser")
	public ResponseEntity<?> saveUserHandler(@RequestBody User user)
	{
		User newUser = this.userService.addUser(user);
		responseEntity = new ResponseEntity<>(newUser,HttpStatus.CREATED);
		return responseEntity;
	}
	
	
	@PutMapping("/updateuser/{email}")
	public ResponseEntity<?> updateUserHandler(@RequestBody User user,@PathVariable String email)
	{
		User newUser = this.userService.updateUser(user,email);
		responseEntity = new ResponseEntity<>(newUser,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getAllusers")
	public ResponseEntity<?> getAllUsersHandler()
	{
		List<User> allUsers = this.userService.getAllUsers();
		responseEntity = new ResponseEntity<>(allUsers,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getuserbyid/{email}")
	public ResponseEntity<?> getUserByIdHandler(@PathVariable String email)
	{
		User uObj = this.userService.getUserById(email);
		responseEntity = new ResponseEntity<>(uObj,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/deluserbyid/{email}")
	public ResponseEntity<?> DeleteUserByIdHandler(@PathVariable String email)
	{
		boolean status = this.userService.delUser(email);
		responseEntity = new ResponseEntity<>("User Details Deleted ....",HttpStatus.OK);
		return responseEntity;
	}
	
	
}
