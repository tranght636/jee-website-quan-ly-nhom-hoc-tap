package com.htt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.htt.dao.IUserDAO;
import com.htt.mapper.UserMapper;
import com.htt.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO  {

	@Override
	public UserModel findByEmailAndPassword(String email, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM users AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.role_id");
		sql.append(" WHERE email = ? AND password = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), email, password);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Integer save(UserModel userModel) {
		String sql = "INSERT INTO `dbjeejspservlet`.`users` (`email`, `username`, `password`, `phone_number`, `address`, `dob`, `university`, `role_id`, `status`)  VALUES (?,?,?,?,?,?,?,?,?)";
		return insert(sql, userModel.getEmail(), userModel.getUsername(), userModel.getPassword(), userModel.getPhoneNumber(), userModel.getAddress(), userModel.getDob(), userModel.getUniversity(), userModel.getRoleId(), userModel.getStatus());
	}

	@Override
	public Boolean isEmailExist(String email) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select 1 from users where email = ?";
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, email);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
}
