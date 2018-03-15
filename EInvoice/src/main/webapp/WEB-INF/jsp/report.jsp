<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
<div align="center">
	<h3>
		Report
	</h3>
	<input type="submit" value="Pick this year" onclick="performReport()" /> 
	<select id="selectedYear">
		<c:forEach items="${yearSet}" var="y">
			<option value="${y.id}">${y.value}</option>
		</c:forEach>
	</select>
</div>
<div>
	<h3>
		By Type
	</h3>
	<ul>
		<c:forEach items="${typeToMoneyMap}" var="t">
			<li>${t.key} : ${t.value}</li>
		</c:forEach>
	</ul>
</div>
<br>
<div>
	<h3>
		By Month
	</h3>
	<ul>
		<c:forEach items="${monthToMoneyMap}" var="m">
			<li>${m.key} : ${m.value}</li>
		</c:forEach>
	</ul>
</div>
<script>
 	function performReport() {
 		var e = document.getElementById("selectedYear");
 		var yearValue = e.options[e.selectedIndex].value;
		window.location.href = "${pageContext.request.contextPath}/report/getReport?year_id="+yearValue;
	}
 </script>
</body>
</html>