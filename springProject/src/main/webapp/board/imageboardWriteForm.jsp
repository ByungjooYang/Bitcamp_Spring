<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 등록</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="/miniProject/board/imageboardWrite.do"> <!-- 파일은 무조건 포스트	방식이다. 겟방식은 안됨. -->
<table border=1 align="center" style="border-collapse: collapse;">
<tr>
	<td width=70 align="center">상품코드</td>
	<td><input type="text" placeholder="코드 입력" name="imageId"  id="imageId"></td>
</tr>

<tr>
	<td align="center">상품명</td>
	<td><input type="text" placeholder="상품명 입력" name="imageName"  id="imageName"></td>
</tr>

<tr>
	<td align="center">단  가</td>
	<td><input type="text" placeholder="단가 입력" name="imagePrice"  id="imagePrice"></td>
</tr>

<tr>
	<td align="center">개  수</td>
	<td><input type="text" placeholder="코드 입력" name="imageQty"  id="imageQty"></td>
</tr>

<tr>
	<td align="center">내  용</td>
	<td><textarea name="imageContent"  id="imageContent" cols="40" rows="20" style="resize:none" placeholder="내용을 입력해주세요"></textarea></td>
</tr>

<tr>
	<td colspan="2"><input type="file" name="image1" size="50"></td>
</tr>

<tr>
	<td colspan="2" align="center">
	<input type="submit" value="파일업로드" >
	<input type="reset" value="다시 입력">
	</td>
</tr>
</table>
</form>
</body>
</html>