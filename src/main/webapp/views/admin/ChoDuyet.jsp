<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- https://bootsnipp.com/snippets/2P90 -->
<div class="container-fluid">
	<div >
		<select name="loaiThongBao" class="btnSort btn-info btn" style="background-color: white;color: black;">
			<option value="dangkylichtraining">Mới nhất</option>
			<option value="dangkylichtraining">a-z</option>
			<option value="thongbaonghi">z-a</option>
		</select>
		<button type="button" class="btn btn-outline-danger" style="color: black; ">Duyệt</button>
		<button type="button" class="btn btn-outline-danger" style="color: black; "> Xóa</button>
	</div>
	<div class="list-group" style="margin-top: 5px;">
	<c:forEach var = "i" begin = "1" end = "5">
		<a href="#"
			class="list-group-item list-group-item-action flex-column align-items-start ">
			<div class="d-flex w-100 justify-content-between">
				<h5 class="mb-1 a-list-users">Hoàng Thùy Trang</h5>
				<small class="text-muted"> 
					<select name="loaiThongBao"
						class="select-filter">
							<option value="dangkylichtraining">_lớp_</option>
							<option value="thongbaonghi">Jwat 01</option>
							<option value="thongbaonghi">Jwat 02</option>
							<option value="thongbaonghi">Jwat 03</option>
							<option value="thongbaonghi">Jwat 04</option>
					</select>
				</small>
			</div> <small class="text-muted">SĐT: 0352902224 - Email:
				Tranght636@gmail.com - SN: 16/2/1996 - Địa chỉ: Thôn 8, Nhân Cơ,
				ĐakRlap, ĐakNong. </small>
			<div style="float: right;">

				<i style="color: blue; margin-right: 5px;">Accept</i> <i
					class="delete" style="margin-bottom: 0px;"></i>

			</div>

		</a>
</c:forEach>

	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="modalThongTinTaiKhoan" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">THÔNG TIN
					TÀI KHOẢN</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="/jwat/updateUser" method="post">
				<div class="modal-body div-dangki">
					<table>
						<tr>
							<td class="text-align-right font-text-dangki">Tên:</td>
							<td><input id="modal-info-user-name" type="text"
								name="username" style="width: 300px" /></td>
						</tr>
						<tr>
							<td class="text-align-right font-text-dangki">Email:</td>
							<td><input id="modal-info-user-email" type="email"
								name="email" style="width: 300px" /></td>
						</tr>

						<tr>
							<td class="text-align-right font-text-dangki">Ngày sinh:</td>
							<td><input id="modal-info-user-dob" type="date" name="dob"
								style="width: 300px" /></td>
						</tr>
						<tr>
							<td class="text-align-right font-text-dangki">Trường:</td>
							<td><input id="modal-info-user-university" type="text"
								name="university" style="width: 300px" /></td>
						</tr>
						<tr>
							<td class="text-align-right font-text-dangki">Avatar:</td>
							<td><img id="modal-info-user-avatart"
								style="width: 300px; height: 150px;"
								src='<c:url value="/resources/image/img-user.jpg"/>' alt="icon" />
								<br /> <input type="file" name="avatar"></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Đóng</button>
					<button type="submit" class="btn btn-primary">Lưu</button>
				</div>
			</form>
		</div>
	</div>
</div>