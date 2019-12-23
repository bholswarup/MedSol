package com.sm.repository;

import org.springframework.stereotype.Repository;

import com.sm.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	UserModel findByEmail(String email);
}