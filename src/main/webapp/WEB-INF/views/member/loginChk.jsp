<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<% if ((int)request.getAttribute("check") == 1) {%>
				<script type="text/javascript">
					alert("아이디가 존재하지 않습니다.")
					location.href='login'
				</script>
		<%} else if ((int)request.getAttribute("check") == 2) {%>
				<script type="text/javascript">
					alert("아이디 혹은 비밀번호가 틀립니다")
					location.href='login'
				</script>
		<%}%>
</body>
</html>