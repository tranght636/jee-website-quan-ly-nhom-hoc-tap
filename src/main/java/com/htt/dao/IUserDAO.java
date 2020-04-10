package com.htt.dao;

import com.htt.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByEmailAndPassword(String userName, String password);
	Integer save(UserModel userModel);
	Boolean isEmailExist(String email);
}
