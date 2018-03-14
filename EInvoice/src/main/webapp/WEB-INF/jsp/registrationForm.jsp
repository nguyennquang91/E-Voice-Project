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
Register
 <div class="form">
<div class="bs-example">
		 <c:out value = "${message}"/>
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
             <form:input path="password" class="form-control" placeholder="Password"/>
        </div>
        <div class="form-group">
            Email :
             <form:input path="email" class="form-control" placeholder="Email"/>
        </div>
        <div class="form-group">
            Expense limit :
          
            <form:input path="expenseLimit" class="form-control" placeholder="Expense Limit"/>
        </div>
        

        <button type="submit" class="btn btn-primary" value="Save">Create</button>
    </form:form>
</div>
</div>
</div>
        <button onclick="cancel()">Cancel</button>
<script>
 	function cancel() {
		window.location.href = "${pageContext.request.contextPath}";
	}
 </script>
</div>
</body>
</html>