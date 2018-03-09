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
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
            </select>
                <span>Year</span>
            <select>
                <option>2016</option>
                <option>2017</option>
                <option>2018</option>
                <option>2019</option>
            </select>
			<a href="" id="filter">Filter</a>
            </div>
        <table border="1">
 
            <th>ID</th>
        	<th>Type</th>
         	<th>Money</th>
		 	<th>VAT</th>
         	<th>Month</th>
         	<th>Year</th>
         	<th>Action</th>
 		
            <c:forEach var="invoice" items="${listInvoice}">
                <tr id="${invoice.invoiceMonth}">
 
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
        </table>
    </div>

</body>
<script>
// function filterText()
// {  
// 	var rex = new RegExp($('#mySelect').val());
// 	if(rex == "/all/"){clearFilter()}else{
// 		$('#'+ ${invoice.invoiceMonth} ).hide();
// 		$('.content').filter(function() {
// 		return rex.test($(this).text());
// 		}).show();
//         console.log(rex);
// 	}
	
// }
// function clearFilter()
// {
// 	$('#mySelect').val('');
// 	$('.content').show();
// }

$(document).ready(function () {
	 $("#filter").click(function () {
		 var rex = $('#mySelect :selected').text();
		 if(rex != #${invoice.invoiceMonth}){}
     });
});
</script>
</html>