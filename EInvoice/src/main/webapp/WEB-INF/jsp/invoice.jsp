<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<c:url value="/resources/css/userStyle.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Invoice Management Screen</title>
</head>
<body>
<jsp:include page="_menu.jsp"/>
<section>
		<div align="center" class="form-group">		
	        <h1>Invoice List</h1>
	        <a id="addInvoice" href="${pageContext.request.contextPath}/invoice/newInvoice" class="btn btn-info btn-lg">
	          New Invoice
	        </a>
	        
	        <input type="text" id="search" class="form-control" name="search" placeholder="Search..."><br><br>	
        </div>
         <div class="tbl-header">
		    <table cellpadding="0" cellspacing="0" border="0">
		      <thead>
		        <tr>
		          	<th>ID</th>
		        	<th>Type</th>
		         	<th>Money (in VND)</th>
				 	<th>VAT (in VND)</th>
		         	<th>Charged period</th>
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
	                    <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${invoice.money}" /></td>
	                    <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${invoice.vat}" /></td>
	                    <td>${invoice.month.name}<span>/</span>${invoice.year.value}</td>
	                    <td>
	                    <a id="edInvoice" href="${pageContext.request.contextPath}/invoice/editInvoice?invoice_id=${invoice.id}" class="btn btn-info btn-lg">
				          Edit 
				        </a>
				        <a id="edInvoice" href="${pageContext.request.contextPath}/invoice/deleteInvoice?invoice_id=${invoice.id}" class="btn btn-danger btn-lg">
				           Delete 
				        </a>
	                    
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