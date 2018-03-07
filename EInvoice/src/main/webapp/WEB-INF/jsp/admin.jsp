<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Screen</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <div align="center">
        <h1>User List</h1>
        
        <h3>
            <button id="saveBtn">Save changes</button>
            <script>
$(document).ready(function() {
	$("#saveBtn").on('click', function(){
		for(var i=0, n=document.forms.length; i<n; i++){
            var formId = document.forms[i].id;
            $('#' + formId).trigger('submit');
        }
	});
});
</script>
        </h3>
        <table border="1">
 
            <th>User ID</th>
        	<th>Display name</th>
         	<th>Password</th>
		 	<th>State</th>
		 	<th>Action</th>
 
            
            	<c:forEach items="${userList}" var="user">
            	<tr>
            	<form:form modelAttribute="user_${user.userId}" method="POST" id="form_${user.userId}" action="admin/saveUser">
            		<td><form:hidden path="userId"/>${user.userId}</td>
            		<td><form:hidden path="userDisplayName"/>${user.userDisplayName}</td>
            		<td><form:hidden path="userPassword"/>${user.userPassword}</td>
            		<td>
	            		<form:select path="userState">
							<form:options items="${stateMap}"/>
					    </form:select>
				    </td>
				    <td><input type="submit" value="Save"></td>
				    </form:form>
				</tr>
            	</c:forEach>
        </table>
    </div>
</body>
</html>