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

<div id="boardPagingDiv" style="width:650px; text-align: center;"></div>

<form>
<div style="width: 650px; text-align: center;">
	<select name="searchOption" id="searchOption" style="width: 100px;">
 		<option value="subject">제목</option>
 		<option value="id">작성자</option>
	</select>
 	<input type="search" name="keyword" id="keyword" value="${requestScope.keyword }">
	<input type="button" id="boardSearchBtn" value="검색">
</div>
</form>
<div align="center">
	<input type="button" value="글 작 성" onclick="location.href='../board/boardWriteForm.do'">
	<input type="button" value="처음으로" onclick="location.href='../main/index.do'"> <!-- onclick="javascript:history.go(-1)='' -->
	
	<c:if test="${memId == null }">
		<input type="button" value="로그인" onclick="location.href='../member/loginForm.do'">
		<input type="button" value="회원가입" onclick="location.href='../member/writeForm.do'">
	</c:if>
</div><br>

<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/boardList.js?var=1"></script>
<script type="text/javascript">
window.onload=function(){
	if("${searchOption }"=="subject" || "${searchOption }"=="id"){
		document.getElementById("searchOption").value = "${searchOption }";
	}
}

function checkLoginMem(seq, pg){
   if('${memId}'=='') {
	   alert("로그인을 먼저 하세요");
	   location.href="../main/index.do";
   
   }else 
	   location.href="boardView.do?seq="+seq+"&pg="+pg;
}

function boardPaging(pg){
	var keyword = document.getElementById("keyword").value;
	if(keyword == ""){
		location.href="boardList?pg="+pg;
	}else{
		/*
		encodeURI는 특수문자는 인코딩이 안되고 
		encodeURIComponent는 모든 문자가 다되는듯 이왕이면 encodeURIComponent쓰자!
		*/
		location.href="boardSearch?pg="+pg
			+"&searchOption=${searchOption}&keyword="+encodeURIComponent("${keyword}");
	}
	
}
</script>
