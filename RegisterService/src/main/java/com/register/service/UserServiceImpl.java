package com.register.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.model.User;
import com.register.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	public IUserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		Optional<User> optional = this.userRepository.findById(user.getEmailId());
		User adduobj = null;
		
		if(optional.isPresent())
		{
			System.out.println("User Details already exists ...");
		}
		else
		{		
			adduobj = this.userRepository.save(user);
		}
		return adduobj;

	}

	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	
	@Override
	public User getUserById(String email) {
		Optional<User> userOptional = this.userRepository.findById(email);

    	User uObj = null;
        if(userOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	uObj = userOptional.get();
        }
        else
        {
        	System.out.println("ScheduleTour does not exists");
        }

        return uObj;
}
	

	@Override
	public User updateUser(User user, String email) {
		Optional<User> userOptional = this.userRepository.findById(email);

    	User uObj = null;
    	User updatedData = null;

        if(userOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Update !!!");
        	uObj = userOptional.get();
 

           	uObj.setName(user.getName());
        	uObj.setMobileNo(user.getMobileNo());
        	uObj.setAccountNo(user.getAccountNo());
        	uObj.setAddress(user.getAddress());
        	uObj.setPassword(user.getPassword());
 
//        	saving the final updated value to db
        	updatedData = this.userRepository.save(uObj);
        	
        }

//        returning the updated value to user
        return updatedData;
	}

	
	
	@Override
	public boolean delUser(String email) {
		Optional<User> tourOptional = this.userRepository.findById(email);

    	boolean status=false;

        if(tourOptional.isPresent())
        {
        	System.out.println("Record Exists and ready for Delete !!!");
        	this.userRepository.delete(tourOptional.get());
        	status=true;
        }
        else
        {
        	System.out.println("User details does not exits for delete ..");
        }
        return status;
	}

}
