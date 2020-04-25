package com.htt.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htt.constant.ActionConstant;
import com.htt.model.ThongBaoModel;
import com.htt.service.IThongBaoService;
import com.htt.utils.ConvertUtil;
import com.htt.utils.DispatcherUtil;

///api/thong-bao-deadline?action=add_thong_bao
@WebServlet(urlPatterns = { "/api/thong-bao-deadline" })
public class ThongBaoAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*
		 * String action = req.getParameter("action"); if (action != null) {
		 * if(action.equals(ActionConstant.ADD_THONG_BAO)) { createThongBao(req, res); }
		 * }
		 */
	}
	/*
	 * @Inject IThongBaoService thongBaoService; private void
	 * createThongBao(HttpServletRequest req, HttpServletResponse res) throws
	 * ServletException, IOException{ ThongBaoModel thongBaoModel =
	 * ConvertUtil.toModelOfAPI(ThongBaoModel.class, req);
	 * if(thongBaoService.createThongBao(thongBaoModel) != null) {
	 * DispatcherUtil.redirect(req, res,
	 * "/admin/thong-bao-deadline?action=thong_bao_va_deadline");
	 * //System.out.println(thongBaoService.createUser(thongBaoModel)); } }
	 */
}
