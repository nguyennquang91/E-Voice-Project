<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>Invoice Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Invoice List</h1>
        <h3>
            <a href="newInvoice">New Invoice</a>
        </h3>
        <div style="float:right">
            <span>Month</span>
            <select id='mySelect'>
            	<option>all</option>
                <option>January</option>
                <option>February</option>
                <option>March</option>
                <option>April</option>
                <option>May</option>
                <option>June</option>
                <option>July</option>
                <option>August</option>
                <option>September</option>
                <option>October</option>
                <option>November</option>
                <option>December</option>
            </select>
            <button id="btn">Search</button>
                <span>Year</span>
            <select>
                <option>2016</option>
                <option>2017</option>
                <option>2018</option>
                <option>2019</option>
            </select>
			
            </div>
        <table border="1" >
 			
                <tr>
                    <th>ID</th>
		        	<th>Type</th>
		         	<th>Money</th>
				 	<th>VAT</th>
		         	<th>Month</th>
		         	<th>Year</th>
		         	<th>Action</th>
                </tr>
           
            
 			<tbody id="myTable">
            	<c:forEach var="invoice" items="${listInvoice}">
                <tr>
 
                    <td>${invoice.invoiceId}</td>
                    <td>${invoice.invoiceType}</td>
                    <td>${invoice.invoiceMoney}</td>
                    <td>${invoice.invoiceVat}</td>
                    <td>${invoice.invoiceMonth}</td>
                    <td>${invoice.invoiceYear}</td>
                    <td><a href="editInvoice?invoice_id=${invoice.invoiceId}">Edit</a>
                             <a
                        href="deleteInvoice?invoice_id=${invoice.invoiceId}">Delete</a></td>
 
                </tr>
         	</c:forEach>
        </tbody>
        </table>
    </div>
<script>
$(document).ready(function(){
	$("#btn").click(function(){
		var value = $("#mySelect").val();
        $("#myTable tr").filter(function() {
      	$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    	});
    });
});
</script>
</body>

</html>