<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link href="<c:url value='/static/css/styleUserPage.css' />" rel="stylesheet"></link>
<title>Insert title here</title>
</head>
<body>
<div class="topnav">
		  <a href="userpage.html">Home</a>
		  <a href="Chart.html">Chart</a>
		  <a href="report.html">Report</a>
		  <a href="index.html" style="float: right;">Logout</a>
	</div>
	
  <!--table Invoice-->
  <section>

	 <div>
	  <h1>Manager Invoice</h1>
		  <button type="button" class="btn btn-secondary" style="margin-bottom: 0.1%;"><a href="Add.html" style="margin-bottom: 0.1%;color: aliceblue">+</a></button>
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
          <th>Id</th>
          <th>Invoice</th>
          <th>Price(VND)</th>
          <th>Date</th>
          <th>VAT %</th>
		  <th>Edit/Delete</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
        <tr>
          <td>1</td>
          <td>Electric</td>
          <td>300.000</td>
          <td>24.02.1996</td>
          <td>10%</td>
        </tr>
		   <tr>
          <td>1</td>
          <td>Water</td>
          <td>300.000</td>
          <td>24.02.1996</td>
          <td>10%</td>
        </tr>
		   <tr>
          <td>1</td>
          <td>Electric</td>
          <td>300.000</td>
          <td>24.02.1996</td>
          <td>10%</td>
			   
        </tr>
      </tbody>
    </table>
  </div>
		 
</section>
	

</body>



	
	

</html>
