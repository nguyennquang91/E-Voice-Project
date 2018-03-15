<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head><title>E-Invoice login</title>
 <link href="<c:url value="/resources/css/customLogin.css" />" rel="stylesheet">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
   <jsp:include page="_menu.jsp" />
       <div class="login-Page">
       <div class="form">
       <h1>Login</h1>
     
   	<h6>Enter user name and password:</h6>  
     
   <form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
            <input type='text' name='username' value='' placeholder="username">
            <input type='password' name='password' placeholder="password"/>
       		<button name="submit" value="Submit" class="btn btn-primary">Login</button>
       <!-- /login?error=true -->
     <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
         
      
  </form>
  </div>
  </div>
 
</body>
</html>