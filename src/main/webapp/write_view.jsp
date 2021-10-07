<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javaGG.ex.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write_view.jsp</title>
</head>
<body>
	<h3>자유게시판</h3>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write.do" method="post">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bname" size="50"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bcontent" rows="10" cols=50></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="입력"></td>
				<td><a href="list.do">글 리스트보기</a></td>
			</tr>			
		</form>
	</table>
</body>
</html>