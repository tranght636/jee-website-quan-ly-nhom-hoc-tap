package com.htt.service;

import com.htt.model.UserModel;

public interface IUserService {
	UserModel findByEmailAndPasswordAndStatus(String userName, String password, Integer status);
}
