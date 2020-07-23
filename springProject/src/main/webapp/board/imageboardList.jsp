<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>★게시판★</title>
<style>
#currentPaging {
	color:red;
	cursor:pointer;
}
#paging {
	color:blue;
 	text-decoration:none;
 	cursor:pointer;
 }
 
.subjectA:link {color:black; text-decoration:none;}
.subjectA:active {color:black; text-decoration:none;}
.subjectA:hover{color:blue; text-decoration:underline;}
.subjectA:visited {color:black; text-decoration:none;}
</style>
</head>
<body>
<h3>이미지 보기</h3>

<table border="1" width="550" style="border-collapse: collapse;">
	<tr>
		<th><input type="checkbox" id="allNum" onclick="allClick()">번  호</th>
		<th>이미지</th>
		<th>상품명</th>
		<th>단  가</th>
		<th>개  수</th>
		<th>합  계</th>
	</tr>
	
	<c:if test="${imageList != null }">
		<c:forEach var="imageboardDTO" items="${imageList }">
			<tr>
				<td align="center"><input type="checkbox" name="seq" value="${imageboardDTO.seq }" onclick="indivClick()">${imageboardDTO.seq }</td>
				<td align="center">
					<a href="/miniProject/board/imageboardView.do?seq=${imageboardDTO.seq }">
					<img src="../storage/${imageboardDTO.image1 }" width="50" height="50"/></a>
				</td>
				<!-- 실제 우리가 작업하는 storage 폴더에는 파일이 없어도 .metadata 안에 저장된 값을 자동으로 가져오므로 실제 메타데이터 주소를 끌고 올 필요가 없다.
				 그리고 메타데이터 안의 데이터는 외부에서 접근하지 못하도록 막아놨기 때문에 실 주소로 접근시 막힌다. -->
				<td align="center"><a href="/miniProject/board/imageboardView.do?seq=${imageboardDTO.seq }">${imageboardDTO.imageName }</a></td>
				<td align="center"><fmt:formatNumber value="${imageboardDTO.imagePrice }"/>원</td>
				<td align="center">${imageboardDTO.imageQty }</td>
				<td align="center"><fmt:formatNumber value="${imageboardDTO.imagePrice * imageboardDTO.imageQty}"/>원</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<div style="margin-top:5px; display:grid; grid-template-columns: 1fr 1fr 1fr;">
	<c:choose>
		<c:when test="${memId == 'admin' }">
			<div><input type="button" value="선택삭제" onclick="choiceDelete()"></div>
		</c:when>
		
		<c:otherwise>
			<div></div>
		</c:otherwise>
	</c:choose>
	
	<div align="center">
		${boardPaging.pagingHTML }
	</div>
	
	<div></div>

</div>
</body>
<script src="../js/board.js"></script>
</html>