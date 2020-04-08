package com.htt.dao.impl;

import java.util.List;

import com.htt.dao.IUserDAO;
import com.htt.mapper.UserMapper;
import com.htt.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO  {

	@Override
	public UserModel findByEmailAndPasswordAndStatus(String email, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM users AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.role_id");
		sql.append(" WHERE email = ? AND password = ? AND u.status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), email, password, status);
		return users.isEmpty() ? null : users.get(0);
	}
}
