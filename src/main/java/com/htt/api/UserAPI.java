package com.htt.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htt.constant.ActionConstant;
import com.htt.model.CommonModel;
import com.htt.model.UserModel;
import com.htt.service.IUserService;
import com.htt.utils.DispatcherUtil;
import com.htt.utils.HttpUtil;

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
			}else if(action.equals(ActionConstant.DUYET_USER)) {
				duyetUser(req,res);
			}else if(action.equals(ActionConstant.DUYET_USERS)) {
				duyetUsers(req,res);
			}else if(action.equals(ActionConstant.DELETE_USERS_CHO_DUYET)) {
				xoaUsersChoDuyet(req,res);
			}else if(action.equals(ActionConstant.DELETE_USER_CHO_DUYET)) {
				xoaUserChoDuyet(req,res);
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
	private void duyetUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		CommonModel model = HttpUtil.of(req.getReader()).toModel(CommonModel.class);
		Boolean duyetIdUser=userService.duyetUser(model.getId());
		DispatcherUtil.send(res, duyetIdUser);
	}
	private void duyetUsers(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//		String ids = req.getParameter("ids"); // lấy kiểu này chưa được???
//		System.out.println(ids);
		CommonModel model = HttpUtil.of(req.getReader()).toModel(CommonModel.class);
		Boolean duyetIdUsers=userService.duyetUsers(model.getIds());
		DispatcherUtil.send(res, duyetIdUsers);
	}
	private void xoaUsersChoDuyet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		CommonModel model = HttpUtil.of(req.getReader()).toModel(CommonModel.class);
		Boolean xoaIdUsersChoDuyet=userService.xoaIdUsersChoDuyet(model.getIds());
		DispatcherUtil.send(res, xoaIdUsersChoDuyet);
	}
	private void xoaUserChoDuyet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CommonModel model = HttpUtil.of(req.getReader()).toModel(CommonModel.class);
		Boolean xoaUserChoDuyet=userService.xoaUserChoDuyet(model.getId());
		DispatcherUtil.send(res, xoaUserChoDuyet);		
	}
	/*
	 * private void postEditUser(HttpServletRequest req, HttpServletResponse res)
	 * throws ServletException, IOException { UserModel userModel =
	 * HttpUtil.of(req.getReader()).toModel(UserModel.class); if
	 * (userService.update(userModel)) { DispatcherUtil.send(res, 1); } else {
	 * DispatcherUtil.send(res, 0); } }
	 */
}
