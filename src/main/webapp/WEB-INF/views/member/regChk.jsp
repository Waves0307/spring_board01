<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if((int)request.getAttribute("reg") == 1) {%>
		<script type="text/javascript">
			alert("이미 등록된 회원입니다.")
			location.href='memberReg'
		</script>
	<% } else if ((int)request.getAttribute("reg") == 2) {%>
		<script type="text/javascript">
			alert("회원가입 완료!!")
			location.href='index'
		</script>
	<%} %>
</body>
</html>