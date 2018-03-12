<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;">
 
  <a href="${pageContext.request.contextPath}/">Home</a>
 
  | &nbsp;
  
  <c:if test="${pageContext.request.userPrincipal.name != null}">
  	
	
  	<span>Hi ${pageContext.request.userPrincipal.name}</span>
     | &nbsp;
     <sec:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
		<a href="${pageContext.request.contextPath}/admin">Admin</a>
	 </sec:authorize>
     | &nbsp;
     <a href="${pageContext.request.contextPath}/logout" align="right">Logout</a>
    
  </c:if>
</div>