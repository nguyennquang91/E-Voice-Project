<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Type Management Screen</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
</head>
<body>
<jsp:include page="_menu.jsp"/>
	<h1>Type List</h1>
    <div align="center" id="wrapper">
        <h3>
            <a href="${pageContext.request.contextPath}/type/newType" class="btn btn-info btn-lg">New Type</a>
        </h3>
        <table border="1">
        	<thead>
        		<tr>
        			<th>ID</th>
		        	<th>Type</th>
		         	<th>Action</th>
        		</tr>
        	</thead>
            <tbody>
            	<c:forEach var="type" items="${typeList}">
                <tr>
                    <td>${type.id}</td>
                    <td>${type.name}</td>
                    <td>
                    <a id="edtype" class="btn btn-info btn-lg" href="${pageContext.request.contextPath}/type/editType?type_id=${type.id}">Edit</a>
                    <a id="edtype" class="btn btn-danger btn-lg" href="${pageContext.request.contextPath}/type/deleteType?type_id=${type.id}">Delete</a>
                    </td>
                </tr>
         		</c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>