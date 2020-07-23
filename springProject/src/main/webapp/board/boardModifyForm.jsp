<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
<form name="boardModifyForm" method="post"  action="/miniProject/board/boardModify.do?seq=${boardDTO.seq }"> <!-- 액션은 주소 뒤에 ? 붙여서 값을 넘길수 없다.어떨땐 되는데 어떨땐 안되는 것이에여! -->
<input type=hidden name="seq" value="${seq }">
<input type=hidden name="pg" value="${pg }">
<table border= 1 style="border-collapse:collapse;">
<tr>
	<td width=50 align="center">제목</td>
	<td><input type=text name=subject id="subject" value="${boardDTO.subject }"></td>
</tr>

<tr>
	<td align="center">내용</td>
	<td><textarea name=content  id="content" cols="40" rows="20" style="resize:none">${boardDTO.content }</textarea></td>
</tr>

<tr>
	<td colspan=2 align=center>
	<input type="button" value="글 수정" onclick="checkModify()">
	<input type="reset" value="다시쓰기">
	</td>
</tr>
</table>
</form>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>