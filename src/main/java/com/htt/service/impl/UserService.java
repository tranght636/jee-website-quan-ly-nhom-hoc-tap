package com.htt.service.impl;

import com.htt.dao.IUserDAO;
import com.htt.dao.impl.UserDAO;
import com.htt.model.UserModel;
import com.htt.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByEmailAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByEmailAndPasswordAndStatus(userName, password, status);
	}
	
}
