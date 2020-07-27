<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
#currentPaging {
	color:red;
	cursor:pointer;
}
#paging {
	color:blue;
 	text-decoration:none;
 	cursor:pointer;
 }
 
.subjectA:link {color:black; text-decoration:none;}
.subjectA:active {color:black; text-decoration:none;}
.subjectA:hover{color:blue; text-decoration:underline;}
.subjectA:visited {color:black; text-decoration:none;}
</style>

<h3>☆게★시☆판★</h3> 

<input type="hidden" id="pg" value="${pg }">
<table border= "1" id="boardListTable" style="border-collapse:collapse;" frame="hside" rules="rows" align="center">
	<tr>
		<th width=40 align=center>번호</th>
		<th width=300 align=center>제목</th>
		<th width=80 align=center>작성자</th>
		<th width=80 align=center>작성일</th>
		<th width=50 align=center>조회수</th>
	</tr>

</table>
<form>
<div align=center>
	<input type="button" value="글 작 성" onclick="location.href='../board/boardWriteForm.do'">
	<input type="button" value="처음으로" onclick="location.href='../main/index.do'"> <!-- onclick="javascript:history.go(-1)='' -->
	
	<c:if test="${memId == null }">
		<input type="button" value="로그인" onclick="location.href='../member/loginForm.do'">
		<input type="button" value="회원가입" onclick="location.href='../member/writeForm.do'">
	</c:if>
</div><br>
</form>	
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/boardList.js"></script>