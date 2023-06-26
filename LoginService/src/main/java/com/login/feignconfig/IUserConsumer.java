package com.login.feignconfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.login.model.User;

@FeignClient(name="user-service",url="http://localhost:8090/user")
public interface IUserConsumer {

	@GetMapping("/getUserByEmail/{email}")
	public User getByEmailHandler(@PathVariable String email);
	
}
