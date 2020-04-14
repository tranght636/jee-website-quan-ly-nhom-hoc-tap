package com.htt.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.htt.constant.ActionConstant;
import com.htt.constant.SystemConstant;
import com.htt.model.CommonModel;
import com.htt.model.UserModel;
import com.htt.service.IUserService;
import com.htt.utils.DispatcherUtil;
import com.htt.utils.FormUtil;
import com.htt.utils.HttpUtil;
import com.htt.utils.SessionUtil;

@WebServlet(urlPatterns = { "/api/users" })
public class UserAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.CHECK_EMAIL_EXIST)) {
				postCheckEmailExist(req, res);
			} else if (action.equals(ActionConstant.GET_USER)) {
				postGetUser(req, res);
			} else if(action.equals(ActionConstant.DELETE_USER)) {
				deleteUser(req,res);
			}
			/*
			 * else if (action.equals(ActionConstant.EDIT_USER)) { postEditUser(req, res); }
			 */
		}
	}

	

	@Inject
	IUserService userService;

	private void postCheckEmailExist(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		CommonModel model = HttpUtil.of(req.getReader()).toModel(CommonModel.class);
		if (userService.isEmailExist(model.getEmail())) {
			DispatcherUtil.send(res, 1);
		} else {
			DispatcherUtil.send(res, 0);
		}
	}

	private void postGetUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CommonModel model = HttpUtil.of(req.getReader()).toModel(CommonModel.class);
		UserModel user = userService.findOne(model.getId());
		DispatcherUtil.send(res, user);
	}
	private void deleteUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		CommonModel model = HttpUtil.of(req.getReader()).toModel(CommonModel.class);
		Boolean delUser=userService.deleteUser(model.getId());
		DispatcherUtil.send(res, delUser);
	}
	/*
	 * private void postEditUser(HttpServletRequest req, HttpServletResponse res)
	 * throws ServletException, IOException { UserModel userModel =
	 * HttpUtil.of(req.getReader()).toModel(UserModel.class); if
	 * (userService.update(userModel)) { DispatcherUtil.send(res, 1); } else {
	 * DispatcherUtil.send(res, 0); } }
	 */
}
