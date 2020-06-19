package com.htt.dao2;

import com.htt.entity.ThongTinDangKyLichEntity;

public class ThongTinDangKyLichDAO extends CommonDao<ThongTinDangKyLichEntity>{
	/*
	SELECT * 
	FROM 
	user_register_schedule as urs, (select id, username from users) as u
	where u.id=urs.user_id;
	*/
	public Object selectAllAddName( Integer status) {
		//String sql = "SELECT * FROM user_register_schedule as urs, (select id, username from users) as u where u.id=urs.user_id and status = ?";
		String sql = "SELECT urs.*, u.username, c.name as 'class_name' FROM user_register_schedule as urs,"
				+ " (select id, username from users) as u,"
				+ " (select class_id, user_id from user_in_class) as uic, "
				+ " (select id, name from classes) as c "
				+ " where urs.user_id = u.id "
				+ " and u.id = uic.user_id "
				+ " and uic.class_id = c.id "
				+ " and status = ? ";
		return selecList(sql, status);
	}
	
}
