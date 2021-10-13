<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reply_view.jsp</title>
</head>
<body>
	<h3>자유게시판 답변</h3>
	<table width="800" cellpadding="0" cellspacing="0" border="1">
		<form action="reply.do" method="post">
			<input type="hidden" name="bid" value="${reply_view.bid }">
			<input type="hidden" name="bgroup" value="${reply_view.bgroup }">
			<input type="hidden" name="bstep" value="${reply_view.bstep }">
			<input type="hidden" name="bindent" value="${reply_view.bindent }">			
			<tr>
				<td align="center" width="10%">번 호</td>
				<td width="20%">${reply_view.bid }</td>
				<td align="center" width="10%">글제목</td>
				<td><input type="text" name="btitle" size="60" value="${reply_view.btitle }"></td>
			</tr>
			<tr>
				<td align="center">글쓴이</td>
				<td><input type="text" name="bname" value="${reply_view.bname }"></td>
				<td align="center">조회수</td>
				<td>${reply_view.bhit }</td>
			</tr>
			<tr>
				<td align="center">내 용</td>
				<td colspan="3"><textarea cols="90" name="bcontent" rows="10">${reply_view.bcontent }</textarea></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="답변"></td>
				<td colspan="3"><a href="list.do">글목록보기</a></td>
			</tr>		
		</form>	
	</table>
</body>
</html>