<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
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
        
        <form:form modelAttribute="userListWrapper" method="POST" action="adminMain/saveAllUser">
        <input type="submit" value="Save">
        <table border="1">
 
            <th>User ID</th>
        	<th>Display name</th>
         	<th>Password</th>
		 	<th>State</th>
            	<c:forEach items="${userListWrapper.userList}" varStatus="uStatus" var="user">
            	<tr>
            	
            		<td><form:hidden path="userList[${uStatus.index}].userId"/>${user.userId}</td>
            		<td><form:hidden path="userList[${uStatus.index}].username"/>${user.username}</td>
            		<td><form:hidden path="userList[${uStatus.index}].password"/>${user.password}</td>
            		<td>
	            		<form:select path="userList[${uStatus.index}].enabled">
							<form:options items="${stateMap}"/>
					    </form:select>
				    </td>
				</tr>
            	</c:forEach>
        </table>
        </form:form>
    </div>
</body>
</html>