<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create/Edit Type</title>
<link href="<c:url value="/resources/css/styleForm.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="_menu.jsp"/>
    <div class="form-page">
        <h1>Create/Edit Type</h1>
        <div class="form">
		<div class="bs-example">
 		<p style="color: red;"><c:out value = "${message}"/></p>
        		<form:form action="saveType" method="post" modelAttribute="type">
       
            <form:hidden path="id"/>
            <form:hidden path="user.id"/>
            	<div class="form-group">
            		Type:
            	 <form:input path="name" required="required" class="form-control"/>
          
            </div>
            <div class="form-group">

                <button type="submit" class="btn btn-primary" value="Save">Save</button>
           <input type="button" value="Cancel"  onclick="cancel()" class="btn btn-primary"/>
           </div>
        		</form:form>

   </div>
</div>
</div>
<script>
function cancel() {
	window.location.href = "${pageContext.request.contextPath}/type";
}
 </script>
</body>
</html>