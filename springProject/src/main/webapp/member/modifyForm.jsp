<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<h3 align=center>회원 정보 수정</h3>
	<form name="modifyForm" id="modifyForm" method="post">
		<table border="5" cellspacing="0" cellpadding="5" align="center">
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="name" id="name" value = "${memberDTO.name }"></td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td>
				<input type="text" name="id" id="id" value = "${memberDTO.id }" readonly>
				</td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>

			<tr>
				<td align="center">재확인</td>
				<td><input type="password" name="repwd" id="repwd"></td>
			</tr>

			<tr>
				<td align="center">성별</td>
				<td>
					<input type="radio" name="gender" value="0">남성 
					<input type="radio" name="gender" value="1">여성
				</td>
			</tr>

			<tr>
				<td align="center">이메일</td>
				<td>
					<input type="text" name="email1" id="email1" size=10 value = "${memberDTO.email1 }">@<input type="text" name="email2" id ="email2" list="defaultEmails" placeholder="직접 입력" size=10> 
						<datalist id="defaultEmails">
							<option value="naver.com">
							<option value="gmail.com">
						</datalist>
				</td>
			</tr>

			<tr>
				<td align="center">핸드폰</td>
				<td>
					<select name="tel1">
							<option value="010" selected>010</option>
							<option value="011">011</option>
							<option value="019">019</option>
					</select>-<input type="text" name="tel2" size="5" value = "${memberDTO.tel2 }">-<input type="text" name="tel3" size="5" value = "${memberDTO.tel3 }">
				</td>
			</tr>

			<tr>
				<td align="center">주소</td>
				<td><input type="text" name="zipcode" id="zipcode" size="8" align="left" value = "${memberDTO.zipcode }" readonly> <!-- disable도 있ㄴ느데 그럼 읽어오지도 못함. -->
					<input type="button" value="우편번호검색" onclick="checkPost()" ><br> 
					<input type="text" name="addr1" id="addr1" size=30 value = "${memberDTO.addr1 }" readonly><br>   
					<input type="text" name="addr2" id="addr2" size=30 value = "${memberDTO.addr2 }"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="회원정보수정" id="modifyBtn">&emsp; 
				<input type="reset" value="다시입력"></td>
			</tr>

		</table>
		<div id="checkDiv" style="color:red;font-size:8pt;fint-weight:bold;"></div>
	</form>
</body>
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
<script>
window.onload=function(){
	document.modifyForm.gender['${memberDTO.gender}'].checked = true;
	document.modifyForm.email2.value='${memberDTO.email2}';
	//document.getElementById("email2").value = ---
	document.modifyForm.tel1.value='${memberDTO.tel1}';
}
</script>
</html>