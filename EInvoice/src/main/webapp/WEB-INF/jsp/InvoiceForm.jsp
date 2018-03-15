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
			
			
	<div class="form-page">
	<h1>Register</h1>
	<div class="form">
	<div class="bs-example">
	<c:out value = "${message}"/>

     <form:form action="saveInvoice" method="post" modelAttribute="invoice">
    		<form:hidden path="id"/>
            <form:hidden path="user.id"/>
            <form:hidden path="vat"/>
        <div class="form-group">
            Type:
             <form:select path="type.id" required="required" class="form-control">
       					<c:forEach items="${typeList}" var="t">
        					<form:option value="${t.id}" label="${t.name}" />
       					</c:forEach>
				     </form:select>
        </div>
        <div class="form-group">
               Money:
               <form:input path="money" required="required" pattern="[0-9]+" class="form-control"/>
        </div>
        <div class="form-group">
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
        <div class="form-group">
            Expense limit :
            <form:input path="expenseLimit" class="form-control" placeholder="Expense Limit"/>
        </div>
       	<input type="submit" value="Save">
        <button type="submit" class="btn btn-primary" value="Save">Create</button>
    </form:form>
     	<button  onclick="cancel()" class="btn btn-primary">Cancel</button>
</div>
</div>
</div>

<!--     <div align="center"> -->
<!--         <h1>Create/Edit Invoice</h1> -->
<%--         <c:out value="${message}"/><br> --%>
<%--         <form:form action="saveInvoice" method="post" modelAttribute="invoice"> --%>
<!--         <table> -->
<%--             <form:hidden path="id"/> --%>
<%--             <form:hidden path="user.id"/> --%>
<%--             <form:hidden path="vat"/> --%>
<!--             <tr> -->
<!--                 <td>Type:</td> -->
<%--                 <td><form:select path="type.id" required="required"> --%>
<%--        					<c:forEach items="${typeList}" var="t"> --%>
<%--         					<form:option value="${t.id}" label="${t.name}" /> --%>
<%--        					</c:forEach> --%>
<%-- 				     </form:select> --%>
<!-- 				</td> -->
<!--             </tr> -->
<!--             <tr> -->
<!--                 <td>Money:</td> -->
<%--                 <td><form:input path="money" required="required" pattern="[0-9]+"/> (number only)</td> --%>
<!--             </tr> -->
<!--             <tr> -->
<!--             	<td>Month</td> -->
<%--             	<td><form:select path="month.id" required="required"> --%>
<%--        					<c:forEach items="${monthList}" var="m"> --%>
<%--         					<form:option value="${m.id}" label="${m.name}" /> --%>
<%--        					</c:forEach> --%>
<%-- 				     </form:select> --%>
<!-- 				</td> -->
<!--             </tr> -->
<!--             <tr> -->
<!--             	<td>Year</td> -->
<%--             	<td><form:select path="year.id" required="required"> --%>
<%--        					<c:forEach items="${yearList}" var="y"> --%>
<%--         					<form:option value="${y.id}" label="${y.value}" /> --%>
<%--        					</c:forEach> --%>
<%-- 				     </form:select> --%>
<!-- 				</td> -->
<!--             </tr> -->
<!--             <tr> -->
<!--                 <td colspan="2" align="center"><input type="submit" value="Save"></td> -->
<!--             </tr> -->
<!--         </table> -->
<%--         </form:form> --%>
<!--         <button onclick="cancel()">Cancel</button> -->
<!--     </div> -->
<script>
 	function cancel() {
		window.location.href = "${pageContext.request.contextPath}/invoice";
	}
 </script>
</body>
</html>