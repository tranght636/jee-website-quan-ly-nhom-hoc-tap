package com.htt.dao;

import com.htt.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByEmailAndPasswordAndStatus(String userName, String password, Integer status);
}
