<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
<table border=3 cellspacing="0" cellpadding="3" style="border-collapse:collapse" align=center frame="hsides" rules="rows">
<tr>
	<td width=100 align="center">제목</td>
	<td colspan="2">&nbsp;${boardDTO.subject }</td>
</tr>

<tr>
	<td>&nbsp;글 번호 : ${boardDTO.seq }</td>
	<td width=150>&nbsp;작성자 : ${boardDTO.name }</td>
	<td width=100> &nbsp;조회수 : ${boardDTO.hit +1}</td>
</tr>

<tr>
	<td colspan="3" height=200 width="300" valign=top style="overflow: auto; white-space:pre-wrap;">${boardDTO.content }</td>
</tr>

</table>
<br>

<div align= center>
<input type="button" value="목      록" onclick="location.href='/miniProject/board/boardList.do?pg=${pg }'">
<input type="button" value="메인화면" onclick="location.href='/main/index.do'">
<c:if test="${memId == boardDTO.id || memId == 'admin'}">
	<input type=button value="글  수정" onclick="location.href='/miniProject/board/boardModifyForm.do?seq=${boardDTO.seq }&pg=${pg }'">
	<input type=button value="글  삭제" onclick="location.href='/miniProject/board/boardDelete.do?seq=${boardDTO.seq}'">
</c:if>
<input type="button" value="답      글" onclick="location.href='/miniProject/board/boardReplyForm.do?pseq=${boardDTO.seq}&pg=${pg }'">
</div>
</body>
</html>