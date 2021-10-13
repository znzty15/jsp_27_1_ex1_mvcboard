<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>게시일</td>
			<td>조회수</td>
		</tr>		
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bid}</td>
				<td><a href="content_view.do?bid=${dto.bid}">${dto.btitle}</a></td>
				<td>${dto.bname}</td>
				<td>${dto.bdate}</td>
				<td>${dto.bhit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view.do">게시글 작성</a></td>
		</tr>
	</table>
</body>
</html>