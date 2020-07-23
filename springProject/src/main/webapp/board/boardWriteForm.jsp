<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기ㅎㅎ</title>
</head>
<body>
<h3 align="center">글!쓰기</h3>
<form name="boardWriteForm" action="boardWrite.do">
<table border=1 align="center">
<tr>
	<td width=50 align="center">제목</td>
	<td><input type=text placeholder="제목을 입력해주세요" name=subject  id="subject "></td>
</tr>

<tr>
	<td align="center">내용</td>
	<td><textarea name=content  id="content" cols="40" rows="20" style="resize:none" placeholder="내용을 입력해주세요"></textarea></td>
</tr>

<tr>
	<td colspan=2 align=center>
	<input type="button" value="글 쓰기" onclick="checkBoardWrite()">
	<input type="reset" value="다시쓰기">
	<input type="button" value="메뉴화면" onclick="location.href='../main/index.do'">
	</td>
</tr>
</table>
</form>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>