<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%System.out.println(session.getAttribute("memId")); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:choose>
	<c:when test="${checkLogin == 'fail'}">
		<jsp:include page="../member/loginFail.jsp"/>
	</c:when>
	
	<c:when test="${memId == null }">
		<jsp:include page="../member/loginForm.jsp"/>
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${checkLogin == 'ok' }">
		<jsp:include page="../member/loginOk.jsp"/>
	</c:when>
	
	<c:when test="${memId != null}">
		<img src="../image/apeach2.jpg" width="100" height="100" align="top"/><br><br>
		${memName } 님
	</c:when>
</c:choose>
