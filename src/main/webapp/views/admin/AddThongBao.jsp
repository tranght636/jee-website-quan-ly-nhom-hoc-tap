<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
	<form id="form-profile" action="/admin/thong-bao-deadline?action=create_thong_bao" method="POST"> 
		<div class="form-group row">
			<label for="newpassword" class="col-sm-2 col-form-label">Lớp:</label>
			<div class="col-sm-10">
				<select name="loaiThongBao" class="btnSort btn-info btn"
					style="background-color: white; color: black; width: 100%">
					<option value="dangkylichtraining">_(danh sách)lớp_</option>
					<option value="thongbaonghi">Jwat 01</option>
					<option value="thongbaonghi">Jwat 02</option>
					<option value="thongbaonghi">Jwat 03</option>
					<option value="thongbaonghi">Jwat 04</option>
				</select>
			</div>
		</div>
		<div class="form-group row">
			<label for="newpassword" class="col-sm-2 col-form-label">Loại
				Thông báo:</label>
			<div class="col-sm-10">
				<select id="gender" class="btnSort btn-info btn"
					onchange="genderChanged(this)"
					style="background-color: white; color: black; width: 100%">
					<option value="khac">khác</option>
					<option value="dangkylichtrai">đăng ký lịch train</option>
				</select>
			</div>
		</div>
		<div class="form-group row">

			<label for="newpassword" class="col-sm-2 col-form-label ">Đăng
				ký lịch cho tuần:</label>
			<div class="col-sm-10">
				<input id="idinputWeek" type="week" name="weekSoanLich"
					class="btnSort btn-info btn"
					style="background-color: white; color: black; width: 300px;" />
			</div>
		</div>
		<div class="form-group row">
			<label for="newpassword" class="col-sm-2 col-form-label">Thời
				hạn đăng ký:</label>
			<div class="col-sm-10">
				<input name="thoiHan" type="date" name="dob"
					class="btnSort btn-info btn"
					style="background-color: white; color: black; width: 300px;" />

			</div>
		</div>
		<div class="form-group row">
			<label for="newpassword" class="col-sm-2 col-form-label">Tiêu
				đề:</label>
			<div class="col-sm-10">
				<textarea name="title" id="title"class="form-control" rows="1"
					style="width: 100%;"></textarea>
			</div>
		</div>
		<div class="form-group row">
			<label for="newpassword" class="col-sm-2 col-form-label">Nội
				dung:</label>
			<div class="col-sm-10">
				<textarea id="editorContentThongBao" name="editorContentThongBao" cols="80" rows="5" style="width: 100%;">
				</textarea>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2"></div>
			<div class="col-sm-10">
				<button id="btn-save-add-Thong-Bao" type="submit"
					class="btn btn-primary mb-2">Lưu</button>
			</div>
		</div>
	 </form>
<!-- 

	(3): Code Javascript thay thế textarea có id='editor1' bởi CKEditor
	<script>
		CKEDITOR.replace('editorContentThongBao');
	</script> -->
</body>
</html>