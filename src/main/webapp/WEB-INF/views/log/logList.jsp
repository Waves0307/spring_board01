<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 로그인 기록</title>
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
		<table border="1" align="center" style="min-width: 500px;">
			<caption><font style="font-size: 25px; text-align: center; font-weight: bold;"> 로그정보 </font></caption>
			<tr>
				<th>번호</th> <th>아이디</th> <th>접속</th> <th>종료</th> <th>사용시간</th>
			</tr>
			<c:choose>
				<c:when test="${logList.size() != 0}">
					<c:forEach var="log" items="${logList}">
						<tr>
							<td>${log.num }</td> 
							<td>${log.id }</td> 
							<td>${log.startTime}</td> 
							<td>${log.endTime }</td> 
							<td>${log.resultTime }</td>
						</tr>
					</c:forEach>
				</c:when>	
				<c:otherwise>
					<tr>
						<th colspan="5">사용자 접속 기록이 없습니다.</th>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="5">
				<c:choose>
					<c:when test="${start>1 }">
						<button type="button" onclick="location.href='/spring/log/logList?start=${start-1}'">
						이전
						</button>
					</c:when>
					<c:otherwise>
						<button type="button" disabled>
						이전
						</button>
					</c:otherwise>
				</c:choose>
				
				<c:forEach begin="1" end="${totalPage }" step="1" var="cnt">
					<a href="/spring/log/logList?start=${cnt}">[${cnt}]</a>
				</c:forEach>
				
				<c:choose>
					<c:when test="${start < totalPage }">
						<button type="button" onclick="location.href='/spring/log/logList?start=${start+1}'">
						다음
						</button>
					</c:when>
					<c:otherwise>
						<button type="button" disabled>
						다음
						</button>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</table>
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>