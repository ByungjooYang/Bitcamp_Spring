<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<h3 align="center">
<a href="/miniProject/main/index.do"><img src="../image/apeach1.jpg" width="40" height="40"/></a>
MVC기반의 미니 프로젝트
<img src="../image/apeach1.jpg" width="40" height="40" onclick="location.href='/miniProject/main/index.do'"/>
</h3>
<div align="center">
<a href="../board/boardList.do?pg=1">목록</a>&emsp;
<a href="/miniProject/board/imageboardList.do?pg=1">이미지 보기</a>&emsp;

<c:if test="${sessionScope.memId == null}">
	<a href="/springProject/member/writeForm">회원가입</a>&emsp;
	<a href="/springProject/member/login">로그인</a>&emsp;
</c:if>

<c:if test="${memId != null}">
	<a href="/springProject/member/logout">글쓰기</a>&emsp;
	
	<c:if test="${memId == 'admin' }">
		<a href="/springProject/member/logout">이미지 등록</a>&emsp;
	</c:if>
	
	<a href="/springProject/member/logout">회원정보수정</a>&emsp;
	<a href="/springProject/member/logout">로그아웃</a>&emsp;
</c:if>
</div>