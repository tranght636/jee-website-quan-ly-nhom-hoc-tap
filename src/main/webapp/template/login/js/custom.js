function hideAll(){
	$('#span-email-exist').hide();
	$('#span-email-not-exist').hide();
	$('#span-check-email').hide();
}

function setMessage(type){
	var spanExist = $('#span-email-exist');
	var spanNotExit = $('#span-email-not-exist');
	var spanCheck = $('#span-check-email');
	if(type === 'notExist'){
		hideAll();
		spanNotExit.show();
	} else if(type === 'exist'){
		hideAll();
		spanExist.show();
	} else if(type === 'check'){
		hideAll();
		spanCheck.show();
	}
}

$(document).ready(function() {
	hideAll();
	$('#input-register-email').keyup(function() {
		if($('#input-register-email').val() !== ''){
			clearTimeout($(this).data('timeout'));
			$(this).data('timeout', setTimeout(function() {
				setMessage('check')
				var data = {
					email : $('#input-register-email').val()
				}
				$.ajax({
					url : '/api/users?action=check_email_exist',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						if (result == 1) {
							setMessage('exist');
						} else if (result == 0) {
							setMessage('notExist');
						}
					}
				});
			}, 500));
		} else {
			hideAll();
		}
	});
});