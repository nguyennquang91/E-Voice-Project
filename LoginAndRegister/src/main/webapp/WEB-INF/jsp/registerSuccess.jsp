<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
		<table border="0">
			<tr>
				<td colspan="2" align="center"><h2>Registration Succeeded!</h2></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<h3>Thank you for registering! Here's the review of your details:</h3>
				</td>
			</tr>
			<tr>
				<td>My ID:</td>
				<td>u${user.id}</td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td>${user.username}</td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="/LoginAndRegister">Back</a></td>
			</tr>
		</table>
	</div>

</body>
</html>