package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.feignconfig.IUserConsumer;
import com.login.model.User;
@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	public IUserConsumer userConsumer;
	
	@Override
	public boolean Validation(User user) {
		User uObj = this.userConsumer.getByEmailHandler(user.getEmailId());
		if(uObj != null) {
			if(uObj.getPassword().equals(user.getPassword())) {
				return true;
			}else {
				System.out.println("Invalid Password");
				return false;
			}
		}else {
			System.out.println("User Not Found!");
			return false;
		}
	}

}
