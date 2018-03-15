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
<link href="<c:url value="/resources/css/styleForm.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="_menu.jsp"/>
			
	<div class="form-page">
	<h1>Create/Edit Invoice</h1>
	<div class="form">
	<div class="bs-example">
 		<p style="color: red;"><c:out value = "${message}"/></p>
     <form:form action="saveInvoice" method="post" modelAttribute="invoice">
    		<form:hidden path="id"/>
            <form:hidden path="user.id"/>
        <div class="form-group">
            Type:
             <form:select path="type.id" required="required" class="form-control">
       					<c:forEach items="${typeList}" var="t">
        					<form:option value="${t.id}" label="${t.name}" />
       					</c:forEach>
				     </form:select>
        </div>
        <div class="form-group">
               Money (in VND):
               <form:input path="money" required="required" pattern="[0-9]+" class="form-control"/>
               (non-negative whole number)
        </div>
        <div class="form-group">
               VAT (in VND):
               <form:input path="vat" required="required" pattern="[0-9]+" class="form-control"/>
               (non-negative whole number)
        </div>
        <div class="form-group">
        Month:
        	          <form:select path="month.id" required="required" class="form-control">
       					<c:forEach items="${monthList}" var="m">
        					<form:option value="${m.id}" label="${m.name}" />
       					</c:forEach>
				     </form:select>
        </div>
        <div class="form-group">
                 Year:
            	<form:select path="year.id" required="required" class="form-control">
       					<c:forEach items="${yearList}" var="y">
        					<form:option value="${y.id}" label="${y.value}" />
       					</c:forEach>
				</form:select>
        </div>
        <button type="submit" class="btn btn-primary" value="Save">Save</button>
        <input type="button" value="Cancel"  onclick="cancel()" class="btn btn-primary"/>
    </form:form>
    	<br>
     	
</div>
</div>
</div>

<script>
 	function cancel() {
		window.location.href = "${pageContext.request.contextPath}/invoice";
	}
 </script>
</body>
</html>