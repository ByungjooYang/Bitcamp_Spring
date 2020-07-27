<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="../image/favicon.ico" type="image/x-icon">
<title>메인화면</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="5" width="50%" height="80%" align="center">
<tr>
	<td colspan=2><jsp:include page="../template/top.jsp"/></td>
</tr>

<tr>
	<td align="center" style="padding: 0px" width="280"><jsp:include page="../template/left.jsp"/>
	<td align="center"><jsp:include page="${display }"/></td>
</tr>
<%--/main/index.jsp 를하면 display를 못찾기 때문에 서버에러가 떨어진다. 따라서 무조건 index.do로 해야한당! --%>
<tr>
	<td colspan="2"><jsp:include page="../template/bottom.jsp"/></td>
</tr>

</table>
</body>
</html>