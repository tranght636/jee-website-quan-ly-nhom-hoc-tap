package com.htt.dao.impl;

import java.util.List;

import com.htt.dao.IThongBaoDAO;
import com.htt.mapper.ThongBaoMapper;
import com.htt.model.ThongBaoModel;

public class ThongBaoDAO extends AbstractDAO<ThongBaoModel> implements IThongBaoDAO {

	@Override
	public List<ThongBaoModel> findAll() {
		//String sql = "select * from notifications where status = 1";
		String sql = "select * from notifications where  status = 1";
		return query(sql, new ThongBaoMapper());
	}

	@Override
	public Integer save(ThongBaoModel thongBaoModel) {

		String sql = "INSERT INTO  notifications  ( title ,  content ,  to_classes ,"
				+ "  status ,  created_date ,  modified_date ,  created_by ,  modified_by ) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		return insert(sql, thongBaoModel.getTitle(), thongBaoModel.getContent(), thongBaoModel.getToClass(),
				thongBaoModel.getStatus(), thongBaoModel.getCreatedDate(), thongBaoModel.getModifiedDate(),
				thongBaoModel.getCreatedBy(), thongBaoModel.getModifiedBy());

	}

	@Override
	public ThongBaoModel findOne(Integer id) {
		String sql = "SELECT * FROM notifications WHERE id = ?";
		List<ThongBaoModel> thongBao = query(sql, new ThongBaoMapper(), id);
		return thongBao.isEmpty() ? null : thongBao.get(0);
	}

	@Override
	public Integer update(ThongBaoModel thongBaoModel) {
		String sql="UPDATE notifications SET "
				+ " title  = ?, "
				+ " content  = ?,"
				+ "  to_classes  = ?, "
				+ " modified_date  = ?, "
				+ " modified_by  = ?"
				+ " WHERE ( id  = ?);";
		
		return insert(sql, thongBaoModel.getTitle(), thongBaoModel.getContent(), thongBaoModel.getToClass(),
				thongBaoModel.getModifiedDate(), thongBaoModel.getModifiedBy(),thongBaoModel.getId());
	}

	@Override
	public Boolean deleteThongBao(Integer id) {
		try {
			String sql = "UPDATE notifications SET  status  = -1 where ( id  = ?) ";
			update(sql,id);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<ThongBaoModel> findByClass(String clazz) {
		String sql = "select * from notifications where  status = 1 and to_classes = ?";
		return query(sql, new ThongBaoMapper(), clazz);
	}
}