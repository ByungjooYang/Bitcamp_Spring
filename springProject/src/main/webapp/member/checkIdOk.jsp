<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복ㄴㄴ</title>
</head>
<body>
${id }는 사용 가능합니다.
<br><br>
<input type="button" value="사용하기" onclick="checkIdClose('${id}')">
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>