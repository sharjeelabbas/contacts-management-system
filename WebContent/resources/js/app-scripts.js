/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function init() {
	signIn();
}

function signIn() {
	$.ajax({
		url : 'IndexServlet',
		type : 'post',
		data : {
			username : 'admin',
			password : 'test'
		},
		success : function(response) {
			console.log(response);
		}
	});
}

function personsOnReady() {
	var val = 0;
	var req = setInterval(function() {
		if (++val == 5) {
			val = 1;
			getRecordsCount();
		}
		console.log('seconds:', val);
	}, 1000);

	// Ajax Request
	function getRecordsCount() {
		$.ajax({
			url : 'persons',
			success : function(r) {
				console.log('Response', r, $('#temp').val())
				if ($('#temp').val() != r) {
					alert('Admin Notification ....')
					$('#temp').val(r)
				}
			}
		});
	}
}