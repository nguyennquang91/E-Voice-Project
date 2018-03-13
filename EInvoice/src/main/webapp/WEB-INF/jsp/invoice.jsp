<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invoice Management Screen</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
    <div align="center">
        <h1>Invoice List</h1>
        <h2>
        	<a>Welcome </a>
        </h2>
        <h3>
            <a href="${pageContext.request.contextPath}/invoice/newInvoice">New Invoice</a>
        </h3>
        <table border="1">
 
            <th>ID</th>
        	<th>Type</th>
         	<th>Money</th>
		 	<th>VAT</th>
         	<th>Month</th>
         	<th>Year</th>
         	<th>Action</th>
 
            <c:forEach var="invoice" items="${listInvoice}">
                <tr>
                    <td>${invoice.id}</td>
                    <td>${invoice.type.name}</td>
                    <td>${invoice.money}</td>
                    <td>${invoice.vat}</td>
                    <td>${invoice.month.name}</td>
                    <td>${invoice.year.value}</td>
                    <td><a href="${pageContext.request.contextPath}/invoice/editInvoice?invoice_id=${invoice.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/invoice/deleteInvoice?invoice_id=${invoice.id}">Delete</a></td>
                </tr>
         </c:forEach>
        </table>
    </div>
</body>
</html>