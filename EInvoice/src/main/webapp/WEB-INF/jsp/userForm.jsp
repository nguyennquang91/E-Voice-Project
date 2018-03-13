<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create/Edit User</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
    <div align="center">
        <h1>Create/Edit User</h1>
        <form:form action="saveUser" method="post" modelAttribute="user">
        <table>
            <form:hidden path="id"/>
            <form:hidden path="role.id"/>
            <form:hidden path="enabled"/>
            <tr>
                <td>Username: </td>
                <td><form:input path="username" required="required"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password" required="required"/></td>
            </tr>
            <tr>
            	<td>Email:</td>
            	<td><form:input path="email" required="required"/></td>
            </tr>
            <tr>
            	<td>Expense limit</td>
            	<td><form:input path="expenseLimit"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>