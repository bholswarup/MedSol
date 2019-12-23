package com.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.constant.ConstantEndpoint;
import com.sm.exceptons.JsonMappingExceptionImpl;
import com.sm.model.UserModel;
import com.sm.repository.UserRepository;
import com.sm.service.UserService;
import com.sm.status.Status;

@RestController
@RequestMapping("/api/medsol/v1")
public class UserController {
	UserModel user;
	JsonMappingExceptionImpl mapper;

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public Object createUser(@RequestBody String json) {
		HttpHeaders headers = new HttpHeaders();
		user = new UserModel();
		mapper = new JsonMappingExceptionImpl();
		user = (UserModel) mapper.checkRequestData(user, json);
		if (user.getEmail() != null && user.getPassword() != null) {
//			user =  userService.checkUserExists(user.getEmail());
			boolean userExist = userService.checkUserExists(user.getEmail());
			if (!userExist) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				userRepository.save(user);
				Status status = new Status();
				status.setSuccessful(false);
				status.setMessage(ConstantEndpoint.USER_CREATED);
				return new ResponseEntity<Object>(user, headers, HttpStatus.CREATED);
			} else {
				Status status = new Status();
				status.setSuccessful(false);
				status.setMessage(ConstantEndpoint.USER_EXISTS);
				return new ResponseEntity<Object>(status, headers, HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}
		Status status = new Status();
		status.setSuccessful(false);
		status.setMessage(ConstantEndpoint.STATUS_FAILURE);
		return new ResponseEntity<Object>(status, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
