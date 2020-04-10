$(document).ready(function() {
	$('#input-register-email').keyup(function() {
	    clearTimeout($(this).data('timeout'));
	    $(this).data('timeout', setTimeout(function () {
	        
	    }, 500));
	});
});