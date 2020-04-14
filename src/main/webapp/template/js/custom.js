function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
}

function hideMessage() {
	$('.span-email-exist').attr("hidden", "hidden");
	$('.btn-create').removeAttr("disabled");
}

function showMessage() {
	$('.span-email-exist').removeAttr('hidden');
	$('.btn-create').attr("disabled", "disabled");
}

$(document).ready(function() {
	$("#btn-save-change").click(function(event) {
		event.preventDefault();
		var password = $('#new-password').val();
		var confirm = $('#confirm').val();
		if (password !== confirm) {
			$('#confirm-incorrect').removeAttr('hidden');
		} else {
			$('#confirm-incorrect').attr('hidden', 'hidden');
			$('#form-profile').submit();
		}
	});
	$(".btnSuaTaiKhoan").click(function() {
		var idUser = $(this).attr("user-id");
		var data = {
			id : idUser
		};
		$.ajax({
			url : '/api/users?action=get_user',
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				if (result !== null) {
					$("#user-id").val(result.id);
					$("#email").val(result.email);
					$("#username").val(result.username);
					$("#phone").val(result.phoneNumber);
					$("#address").val(result.address);
					$("#dob").val(formatDate(result.dob));
					$("#university").val(result.university);
				}
			}
		});
	});
	$(".btnDeleteTaiKhoan").click(function(){
		var idUser = $(this).attr("user-id");
		var This = $(this);
		var data = {
			id : idUser
		};
		$.ajax({
			url : '/api/users?action=delete_user',
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				if (result == true) {
					This.closest("a").remove();
				}
				else {
					alert("bug");
				}
			}
		});
		
	});
	
	$('.input-register-email').keyup(function() {
		var inputEmail = $(this);
		clearTimeout(inputEmail.data('timeout'));
		inputEmail.data('timeout', setTimeout(function() {
			if (inputEmail	.val() !== '') {
				var data = {
					email : inputEmail.val()
				}
				$.ajax({
					url : '/api/users?action=check_email_exist',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						if (result == 1) {
							showMessage();
						} else{
							hideMessage();
						}
					}
				});
			} else {
				hideMessage();
			}
		}, 500));
	});
	
	
	/*$("#btn-edit-change").click(function() {
		var idUser = $("#user-id").val();
		var username = $("#username").val();
		var staticEmail=$("#email").val();
		var phone=$("#phone").val();
		var address=$("#address").val();
		var dob=$("#dob").val();
		var university=$("#university").val();
		var data = {
			id : idUser,
			username:username,
			email :staticEmail,
			phoneNumber:phone,
			address :address,
			dob:dob,
			university:university
		};
		console.log(data);
		$.ajax({
			url : '/api/users?action=edit_user',
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				if (result === 1) {
					window.location = "/admin/thanh-vien?action=thanhvien&message=update_thanh_cong&alert=success";
				}
				else{
					window.location = "/admin/thanh-vien?action=thanhvien&message=update_that_bai&alert=warning";
				}
			}
		});
	});
*/
});