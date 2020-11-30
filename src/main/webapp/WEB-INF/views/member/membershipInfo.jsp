<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
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
		<table border="1" align="center" style="min-width: 400px;">
			<caption><font style="font-size: 25px; text-align: center; font-weight: bold;"> 회원정보 </font></caption>
			<tr>
				<th> 아이디 </th>	
				<th> 주소 </th>	
			</tr>	
			<c:forEach var="dto" items="${list }">
			<tr>
				<td style="text-align: center;"><a href="memberInfo?id=${dto.id }">${dto.id }</a></td>
				<td style="text-align: center;">${dto.addr }</td>
			</tr>	
			</c:forEach>
		</table>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>