package com.htt.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htt.entity.UserEntity;
import com.htt.service2.UserService;
import com.htt.utils.ConvertUtil;
import com.htt.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/api/test" })
public class TestMyORM extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	UserService userService;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Object users = userService.selectList();
		DispatcherUtil.send(res, users);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserEntity user = ConvertUtil.toModelOfAPI(UserEntity.class, req);
		if (userService.insertOne(user) != -1) {
			DispatcherUtil.send(res, 1);
			return;
		}
		DispatcherUtil.send(res, 0);
		return;
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserEntity user = ConvertUtil.toModelOfAPI(UserEntity.class, req);
		if (userService.updateOne(user) != -1) {
			DispatcherUtil.send(res, 1);
			return;
		}
		DispatcherUtil.send(res, 0);
		return;
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserEntity user = ConvertUtil.toModelOfAPI(UserEntity.class, req);
		if (userService.deleteOne(user) != -1) {
			DispatcherUtil.send(res, 1);
			return;
		}
		DispatcherUtil.send(res, 0);
		return;
	}
}
