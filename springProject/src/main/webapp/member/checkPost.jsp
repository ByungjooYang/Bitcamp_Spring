<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
th {
	font-size:8pt;
	background-color: #cccccc
}  
td {
	font-size:8pt
}
#addressA:link{color: black; text-decoration: none;}
#addressA:visited{color: black; text-decoration: none;}
#addressA:hover{color: green; text-decoration: none; font-weight: bold;}
#addressA:active{color: black; text-decoration: none;}  
</style>
<form id="checkPostForm">
<table border="1" width="100%" cellspacing="0" cellpadding="3" id="postTable">
	<tr>
		<th>시도</th>
		<td>
		<select name="sido" id="sido" style="width:100px;">
			<option value="">시도선택</option>
			<option value="서울">서울</option>
			<option value="인천">인천</option>
			<option value="대전">대전</option>
			<option value="대구">대구</option>
			<option value="울산">울산</option>
			<option value="세종">세종</option>
			<option value="광주">광주</option>
			<option value="경기">경기</option>
			<option value="강운">강원</option>
			<option value="전남">전남</option>
			<option value="전북">전북</option>
			<option value="경남">경남</option>
			<option value="경북">경북</option>
			<option value="충남">충남</option>
			<option value="충북">충북</option>
			<option value="부산">부산</option>
			<option value="제주">제주</option>
		</select>
		<div id="sidoDiv"></div>
		</td>
		<th>시.군.구</th>
		<td>
		<input type="text" name="sigungu" id="sigungu" size="30">
		<div id="sigunguDiv"></div>
		</td>
		
	</tr>
	
	<tr>
		<th>도로명</th>
		<td colspan="3">
		<input type="text" name="roadname" id="roadname" size="35">
		<input type="button" value="검색" id="postSearchBtn">
		<div id="roadnameDiv"></div>
		</td>
	</tr>
	
	<tr>
		<th>우편번호</th>
		<th colspan="3" align="center" >주소</th>
	</tr>
</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
