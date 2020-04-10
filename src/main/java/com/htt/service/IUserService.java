package com.htt.service;

import com.htt.model.UserModel;

public interface IUserService {
	UserModel findByEmailAndPassword(String userName, String password);
	Integer register(UserModel userModel);
	Boolean isEmailExist(String email);
}
