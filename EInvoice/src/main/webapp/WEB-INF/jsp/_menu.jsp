<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
span, a {
	color:rgba(255,255,255,1);
    text-decoration: none;

}
</style>
<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;background-color: rgba(76,76,76,1);">

  <c:if test="${!(pageContext.request.userPrincipal.name != null)}">
	<a href="${pageContext.request.contextPath}/register">Register</a>
  	| &nbsp;
  </c:if>
  <c:if test="${pageContext.request.userPrincipal.name != null}">
  	<sec:authorize access="isAuthenticated()">
		<a href="${pageContext.request.contextPath}/processUser">Home</a>
		| &nbsp;
		 <span>Hi ${pageContext.request.userPrincipal.name}</span>
		| &nbsp;
		<a href="${pageContext.request.contextPath}/user/editUser">Edit user</a>
	 </sec:authorize>
	 | &nbsp;
	<sec:authorize access="hasRole('ROLE_USER') and isAuthenticated()">
		<a href="${pageContext.request.contextPath}/type">Type</a>
	</sec:authorize>
     | &nbsp;
     <a href="${pageContext.request.contextPath}/logout">Logout</a>
  </c:if>
</div>