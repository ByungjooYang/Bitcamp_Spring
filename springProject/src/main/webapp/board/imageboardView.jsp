<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>~이미지 뷰~</title>
</head>
<body>
<h4>상세보기</h4>
<table border="3" cellspacing="0" cellpadding="3" style="border-collapse:collapse"> <!-- frame="hsides" rules="rows" -->
<tr>
	<td rowspan="4" align="center">
	<img src="../storage/${imageboardDTO.image1 }" width="200" height="250">
	<br>
	<img src="../image/look.jpg" width="30" height="30" id="bigImage" onclick="imagePopup('../storage/${imageboardDTO.image1 }')">
	</td>
	<td width="200"><b>상품명 : ${imageboardDTO.imageName }</b></td>
</tr>

<tr>
	<td>단  가 : <fmt:formatNumber value="${imageboardDTO.imagePrice }"/></td>
</tr>

<tr>
	<td>개  수 : ${imageboardDTO.imageQty }</td>
</tr>

<tr>
	<td>합  계 : <fmt:formatNumber value="${imageboardDTO.imageQty * imageboardDTO.imagePrice}" /></td>
</tr>

<tr>
	<td colspan="2" height="100">${imageboardDTO.imageContent }</td>
</tr>
</table>
<br>
<input type="button" value="뒤로가기" onclick="javascript:history.go(-1)=''">
</body>
<script type="text/javascript">
function imagePopup(url){
	let imageWin = window.open(url, "", "width=500 height=500");
	imageWin.document.write("<a href=javascript:window.close()><img src='" + url + "' border=0 width=500 height=500></a>"); 
	imageWin.document.title = "이미지 확대";
	
	/*
	let imageWin = window.open(url, "", "width=500 height=500");
	let image = newWindow.document.createElement("img");
	img.setAttribute("src", "http://localhost:8080/miniProject/storage/$(imageboardDTO.image1)"); //크롬은 상대주소 안먹는다.
	img.setAttribute("width", "500");
	img.setAttribute("height", "500");
	newWindow.document.body.appendChild(img);
	*/
}


$('bigImage').click(function(){
	let imageWin = window.open("../storage/${imageboardDTO.image1}", "", "width=500 height=500");
	$('#imageView').attr('width', '500');
	$('#imageView').attr('heigth', '500');
	let url = $('#imageView').attr('src');
	
});
 
</script>

</html>