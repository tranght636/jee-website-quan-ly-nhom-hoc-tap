package com.htt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.htt.model.RoleModel;
import com.htt.model.ThongBaoModel;
import com.htt.model.UserModel;

public class ThongBaoMapper implements RowMapper<ThongBaoModel> {
	@Override
	public ThongBaoModel mapRow(ResultSet resultSet) {
		try {
			ThongBaoModel thongBao = new ThongBaoModel();
			thongBao.setId(resultSet.getInt("id"));
			thongBao.setTitle(resultSet.getString("title"));
			thongBao.setContent(resultSet.getString("content"));
			thongBao.setToClass(resultSet.getString("to_classes"));
			thongBao.setStatus(resultSet.getInt("status"));
			thongBao.setCreatedDate(resultSet.getTimestamp("created_date"));
			thongBao.setModifiedDate(resultSet.getTimestamp("modified_date"));
			thongBao.setCreatedBy(resultSet.getInt("created_by"));
			thongBao.setModifiedBy(resultSet.getInt("modified_by"));
			return thongBao;
		} catch (SQLException e) {
			return null;
		}	
	}
}
