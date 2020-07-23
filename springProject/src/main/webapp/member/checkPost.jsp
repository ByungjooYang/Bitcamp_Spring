<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 찾기</title>
</head>
<body>
<body>
<form method=post action="">
	<table border="1" width="100%" cellspacing="0" cellpadding="3">
		<tr>
			<th>시도</th>
			<td>
			<select name="sido" style="width:100px;">
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
			</td>
			<th>시.군.구</th>
			<td><input type="text" name="sigungu" size="30"></td>
			
		</tr>
		
		<tr>
			<th>도로명</th>
			<td colspan="3">
			<input type="text" name="roadname" size="35">
			<input type="submit" value="검색">
			</td>
		</tr>
		
		<tr>
			<th>우편번호</th>
			<th colspan="3" align="center" >주소</th>
		</tr>
		<c:if test="${list != null }">
		<c:forEach var="zipcodeDTO" items="${list}">
		<c:set var="address">
			${zipcodeDTO.sido } ${zipcodeDTO.sigungu } ${zipcodeDTO.yubmyundong } ${zipcodeDTO.ri } ${zipcodeDTO.roadName } ${zipcodeDTO.buildingname }
		</c:set>	
			<tr>
				<td align = center>${zipcodeDTO.zipcode }</td>
				<td colspan = 3>
				<a id = "addressA" href="#" onclick="checkPostClose('${zipcodeDTO.zipcode }', '${address }')">${address }</a>
				</td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>