<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create/Edit Invoice</title>
<link href="<c:url value="/resources/css/AddStyle.css" />" rel="stylesheet">

</head>
<style>

</style>
<body>
    <div align="center" class="page-form">
        <h1>Create/Edit Invoice</h1>
        <form:form action="saveInvoice" method="post" modelAttribute="invoice" class="form">
        <table>
            <form:hidden path="invoiceId"/>
            <form:hidden path="invoiceVat"/>
            <form:hidden path="userId"/>
            <tr>
                <td>Type:</td>
                <td><form:input path="invoiceType" /></td>
            </tr>
            <tr>
                <td>Money:</td>
                <td><form:input path="invoiceMoney" /></td>
            </tr>
            <tr>
            	<td>Month</td>
            	<td><form:select path="invoiceMonth">
					  <form:options items="${monthList}"/>
				     </form:select>
				</td>
            </tr>
            <tr>
            	<td>Year</td>
            	<td><form:input path="invoiceYear" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>