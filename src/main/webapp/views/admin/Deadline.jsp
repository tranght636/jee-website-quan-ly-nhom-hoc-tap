<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
	<!-- start add notification and search -->
	<div style="width: 100%;">
		<div class="row">
			<button type="button" class="btn btn-outline-danger"
				data-toggle="modal" data-target="#AddNotificationModalCenter">Thêm
			</button>
		</div>
		<!-- end add notification and search -->
		<!-- start content notification  -->
		<div>
			<div class="div-select-filter">
				<select name="loaiThongBao" class="select-filter">
					<option value="dangkylichtraining">Tất cả</option>
					<option value="thongbaonghi">Jwat 01</option>
					<option value="thongbaonghi">Jwat 02</option>
					<option value="thongbaonghi">Jwat 03</option>
					<option value="thongbaonghi">Jwat 04</option>
				</select>
			</div>
		</div>

		<div>
			<ul class="list-group ul-notification-admin">
				<c:forEach var="deadline" items="${dsDeadline}">
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						<div>
							<a class="a-notification-admin" href="admin/contentNotification">
								${deadline.title}</a> <span
								style="color: #2b2b2b; font-size: 13px;">${deadline.createdDate}</span>
								 <span style="color: #f00; font-size: 16px">*new</span>

						</div> <i class="edit" data-toggle="modal"
						data-target="#EditNotificationModalCenter"></i> <i class="delete"></i>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="row " style="padding-top: 10px">
			<nav aria-label="Page navigation example" style="margin-left: 40%;">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#">Previous</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>

		<!-- start Modal add Thông báo -->
		<div class="modal fade" id="AddNotificationModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="AddUserModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title ModalTitle" id="exampleModalLongTitle">THÊM
							THÔNG BÁO</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form id="form-profile" action="#" method="POST">
						<div class="row form-group "
							style="margin-left: 5px; margin-bottom: 5px;">
							<label for="LopNhanThongBao" class="col-sm-3 col-form-label">Lớp:</label>
							<div class="col-sm-9">
								<select name="LopNhanThongBao" class="ModalSizeInput">
									<option value="dangkylichtraining">Tất cả</option>
									<option value="thongbaonghi">Jwat 01</option>
									<option value="thongbaonghi">Jwat 02</option>
									<option value="thongbaonghi">Jwat 03</option>
								</select>
							</div>
						</div>
						<div class="row form-group " style="margin-left: 5px;">
							<label for="loaiThongBao" class="col-sm-3 col-form-label">Loại:</label>
							<div class="col-sm-9">
								<select id="gender" name="loaiThongBao"
									onchange="genderChanged(this)" class="ModalSizeInput">
									<option value="khac">khác</option>
									<option value="dangkylichtrain">đăng ký lịch train</option>
								</select>
							</div>
						</div>
						<div id="hiddenlichtuan" class="row form-group "
							style="margin-left: 5px; display: none;">
							<label for="loaiThongBao" class="col-sm-3 col-form-label">Lịch
								tuần:</label>
							<div class="col-sm-9">
								<input id="idinputWeek" type="week" name="weekSoanLich"
									class="ModalSizeInput" />
							</div>
						</div>
						<div id="hiddenthoihan" class="row form-group "
							style="margin-left: 5px; display: none;">
							<label for="loaiThongBao" class="col-sm-3 col-form-label">Thời
								hạn</label>
							<div class="col-sm-9">
								<input name="thoiHan" type="date" name="dob"
									class="ModalSizeInput" />
							</div>
						</div>

						<script language="javascript">
							// Hàm xử lý khi thẻ select thay đổi giá trị được chọn
							// obj là tham số truyền vào và cũng chính là thẻ select
							function genderChanged(obj) {
								if (obj.value === 'dangkylichtrain') {
									var embed1 = document
											.getElementById("hiddenlichtuan").style.display = 'block';
									var embed2 = document
											.getElementById("hiddenthoihan").style.display = 'block';
								} else {
									var embed1 = document
											.getElementById("hiddenlichtuan").style.display = 'none';
									var embed2 = document
											.getElementById("hiddenthoihan").style.display = 'none';
								}
							}
						</script>
						<div class="row form-group " style="margin-left: 5px;">
							<label for="loaiThongBao" class="col-sm-3 col-form-label">Tiêu
								đề:</label>
							<div class="col-sm-9">
								<textarea name="tieuDe" class="form-control ModalSizeInput"
									rows="1"></textarea>
							</div>
						</div>
						<div class="row form-group " style="margin-left: 5px;">
							<label for="loaiThongBao" class="col-sm-3 col-form-label">Nội
								dung:</label>
							<div class="col-sm-9">
								<textarea name="noiDung" class="form-control ModalSizeInput"
									rows="5"></textarea>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Đóng</button>
							<button type="submit" class="btn btn-primary btn-create">OK</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- end Modal add Thông báo -->


		<!-- start Modal edit notification -->
		<div class="modal fade" id="EditNotificationModalCenter" tabindex="-1"
			role="dialog" aria-labelledby="EditNotificationModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<!--nếu chọn loại thông báo đăng ký lịch-->
						<h5 class="modal-title ModalTitle" id="accountModalLongTitle">SỬA
							THÔNG BÁO</h5>
						<!--nếu chọn loại khác  -->
						<!-- <input type="text" style="width: 300px" /> -->
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="/jwat/suathongbao" method="post">
						<div class="modal-body">
							<table style="width: 100%" class="table-responsive">
								<tr>
									<td>Lớp nhận thông báo:</td>
									<td><select name="loaiThongBao" class="ModalSizeInput">
											<option value="dangkylichtraining">Tất cả</option>
											<option value="thongbaonghi">Jwat 01</option>
											<option value="thongbaonghi">Jwat 02</option>
											<option value="thongbaonghi">Jwat 03</option>
									</select></td>
								</tr>
								<tr>
									<td>Loại thông báo:</td>
									<td><select name="loaiThongBao" class="ModalSizeInput">
											<option value="dangkylichtraining">Đăng ký lịch
												training</option>
											<option value="thongbaonghi">Khác</option>

									</select></td>

								</tr>
								<tr>
									<td>Đăng ký lịch cho tuần:</td>
									<td><input id="idinputWeek" type="week"
										name="weekSoanLich" class="ModalSizeInput" /></td>
								</tr>
								<tr>
									<td>Thời hạn đăng ký:</td>
									<td><input name="thoiHan" type="date" name="dob"
										class="ModalSizeInput" /></td>
								</tr>
								<tr>
									<td>Tiêu đề:</td>
									<td><input name="tieuDe" type="text"
										class="ModalSizeInput" /></td>
								</tr>
								<tr>
									<td>Nội dung:</td>
									<td><textarea name="noiDung"
											class="form-control ModalSizeInput" rows="5"></textarea></td>
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
	</div>

	<!-- end Modal edit notification -->
