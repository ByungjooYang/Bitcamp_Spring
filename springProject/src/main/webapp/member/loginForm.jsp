<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h3 align="center">로그인</h3>
<form id="loginForm"> <!-- ajax에서 post라고 쓰니까 필요 없다. -->
<table border = "1" align="center" style="border-collapse: collapse;">
	<tr>
		<td>아이디</td>
		<td><input type="text" name = "id" id="loginId"></td>
	</tr>
	
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pwd" id="loginPwd"  ></td> <%--onkeydown="onEnterSubmit()" --%>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		<input type="button" value="로 그 인" id="login" >&emsp; <%-- onclick="checkLoginForm()"--%>
		<input type="button" value="회원 가입" onclick="location.href='/springProject/member/writeForm'">
		</td>
	</tr>

</table>
<br>
<div id="check" style="font-size:8px;color:red;font-weight:bold;"></div>
<br>
</form>
</body>
<script src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
</html>