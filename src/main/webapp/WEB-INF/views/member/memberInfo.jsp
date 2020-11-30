<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
		<% //로그인 안된 상태로 이 페이지를 접근시 강제로 index페이지로 보냄
		if (session.getAttribute("id") == null) {%>
			<script type="text/javascript">
				location.href='index'
			</script>
		<%}%>
	<c:import url="../default/header.jsp"/>
	
	<table border="1" align="center" style="min-width: 300px;">
		<caption><font style="font-size: 25px; text-align: center; font-weight: bold;"> ${dto.id } &nbsp;정보 </font></caption>
		<tr>
			<th>아이디</th>
			<td style="text-align: center;"> ${dto.id }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td style="text-align: center;"> ${dto.addr }</td>
		</tr>
	</table>
	<c:import url="../default/footer.jsp"/>
</body>
</html>