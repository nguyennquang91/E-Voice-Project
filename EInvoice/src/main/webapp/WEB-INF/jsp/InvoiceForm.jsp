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
<title>Create/Edit Invoice</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
    <div align="center">
        <h1>Create/Edit Invoice</h1>
        <form:form action="saveInvoice" method="post" modelAttribute="invoice">
        <table>
            <form:hidden path="id"/>
            <form:input path="user.id" readonly="true"/>
            <form:hidden path="vat"/>
            <tr>
                <td>Type:</td>
                <td><form:select path="type.id">
       					<c:forEach items="${typeList}" var="t">
        					<form:option value="${t.id}" label="${t.name}" />
       					</c:forEach>
				     </form:select>
				</td>
            </tr>
            <tr>
                <td>Money:</td>
                <td><form:input path="money" required="required"/></td>
            </tr>
            <tr>
            	<td>Month</td>
            	<td><form:select path="month.id">
       					<c:forEach items="${monthList}" var="m">
        					<form:option value="${m.id}" label="${m.name}" />
       					</c:forEach>
				     </form:select>
				</td>
            </tr>
            <tr>
            	<td>Year</td>
            	<td><form:select path="year.id">
       					<c:forEach items="${yearList}" var="y">
        					<form:option value="${y.id}" label="${y.value}" />
       					</c:forEach>
				     </form:select>
				</td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>