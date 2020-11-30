<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardInfo.title}</title>
</head>
<body>
	<% //로그인 안된 상태로 이 페이지를 접근시 강제로 index페이지로 보냄
		if (session.getAttribute("id") == null) {%>
			<script type="text/javascript">
				location.href='index'
			</script>
	<%}%>
	<c:import url="../default/header.jsp"/>
		
		<form action="modifyBrd" method="post">
		<input type="text" name="id" value="${boardInfo.id}"hidden="hidden">
		<table align="center" style="width: 500px;" border="1">
			<tr>
				<td>글번호</td>
				<td style="text-align: left;">${boardInfo.id}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td style="text-align: left;">${boardInfo.hit}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td style="text-align: left;">
				<input type="text" name="name" value="${boardInfo.name }" style="max-width: 50px;">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${boardInfo.title }" style="min-width: 421px;" ></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
				<textarea rows="10" cols="58" name="content">${boardInfo.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="right">
				<input type="submit" value="수정">
				&nbsp;
				<a href="deleteBrd?id=${boardInfo.id }">삭제</a>
				&nbsp;
				<a href="replyBrd?id=${boardInfo.id }">답글</a>
				&nbsp;
				<a href="/spring/board/list">목록보기</a> </td>
			</tr>
		</table>
		</form>
	<c:import url="../default/footer.jsp"/>
</body>
</html>