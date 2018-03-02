<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h3>
            <a href="newUser">New User</a>
        </h3>
        <table border="1">
 
            <th>Name</th>
            <th>Password</th>
            <th>Action</th>
 
            <c:forEach var="user" items="${listUser}">
                <tr>
 
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td><a href="editUser?id=${user.id}">Edit</a>
                             <a
                        href="deleteUser?id=${user.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>