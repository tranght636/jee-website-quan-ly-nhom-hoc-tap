package com.htt.dao.impl;

import java.util.List;

import com.htt.dao.IThongBaoDAO;
import com.htt.mapper.ThongBaoMapper;
import com.htt.model.ThongBaoModel;

public class ThongBaoDAO extends AbstractDAO<ThongBaoModel> implements IThongBaoDAO {

	@Override
	public List<ThongBaoModel> findAll() {
		String sql = "select * from notifications where status = 1";
		return query(sql, new ThongBaoMapper());
	}

	@Override
	public Integer save(ThongBaoModel thongBaoModel) {
		
		/*
		 * String sql =
		 * "INSERT INTO `dbjeejspservlet`.`notifications` (`title`, `content`, `to_classes`,"
		 * + " `status`, `created_date`, `modified_date`, `created_by`, `modified_by`) "
		 * + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; return insert(sql,
		 * thongBaoModel.getTitle(), thongBaoModel.getContent(),
		 * thongBaoModel.getToClass(), thongBaoModel.getStatus(),
		 * thongBaoModel.getCreatedDate(), thongBaoModel.getModifiedDate(),
		 * thongBaoModel.getCreatedBy(), thongBaoModel.getModifiedBy());
		 */
		String sql="INSERT INTO `dbjeejspservlet`.`notifications` (`title`, `content`, `to_classes`, `status`, `created_date`, `modified_date`, `created_by`, `modified_by`) VALUES ('ab', 'ab', '2', '1', '2008-01-01 00:00:01', '2008-01-01 00:00:01', '1', '1')"; 
		return insert(sql);
				
	}
}