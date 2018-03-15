<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chart</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
 window.onload = function () {
	 var dps = [[]];
   
	 var chart = new CanvasJS.Chart("chartContainer", {
			theme: "light2", 
			animationEnabled: true,
			axisX: {
				title: "Month",
				
			},
			axisY: {
				title: "Money",
				suffix: "vnd"
			},
			data: [{
				type: "column",
				dataPoints: dps[0]
			}]
		});
    
    var xValue;
    var yValue;
    
   	<c:forEach items="${monthToMoneyMap}" var="m">
   		xValue = parseInt("${m.key}");
   		yValue = parseInt("${m.value}");
   		dps[0].push({
   			x : xValue,
   			y : yValue,
   		});		
   	</c:forEach>	
    
chart.render();
}
 </script>
</head>
<body>
<jsp:include page="_menu.jsp"/>
<div align="center">
	<h3>
		Chart
	</h3>
	<input type="submit" value="Pick this year" onclick="getChart()" /> 
	<select id="selectedYear">
		<c:forEach items="${yearSet}" var="y">
			<option value="${y.id}">${y.value}</option>
		</c:forEach>
	</select>
</div>
<script>
	function getChart() {
		var e = document.getElementById("selectedYear");
		var yearValue = e.options[e.selectedIndex].value;
		window.location.href = "${pageContext.request.contextPath}/chart/getChart?year_id="+yearValue;
	}
 </script>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>