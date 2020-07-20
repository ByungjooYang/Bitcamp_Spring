<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WriteForm</title>
<style type="text/css">
td{
	text-align:center;
}
</style>
<script defer type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script defer type="text/javascript" src="../js/user.js"></script>
</head>
<body>
<form id="writeForm">
<table border="1" cellspacing="0" cellpadding="2">
<tr>
	<td width="70">이름</td>
	<td>
	<input type="text" id="name" name="name">
	<div id="nameDiv"></div>
	</td>
<tr>

<tr>
	<td>아이디</td>
	<td>
	<input type="text" id="id" name="id">
	<div id="idDiv"></div>
	</td>
<tr>

<tr>
	<td>비밀번호</td>
	<td>
	<input type="password" id="pwd" name="pwd">
	<div id="pwdDiv"></div>
	</td>
<tr>

<tr>
	<td colspan="2">
	<input type="button" value="회원가입" id="writeBtn">
	<input type="reset" value="다시입력">
	</td>
</tr>
</table>
</form>
</body>
</html>