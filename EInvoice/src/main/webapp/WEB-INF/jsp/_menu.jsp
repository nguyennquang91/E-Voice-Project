<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
.aColor{
	color:rgba(255,255,255,1);

}

</style>
<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;background-color: rgba(76,76,76,1);">
  <c:if test="${!(pageContext.request.userPrincipal.name != null)}">
	<a href="${pageContext.request.contextPath}/register" class="aColor">Register</a>
  	| &nbsp;
  </c:if>
  <c:if test="${pageContext.request.userPrincipal.name != null}">
  	<sec:authorize access="isAuthenticated()">
		<a href="${pageContext.request.contextPath}/processUser" class="aColor">Home</a>
		| &nbsp;
		 <span class="aColor" >Hi ${pageContext.request.userPrincipal.name}</span>
		| &nbsp;>
		<a href="${pageContext.request.contextPath}/user/editUser" class="aColor">Edit user</a>
	 	| &nbsp;
	 </sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER') and isAuthenticated()">

		<a href="${pageContext.request.contextPath}/type" class="aColor">Type</a>
		| &nbsp;
		<a href="${pageContext.request.contextPath}/chart">Chart</a>
		| &nbsp;
		<a href="${pageContext.request.contextPath}/report">Report</a>
	 	| &nbsp;
	</sec:authorize>
     | &nbsp;
     <a href="${pageContext.request.contextPath}/logout" class="aColor">Logout</a>
  </c:if>
</div>