$(document).ready(function(){
	$('#register-btn').click(function() {
		if($('#password-input').val() == $('#password2-input').val()){
			registerUser();
		}else{
			showMessage("ERROR", "Passwords no coinciden!");
		}
	});
});

function registerUser(){
	let user = {
			"name": $('#name-input').val(),
			"wcaId": $('#wcaid-input').val(),
			"email": $('#email-input').val(),
			"password": $('#password-input').val(),
			"roles": [{
				"id": 1
			}]
	}
	
	$.ajax({
		url: '/api/v1/user',
		type: 'post',
		data: JSON.stringify(user),
		contentType: "application/json",
		success: function(response){
			showMessage(response.status, response.responsetext);
		},
	});
}


function showMessage(type, msg){
	var msgDiv = (type == 'ERROR')? '#alertError' : '#alertSuccess'
		$(msgDiv).show('fade');
	$(msgDiv + ' > span').text(msg);
	setTimeout(function() {
		$(msgDiv).hide('fade');
	}, 2000);
}