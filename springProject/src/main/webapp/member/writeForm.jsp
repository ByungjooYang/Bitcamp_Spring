<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h3 align="center">회원가입</h3>
	<form name="writeForm" method="post" action="/miniProject/member/write.do">
		<table border="5" cellspacing="0" cellpadding="5" align="center">
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="name" id="name" placeholder="이름 입력"></td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td>
				<input type="text" name="id" id="id" placeholder="아이디 입력">
				<!-- <input type="button" value="중복체크" onclick="checkId()"> -->
				<input type="hidden" name="dup" id="dup" value="unchecked">
				</td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>

			<tr>
				<td align="center">재확인</td>
				<td><input type="password" name="pwd" id="repwd"></td>
			</tr>

			<tr>
				<td align="center">성별</td>
				<td>
					<input type="radio" name="gender" value="0" checked>남성 
					<input type="radio" name="gender" value="1">여성
				</td>
			</tr>

			<tr>
				<td align="center">이메일</td>
				<td>
					<input type="text" name="email1" size=10>@
					<input type="email" name="email2" list="defaultEmails" placeholder="직접 입력" size=10> 
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
					</select>-<input type="text" name="tel2" size="5">-<input type="text" name="tel3" size="5">
				</td>
			</tr>

			<tr>
				<td align="center">주소</td>
				<td><input type="text" name="zipcode" id="zipcode" size=8 align="left" readonly> <!-- disable도 있ㄴ느데 그럼 읽어오지도 못함. -->
					<input type="button" value="우편번호검색" onclick="checkPost()"><br> 
					<input type="text" name="addr1" id="addr1" size=30 readonly><br>   
					<input type="text" name="addr2" id="addr2" size=30></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="회원가입" id="write" >&emsp; <%--onclick="checkWriteForm()" --%>
				<input type="reset" value="다시입력"></td>
			</tr>

		</table>
		<br>
		<div id="writeCheck" style="font-size:8px;color:red;font-weight:bold;"></div>
	</form>
</body>
<%--<script src="../js/member.js"> /* <- 상대경로 // "http://localhost:8080/memberServlet/js/member.js" <-  절대경로 */
</script> --%>
<script src="../js/jquery-3.5.1.min.js"></script>
<script src="../js/member.js"></script>
</html>