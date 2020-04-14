package com.htt.service;

import java.util.List;

import com.htt.model.UserModel;

public interface IUserService {
	UserModel findOne(Integer id);
	UserModel findByEmailAndPassword(String userName, String password);
	Integer register(UserModel userModel);
	Boolean isEmailExist(String email);
	boolean update(UserModel userModel);
	List<UserModel> findAll();
	Boolean deleteUser(Integer id);
	Integer createUser(UserModel userModel);
}
