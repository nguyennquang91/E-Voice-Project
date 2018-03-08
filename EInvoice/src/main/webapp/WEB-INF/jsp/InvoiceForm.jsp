<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Create/Edit Invoice</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/nav.css" />" rel="stylesheet">


</head>
<style>
body{
  background: -webkit-#f2f2f2;
  background: #f2f2f2;
  font-family: 'Roboto', sans-serif;
}
.form-page{
  width: 360px;
  margin: auto;
  padding: 4% 0 0;
}
.form {
 
  align:center;
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 10px 10px 0 rgba(0, 0, 0, 0.7);
}

input, select{
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 130%;
  border: 0.5px solid grey;
  margin: 0 0 20px;
  padding: 20px;
  box-sizing: border-box;
  font-size: 14px;
  
}

.btnSave {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #024457;
  width: 120%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.btnSave:hover,.btnSave:active,.btnSave:focus {
  background-color: cadetblue;
}
</style>
<body>

	 	<!--menu drawer-->
	<div class="topnav">
		  <a href="userpage.html">Home</a>
		  <a href="Chart.html">Chart</a>
		  <a href="report.html">Report</a>
		  <a href="index.html" style="float: right;">Logout</a>
	</div>


<div class="form-page">
  <div class="form">
    	

        <form:form action="saveInvoice" method="post" modelAttribute="invoice" >
        <table>
       		 <tr>
            	
          <td colspan="2" ><h2>Create<h2></h2></td> 
            </tr>
            <form:hidden path="invoiceId"/>
            <form:hidden path="invoiceVat"/>
            <form:hidden path="userId"/>
            <tr>
              
                <td><form:input path="invoiceType"  placeholder="Invoice"/></td>
            </tr>
            <tr>
                
                <td><form:input path="invoiceMoney" placeholder="Money(VND)"/></td>
            </tr>
            <tr>
           
            	<td><form:select path="invoiceMonth">
					  <form:options items="${monthList}"/>
				     </form:select>
				</td>
            </tr>
            <tr>
            
            	<td><form:input path="invoiceYear"  placeholder="Year" /></td>
            </tr>
            <tr>
            	
          <td><input type="submit" value="Save" class="btnSave"></td> 

         
            </tr>
          <tr>
          <td><input type="submit" value="Cancel" class="btnSave"></td> 
         
            </tr>
            
        </table>
        </form:form>
        
    </div>
    </div> 
</body>
</html>