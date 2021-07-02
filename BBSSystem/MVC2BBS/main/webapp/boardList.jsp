<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
<div>전체 행의 수: ${list.size()}/${totalRowCount}</div>
<table border="1">
	<thead>
		<tr>
			<th>boardNo</th>
			<th>boardTitle</th>
			<th>boardUser</th>
			<th>boardDate</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="b" items="${list}">
		<tr>
			<td><a href="<%=request.getContextPath()%>/board/boardView?boardNo=${b.boardNo}"></a>${b.boardNo}</td>
			<td><a href="<%=request.getContextPath()%>/board/boardView?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
			<td>${b.boardUser}</td>
			<td>${b.boardDate}</td>
		</tr>
		</c:forEach>
	</tbody>
</table><br/>
<div>
	<a href="<%=request.getContextPath()%>/board/boardAdd"><input type="button" value="글입력"></a>
</div>
</body>
</html>
