package com.sm.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.model.UserModel;
import com.sm.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean checkUserExists(String email) {
		UserModel user = new UserModel();
		user = userRepository.findByEmail(email);
		if(user == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLoginUser(String email, String Password) {
		UserModel user = new UserModel();
		user = userRepository.findUserByEmailAndPassword(email, Password);
		if(user == null) {
			return false;
		}
		return true;
	}

}
