package com.htt.service.impl;

import com.htt.constant.SystemConstant;
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
	public UserModel findByEmailAndPassword(String userName, String password) {
		return userDAO.findByEmailAndPassword(userName, password);
	}

	public Integer register(UserModel userModel) {
		userModel.setRoleId(SystemConstant.USER_ROLE_ID);
		userModel.setStatus(SystemConstant.STATUS_APPROVED);
		return userDAO.save(userModel);
	}

	@Override
	public Boolean isEmailExist(String email) {
		return userDAO.isEmailExist(email);
	}
	
}
