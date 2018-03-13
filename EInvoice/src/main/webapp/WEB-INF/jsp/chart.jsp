<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
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
				type: "bar",
				yValueFormatString: "##,### vnd",
				indexLabel: "{y}",
				dataPoints: dps[0]
			}]
		});
    
    var xValue;
    var yValue;
     
    <c:forEach items="${chartData.invoiceListWrapperList}" var="dataPoints" varStatus="loop">	
    	<c:forEach items="${dataPoints.invoiceList}" var="dataPoint">
    		xValue = parseInt("${dataPoint.invoiceMonth}");
    		yValue = parseInt("${dataPoint.invoiceMoney}");
    		dps[parseInt("${loop.index}")].push({
    			x : xValue,
    			y : yValue,
    		});		
    	</c:forEach>	
    </c:forEach> 
    
chart.render();
 }
 </script>
</head>
<body>
	

	<div id="chartContainer" style="height: 370px; width: 100%;"></div>

	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>