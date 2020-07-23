<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
<%--${sessionScope.memName} --%>
${memName}님 로그인 성공!
<br><br>
</body>
<script type="text/javascript">
window.onload=function(){
	alert("로그인 성공!");
	location.href="/miniProject/main/index.do"
}
</script>
</html>