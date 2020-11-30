<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
</head>
<body>
	<% //로그인 안된 상태로 이 페이지를 접근시 강제로 index페이지로 보냄
		if (session.getAttribute("id") == null) {%>
			<script type="text/javascript">
				location.href='index'
			</script>
		<%}%>
	<c:import url="../default/header.jsp"/>
	<div>
		<form action="../board/saveBoard" method="post">
		<table border="1" align="center" style="width: 500px;">
			<caption><b style="font-size: 25px; font-weight: bold;">글 작성</b></caption>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
				
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" style="width: 398px;"></td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td><textarea style="width: 400px; height: 300px;" name="content"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2" align="right"><input type="submit" value="작성">&nbsp;<a href="/spring/board/list">목록보기</a> </td>
				
			</tr>
		</table>
		</form>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>