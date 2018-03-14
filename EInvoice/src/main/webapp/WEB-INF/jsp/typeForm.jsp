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
</head>
<body>
<jsp:include page="_menu.jsp"/>
    <div align="center">
        <h1>Create/Edit Type</h1>
        <c:out value = "${message}"/><br>
        <form:form action="saveType" method="post" modelAttribute="type">
        <table>
            <form:hidden path="id"/>
            <form:hidden path="user.id"/>
            <tr>
                <td>Type:</td>
                <td><form:input path="name" required="required"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
        <button onclick="cancel()">Cancel</button>
    </div>
<script>
 	function cancel() {
		window.location.href = "${pageContext.request.contextPath}/type";
	}
 </script>
</body>
</html>