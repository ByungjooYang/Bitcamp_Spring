<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복ㅎㅎ</title>
</head>
<body>
<form method="post" action="checkId.do?id=${id }">
${requestScope.id }는 사용 불가능
<%-- loginService에서 setAttribute 안해주면  param.id 로 하면 나온다. --%>
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id"></td>
		<td><input type="submit" value = "검색"></td>
	</tr>
</table>
</form>
</body>
</html>