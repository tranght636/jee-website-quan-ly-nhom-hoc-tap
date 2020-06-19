<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- start add user -->
<div class="container-fluid">
<div class="row">
<div class="col-sm-6">
	<div class="input-group md-form form-sm form-2 pl-0 "  style="margin-bottom: 5px;">
		<div class="input-group-prepend">
			<span class="btn input-group-text red lighten-3 backward span-ward"></span>
		</div>
		<input id="idinputWeek" type="week" name="weekSoanLich"
			style="width: 200px; height: 30px; border: 1px solid #999;" />
		<div class="input-group-append ">
			<span class="btn input-group-text red lighten-3 forward span-ward"></span>
		</div>
	</div>
</div>
<div class="col-sm-6">
	<div class="div-select-filter">
		Lọc:
			<select name="loaiThongBao" class="slbtnSort">
				<option value="dangkylichtraining">Tất cả</option>
				<option value="thongbaonghi">Jwat 01</option>
				<option value="thongbaonghi">Jwat 02</option>
				<option value="thongbaonghi">Jwat 03</option>
				<option value="thongbaonghi">Jwat 04</option>
			</select>
			<select name="loaiThongBao" class="slbtnSort">
				<option value="dangkylichtraining">Tất cả</option>
				<option value="thongbaonghi">Chưa đăng ký</option>
				<option value="thongbaonghi">Đăng ký sáng thứ 2</option>
				<option value="thongbaonghi">Đăng ký chiều thứ 2</option>
				<option value="thongbaonghi">Đăng ký sáng thứ 3</option>
				<option value="thongbaonghi">Đăng ký chiều thứ 3</option>
				<option value="thongbaonghi">Đăng ký sáng thứ 4</option>
				<option value="thongbaonghi">Đăng ký chiều thứ 4</option>
				<option value="thongbaonghi">Đăng ký sáng thứ 5</option>
				<option value="thongbaonghi">Đăng ký chiều thứ 5</option>
				<option value="thongbaonghi">Đăng ký sáng thứ 6</option>
				<option value="thongbaonghi">Đăng ký chiều thứ 6</option>
				<option value="thongbaonghi">Đăng ký sáng thứ 7</option>
				<option value="thongbaonghi">Đăng ký chiều thứ 7</option>
				<option value="thongbaonghi">Đăng ký sáng chủ nhật</option>
				<option value="thongbaonghi">Đăng ký chiều chủ nhật</option>
			</select>
			<select name="loaiThongBao" class="slbtnSort">
				<option value="dangkylichtraining">a-z</option>
				<option value="thongbaonghi">z-a</option>
			</select>
			
	</div>
</div>

</div>
	<table class="table table-bordered table-hover"
		style="text-align: center; color: black;">
		<thead>
			<tr>
				<th scope="col" rowspan="2">STT</th>
				<th scope="col" rowspan="2">Họ Tên</th>
				<th scope="col" colspan="2">Thứ 2</th>
				<th scope="col" colspan="2">Thứ 3</th>
				<th scope="col" colspan="2">Thứ 4</th>
				<th scope="col" colspan="2">Thứ 5</th>
				<th scope="col" colspan="2">Thứ 6</th>
				<th scope="col" colspan="2">Thứ 7</th>
				<th scope="col" colspan="2">chủ nhật</th>
			</tr>
			<tr>
				<th scope="col">S</th>
				<th scope="col">C</th>
				<th scope="col">S</th>
				<th scope="col">C</th>
				<th scope="col">S</th>
				<th scope="col">C</th>
				<th scope="col">S</th>
				<th scope="col">C</th>
				<th scope="col">S</th>
				<th scope="col">C</th>
				<th scope="col">S</th>
				<th scope="col">C</th>
				<th scope="col">S</th>
				<th scope="col">C</th>
			</tr>
		</thead>
		<tbody>
			<%-- <c:forEach var = "i" begin = "0" end = "${dsDangKyLich.size()}"> --%>
			<c:forEach var = "i" items= "${dsDangKyLich}">
				<tr>
					<%-- <th scope="row">${i+1}</th> --%>
					<th scope="row"></th>
					<td class="d-flex w-100 justify-content-between">${i.username}
					<%-- <td class="d-flex w-100 justify-content-between">${dsDangKyLich.get(i).getName()} --%>
					<sup><small class="text-muted">${i.className} </small> </sup>
					</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
					<td>x</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	</div>