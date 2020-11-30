<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>

</head>
<body>
	<c:import url="../default/header.jsp"/>
	<p style="font-size: 30px; font-weight: bold;">로그인 페이지 입니다.</p>
	<form action="loginCheck" method="post">
		<table>
			<tr>
				<td style="text-align: center;"> 아이디 </td>
				<td><input type="text" name="id"></td>
				<td rowspan="2"><input type="submit" value="로그인" style="height: 50px; width: 60px;"></td>
			</tr>
			<tr>
				<td style="text-align: center;"> 비밀번호 </td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<th colspan="3"><a href="memberReg">회원가입</a></th>
			</tr>
		</table>
	</form>
	<c:import url="../default/footer.jsp"/>
</body>
</html>