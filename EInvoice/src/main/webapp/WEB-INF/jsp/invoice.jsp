<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<c:url value="/resources/css/userStyle.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Invoice Management Screen</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
<section>
		<div align="center">		
	        <h1>Invoice List</h1>
	        <h3>
	            <a href="${pageContext.request.contextPath}/invoice/newInvoice">New Invoice</a>
	        </h3>
	        <label>Search: </label>
	        <input type="text" id="search" name="search"><br><br>	
        </div>
         <div class="tbl-header">
		    <table cellpadding="0" cellspacing="0" border="0">
		      <thead>
		        <tr>
		          	<th>ID</th>
		        	<th>Type</th>
		         	<th>Money</th>
				 	<th>VAT</th>
		         	<th>Year/Month</th>
		         	<th>Action</th>
		        </tr>
		      </thead>
		    </table>
  </div>
  <div class="tbl-content">
  		  <table>
 			<tbody id="dataList">
            	<c:forEach var="invoice" items="${invoiceList}">
	                <tr>
	                    <td>${invoice.id}</td>
	                    <td>${invoice.type.name}</td>
	                    <td>${invoice.money}</td>
	                    <td>${invoice.vat}</td>
	                    <td>${invoice.month.name}<span>/</span>${invoice.year.value}</td>
	                    <td><button  class="btn-info" ><a href="${pageContext.request.contextPath}/invoice/editInvoice?invoice_id=${invoice.id}">Edit</a></button>
                    		<button  class="btn-danger"><a href="${pageContext.request.contextPath}/invoice/deleteInvoice?invoice_id=${invoice.id}">Delete</a></button>
	                </tr>
         		</c:forEach>
         	</tbody>
        </table>
  </div>

    </section>
<script>
$(document).ready(function(){
    $('#search').keyup(function(){  
       search_table($(this).val());  
  });  
  function search_table(value){  
       $('#dataList tr').each(function(){  
            var found = 'false';  
            $(this).each(function(){  
                 if($(this).text().toLowerCase().indexOf(value.toLowerCase()) >= 0)  
                 {  
                      found = 'true';  
                 }  
            });  
            if(found == 'true')  
            {  
                 $(this).show();  
            }  
            else  
            {  
                 $(this).hide();  
            }  
       });  
  }  
});
</script>
</body>
</html>