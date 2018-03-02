<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<input id="username" type="text" />
<button id="reg">Register</button>
<script>
jQuery(document).ready(function($) {
	$("#reg").on('click', function(){
		var data = {
				username: $('#username').val(),
				password:'pass-' +  $('#username').val()
		};
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "ajax/addUser",
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(data) {
				console.log("SUCCESS: ", data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	});
});

</script>
</body>
</html>