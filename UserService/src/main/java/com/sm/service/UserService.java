package com.sm.service;


public interface UserService {
	

	public boolean checkUserExists(String email);
	public boolean checkLoginUser(String email , String Password);
//	public Object saveUserDetails(UserModel user) ;
}
