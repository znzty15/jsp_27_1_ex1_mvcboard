<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<h1>자유게시판</h1>
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
				<td><textarea name="bcontent" rows="10" cols="46"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;&nbsp;&nbsp;<a href="list.do">글 리스트 보기</a></td>
			</tr>		
		</form>	
	</table>
</body>
</html>