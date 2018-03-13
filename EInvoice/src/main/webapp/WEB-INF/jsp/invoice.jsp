<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="<c:url value="/resources/css/userStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/nav.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	 	<!--menu drawer-->
	<div class="topnav">
		  <a href="userpage.html">Home</a>
		  <a href="/EInvoice/chart">Chart</a>
		  <a href="report.html">Report</a>
		  <a href="index.html" style="float: right;">Logout</a>
	</div>
  <!--table Invoice-->
  <section>

	 <div>
	  <h1>Manager Invoice</h1>
		  <button type="button" class="btn btn-secondary" style="margin-bottom: 0.1%;" ><a
		   href="newInvoice" style="margin-bottom: 0.1%;color: aliceblue;">+</a></button>
		 		<select style="float: right">
					<option>2019</option>
					<option>2018</option>
					<option>2017</option>
				</select>
		 		<select style="float: right" >
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
				</select>
	  </div>
  
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>ID</th>
        	<th>Type</th>
         	<th>Money</th>
		 	<th>VAT</th>
         	<th>Month</th>
         	<th>Year</th>
         	<th>Action</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0" action="sum">
      <tbody>
        <c:forEach var="invoice" items="${listInvoice}">
                <tr>
 
                    <td>${invoice.invoiceId}</td>
                    <td>${invoice.invoiceType}</td>
                    <td>${invoice.invoiceMoney}</td>
                    <td>${invoice.invoiceVat}</td>
                    <td>${invoice.invoiceMonth}</td>
                    <td>${invoice.invoiceYear}</td>
                    <td >
<%--                     <a href="editInvoice?invoice_id=${invoice.invoiceId}">Edit</a> --%>
<%--                     <a href="deleteInvoice?invoice_id=${invoice.invoiceId}">Delete</a> --%>
							<button  class="btn btn-info" ><a href="editInvoice?invoice_id=${invoice.invoiceId}">Edit</a></button>
                    		<button  class="btn-danger"><a href="deleteInvoice?invoice_id=${invoice.invoiceId}">Delete</a></button>
                    </td>
 
                </tr>
         </c:forEach>
	
      </tbody>
    </table>
  </div>
</section>
</body>
</html>