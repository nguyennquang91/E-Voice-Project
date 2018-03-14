<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Type Management Screen</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
    <div align="center">
        <h1>Type List</h1>
        <h3>
            <a href="${pageContext.request.contextPath}/type/newType">New Invoice</a>
        </h3>
        <table border="1">
 
            <th>ID</th>
        	<th>Type</th>
         	<th>Action</th>
 
            <c:forEach var="type" items="${typeList}">
                <tr>
                    <td>${type.id}</td>
                    <td>${type.name}</td>
                    <td><a href="${pageContext.request.contextPath}/type/edittype?type_id=${type.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/type/deletetype?type_id=${type.id}">Delete</a></td>
                </tr>
         </c:forEach>
        </table>
    </div>
</body>
</html>