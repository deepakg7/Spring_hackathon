package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.login.model.User;
import com.login.service.ILoginService;

import jakarta.servlet.ServletException;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private ILoginService loginService;

	private Map<String, String> map = new HashMap<>();

	@GetMapping("/validate")
	public ResponseEntity<?> validateUserHandler(@RequestBody User user) {
		try {

			String jwtToken = generateToken(user);
			map.put("message", "LoggedIn Successfully ");
			map.put("token", jwtToken);
		} catch (Exception e) {
			map.put("message", e.getMessage());
			map.put("token", null);

			return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<>(map, HttpStatus.OK);
	
	}
	private String generateToken(User uObj) throws ServletException {
		String jwtToken = "";
		boolean flag = this.loginService.Validation(uObj);
		if (flag) {
	        if (uObj.getPassword().equals(uObj.getPassword())) {
	            jwtToken = Jwts.builder()
	                .setSubject(uObj.getEmailId())
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 900000))
	                .signWith(SignatureAlgorithm.HS256, "secret key")
	                .compact();
	        } else {
	            throw new ServletException("Invalid Password");
	        }
		} else {
	        throw new ServletException("User Not Found!");
	    }
		return jwtToken;
	}
}
