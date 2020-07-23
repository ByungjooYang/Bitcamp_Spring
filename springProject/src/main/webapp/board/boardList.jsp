<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>★게시판★</title>
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
</head>
<body>
<h3>☆게★시☆판★</h3>
<form name="boardList" action="/miniProject/board/boardSearch.do">
<table border= 1 style="border-collapse:collapse;" frame="hside" rules="rows" align="center">
	<tr>
		<th width=40 align=center>번호</th>
		<th width=300 align=center>제목</th>
		<th width=80 align=center>작성자</th>
		<th width=80 align=center>작성일</th>
		<th width=50 align=center>조회수</th>
	</tr>
	<c:if test="${list != null }">
		<c:forEach var="boardDTO" items="${list }">
			<tr>
				<td align="center">${boardDTO.seq }</td>
				
				<c:if test="${memId == null }">
						<td>
							<c:forEach var="i" begin="1" end="${boardDTO.lev }" step="1">
								&emsp;
							</c:forEach>
							
							<c:if test="${boardDTO.pseq != 0 }">
								<img src="../image/reply.gif">
							</c:if>
							${boardDTO.subject }
						</td>
				</c:if>
				
				<c:if test="${memId != null }">
					<td>	
						<c:forEach var="i" begin="1" end="${boardDTO.lev }" step="1">
							&emsp;
						</c:forEach>
							
						<c:if test="${boardDTO.pseq != 0 }">
							<img src="../image/reply.gif">
						</c:if>
				
						<a class="subjectA" href="/miniProject/board/boardView.do?seq=${boardDTO.seq }&pg=${pg }">${boardDTO.subject }</a>
					</td>
				</c:if>
				<td align="center">${boardDTO.name }</td>
				
				<%-- a태그에 #이 붙으면 href를 없애거나 gref="javascript:void(0)" 해도 댐 --%>
				
				<c:if test="${today == boardDTO.logtime.substring(0, 10).replaceAll('-','.')}">
					<td align="center">${boardDTO.logtime.substring(11, 19) }</td>
					<%-- <fmt:formatDate value="${boardDTO.logtime }" pattern="HH.mm.ss"/> --%>
				</c:if>
				
				<c:if test="${today != boardDTO.logtime.substring(0, 10).replaceAll('-','.')}">
					<td align="center">${boardDTO.logtime.substring(0, 10).replaceAll('-','.') }</td>
				</c:if>
				
				<td align="center">${boardDTO.hit }</td>
				
			</tr>
		</c:forEach>
	</c:if>
</table>
<div align="center">${boardPaging.pagingHTML }</div>

<div align="center">
	<select name="searchOption" id="searchOption">
		<option value="searchSubject">제목</option>
		<option value="searchName">작성자</option>
	</select>

	<input type="search" name="keyword">
	<input type="submit" value="검 색">
	<input type="hidden" name="pg" value="${pg }"/>
</div>

<div align=center>
	<input type="button" value="글 작 성" onclick="location.href='../board/boardWriteForm.do'">
	<input type="button" value="처음으로" onclick="location.href='../main/index.do'"> <!-- onclick="javascript:history.go(-1)='' -->
	
	<c:if test="${memId == null }">
		<input type="button" value="로그인" onclick="location.href='../member/loginForm.do'">
		<input type="button" value="회원가입" onclick="location.href='../member/writeForm.do'">
	</c:if>
</div><br>
</form>	
</body>
<script type="text/javascript" src="../js/board.js"></script>
<script type="text/javascript">
window.onload=function(){
	document.getElementById("searchOption").value = "${searchOption }";
}
</script>
</html>