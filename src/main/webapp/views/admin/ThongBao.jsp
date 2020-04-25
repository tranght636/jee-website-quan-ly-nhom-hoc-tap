<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
	<!-- start add notification and search -->
	<div style="width: 100%;">
		<div class="row">
			<a  class="btn btn-outline-danger" href='<c:url value="/admin/thong-bao-deadline?action=add_thong_bao"/>'>Thêm</a>
		</div>
		<!-- end add notification and search -->
		<!-- start content notification  -->
		<div>
			<div class="div-select-filter">
				<select name="loaiThongBao" class="select-filter">
					<option value="dangkylichtraining">()Lấy danh sách lớp)Tất cả</option>
					<option value="thongbaonghi">Jwat 01</option>
					<option value="thongbaonghi">Jwat 02</option>
					<option value="thongbaonghi">Jwat 03</option>
					<option value="thongbaonghi">Jwat 04</option>
				</select>
			</div>
		</div>

		<div>
			<ul class="list-group ul-notification-admin">
				<c:forEach var="thongBao" items="${dsThongBao}">
					<li
						class="list-group-item d-flex justify-content-between align-items-center">
						<div style="margin-right: 25px;">
							<a class="a-notification-admin" href="admin/contentNotification">
								${thongBao.title} </a> 
								<span style="color: #2b2b2b; font-size: 13px;"> ${thongBao.createdDate} </span>
								<span style="color: #f00; font-size: 16px"> *new</span>

						</div> 
						<a  class="edit" href='<c:url value="/admin/thong-bao-deadline?action=edit_thong_bao"/>'></a>
						<!-- <i class="edit" data-toggle="modal"
						data-target="#EditNotificationModalCenter"></i> --> <i class="delete"></i>
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
</div>