<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
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
		<table class="table table-condensed" border="1" align="center" style="min-width: 500px;">
			<caption><font style="font-size: 25px; text-align: center; font-weight: bold;"> 게시판 </font></caption>
			<tr>
				<th>번호</th> <th>이름</th> <th>제목</th> <th>날짜</th> <th>조회수</th> <th>group</th> <th>step</th> <th>indent</th>
			</tr>
			<c:choose>
				<c:when test="${brdList.size() != 0}">
					<c:forEach var="brd" items="${brdList}">
						<tr>
							<td>${brd.id }</td> <td>${brd.name }</td> 
							
							<td>
							<c:forEach begin="1" end="${brd.indent}">-></c:forEach>
							<a href="boardInfo?id=${brd.id }">${brd.title }</a>
							</td> 
							
							<td>${brd.savedate }</td> 
							<td>${brd.hit }</td> <td>${brd.idgroup }</td> 
							<td>${brd.step }</td> <td>${brd.indent }</td>
						</tr>
					</c:forEach>
				</c:when>	
				<c:otherwise>
					<tr>
						<th colspan="8">작성된 게시물이 없습니다.</th>
					</tr>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="7">
				<c:choose>
					<c:when test="${start>1 }">
						<button type="button" onclick="location.href='/spring/board/list?start=${start-1}'">
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
					<a href="/spring/board/list?start=${cnt}">[${cnt}]</a>
				</c:forEach>
				
				<c:choose>
					<c:when test="${start < totalPage }">
						<button type="button" onclick="location.href='/spring/board/list?start=${start+1}'">
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
				<td>
				<a href="regBrd">글작성</a>
				</td>
			</tr>
		</table>
		
	</div>
	<c:import url="../default/footer.jsp"/>
</body>
</html>