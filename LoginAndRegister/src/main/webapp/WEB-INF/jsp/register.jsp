<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<form:form action="registerSuccess" method="post" modelAttribute="registeruser">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Registration</h2></td>
				</tr>
				<tr>
					<td><b>User Name: </b></td>
					<td ><form:input path="username"/></td>
				</tr>
				<tr>
					<td><b>Email: </b></td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td><b>Password: </b></td>
					<td><form:password path="password"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>