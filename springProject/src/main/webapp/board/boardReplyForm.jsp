<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>!답!글!</title>
</head>
<body>
<form name="boardReplyForm" method="post" action="/miniProject/board/boardReply.do">
<h3>답☆글★쓰☆기</h3>
<input type="hidden" name="pseq" value="${pseq }">
<input type="hidden" name="pg" value="${pg }">
<table border=1 align="center">
<tr>
	<td width=50 align="center">제목</td>
	<td><input type=text placeholder="제목을 입력해주세요" name="subject"  id="subject"></td>
</tr>

<tr>
	<td align="center">내용</td>
	<td><textarea name="content"  id="content" cols="40" rows="20" style="resize:none" placeholder="내용을 입력해주세요"></textarea></td>
</tr>

<tr>
	<td colspan=2 align=center>
	<input type="button" value="답글쓰기" onclick="checkBoardReplyForm()">
	<input type="reset" value="다시쓰기">
	<input type="button" value="메뉴화면" onclick="location.href='../main/index.do'">
	</td>
</tr>
</table>
</form>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>