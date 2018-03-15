<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/styleForm.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<title>Create User</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
<div class="form-page">
<h1>Register</h1>
<div class="form">
<div class="bs-example">
 		<p style="color: red;"><c:out value = "${message}"/></p>
     <form:form action="registerUser" method="post" modelAttribute="user">
    		<form:hidden path="id"/>
            <form:hidden path="role.id"/>
            <form:hidden path="enabled"/>
        <div class="form-group">
            UserName :
             <form:input path="username" required="required" class="form-control"/>
        </div>
        <div class="form-group">
            Password :
             <form:password required="required" path="password" class="form-control" placeholder="Password"/>
        </div>
        <div class="form-group">
            Email :
             <form:input required="required" path="email" class="form-control" placeholder="Email"/>
        </div>
        <div class="form-group">
            Expense limit (in VND):
            <form:input path="expenseLimit" pattern="[0-9]+" class="form-control" placeholder="Expense Limit"/>
            (non-negative whole number)
        </div>
        <button type="submit" class="btn btn-primary" value="Save">Create</button>
        <input type="button" value="Cancel"  onclick="cancel()" class="btn btn-primary"/>
    </form:form>
</div>
</div>
</div>
      
<script>
function cancel() {
	window.location.href = "${pageContext.request.contextPath}";
}
 </script>
</div>
</body>
</html>