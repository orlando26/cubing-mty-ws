$(document).ready(function(){
	$('#startdatepicker').datetimepicker({ footer: true, modal: true, format: 'dd/mm/yyyy HH:MM' });
    $('#enddatepicker').datetimepicker({ footer: true, modal: true, format: 'dd/mm/yyyy HH:MM' }); 
    
    
    $('#save-tourney-btn').click(saveTourney);
});

function saveTourney(){
	let tourney = {
			"name": $('#name-input').val(),
			"startDate": $('#startdatepicker').val(),
			"endDate": $('#enddatepicker').val()
	}
	
	$.ajax({
		type: "POST",
		url: "/api/v1/tourney",
		data: JSON.stringify(tourney),
		success: response => { 
			console.log(response);
			showMessage(response.status, response.responsetext);
		},
		contentType : "application/json"
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