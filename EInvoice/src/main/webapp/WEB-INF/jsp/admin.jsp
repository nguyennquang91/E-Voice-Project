<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>User List</h1>
        <form:form action="saveAllUser" method="post" modelAttribute="userList">
        <h3>
            <input type="submit" value = "Save changes"> 
        </h3>
        <table border="1">
 
            <th>User ID</th>
        	<th>Display name</th>
         	<th>Password</th>
		 	<th>State</th>
 
            
            	<c:forEach items="${userList}" var="user" varStatus="uStatus">
            		<tr>${user.userId}</tr>
            		<tr>${user.userDisplayName}</tr>
            		<tr>${user.userPassword}</tr>
            		<tr>
	            		<form:select path="userList[${uStatus.index}].userState">
							<form:options items="${stateMap}"/>
					    </form:select>
				    </tr>
            	</c:forEach>
        </table>
        </form:form>
    </div>
</body>
</html>