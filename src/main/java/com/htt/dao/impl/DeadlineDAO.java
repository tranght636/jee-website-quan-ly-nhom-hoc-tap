package com.htt.dao.impl;

import java.util.List;

import com.htt.dao.IDeadlineDAO;
import com.htt.mapper.DeadlineMapper;
import com.htt.mapper.ThongBaoMapper;
import com.htt.model.DeadlineModel;

public class DeadlineDAO extends AbstractDAO<DeadlineModel> implements IDeadlineDAO {

	@Override
	public List<DeadlineModel> findAll() {
		String sql = "select * from deadline where status= 1";
		return query(sql, new DeadlineMapper());
	}
	@Override
	public Integer save(DeadlineModel deadlineModel) {
		String sql = "INSERT INTO deadline"
				+ "(title, content, to_classes, due_date, is_register, week_in_year, "
				+ "status, created_date, modified_date, created_by, modified_by) "
				+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?);";
		int IsRegister =0;
		System.out.println(deadlineModel.getIsRegister());
		  if(deadlineModel.getIsRegister() == true) 
			  IsRegister = 1; 
		 
		return insert(sql, deadlineModel.getTitle(), deadlineModel.getContent(), deadlineModel.getToClass(),
				deadlineModel.getDueDate(), IsRegister, deadlineModel.getWeekInYear(),
				deadlineModel.getStatus(), deadlineModel.getCreatedDate(),
				deadlineModel.getModifiedDate(), deadlineModel.getCreatedBy(), deadlineModel.getModifiedBy());
	}

	@Override
	public DeadlineModel findOne(Integer id) {
		String sql = "SELECT * FROM deadline WHERE id =?";
		List<DeadlineModel> deadline = query(sql, new DeadlineMapper(), id);
		return deadline.isEmpty() ? null : deadline.get(0);
	}

	@Override
	public Integer update(DeadlineModel model) {
		/*
		 * UPDATE `dbjeejspservlet`.`deadline` SET `title` = 'a', `content` = 'a', `to_classes` = 'a', `due_date` = '2020-06-01 00:00:00', `week_in_year` = '2020-W26' WHERE (`id` = '38');
*/
//		String sql = "UPDATE deadline SET `title` = ?, `content` = ?, `to_classes` = ?, `due_date` = '2020-06-02 00:00:00', `modified_date` = '2020-06-1 14:53:31', `modified_by` = '6', `week_in_year` = '2020-W25' "
//				+ "WHERE (`id` = ?);";
		String sql="UPDATE deadline SET title = ?, content =?,to_classes=?,due_date=?,week_in_year=?  WHERE (id = ?);";
		//UPDATE `dbjeejspservlet`.`deadline` SET `title` = 'a', `content` = 'a', `to_classes` = 'a', `due_date` = '2020-06-01 00:00:00', `week_in_year` = '2020-W26' WHERE (`id` = '38');
		
		
		return insert(sql,model.getTitle(),model.getContent(),model.getToClass(),model.getDueDate(),model.getWeekInYear(),model.getId());
	}

	@Override
	public Boolean deleteDeadline(Integer id) {
		try {
			String sql = "UPDATE deadline SET status = -1 where (id = ?) ";
			update(sql,id);
		return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<DeadlineModel> findByClass(String classDeadline) {
		String sql = "select * from deadline where  status = 1 and to_classes = ?";
		return query(sql, new DeadlineMapper(), classDeadline);
	}

}
