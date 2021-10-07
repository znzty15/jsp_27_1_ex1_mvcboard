<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach item=$"{list}" val="dto">
		<tr>
			<td>${dto.bid}</td>
			<td>${dto.bname}</td>
			<td>${dto.btitle}</td>
			<td>${dto.bdate}</td>
			<td>${dto.bhit}</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>