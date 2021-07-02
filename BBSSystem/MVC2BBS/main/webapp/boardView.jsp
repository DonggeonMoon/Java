<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board View</title>
</head>
<body>
<h2>Board View<h2></h2>
<form>
<table border="1px solid">
	<thead>
		<tr>
			<th>boardNo</th>
			<th>boardTitle</th>
			<th>boardUser</th>
			<th>boardDate</th>
		</tr>
	</thead>
	<tbody>
	<tr>
		<td>${board.getBoardNo()}</td>
		<td>${board.getBoardTitle()}</td>
		<td>${board.getBoardContent()}</td>
		<td>${board.getBoardUser()}</td>
	<tr>
	</tbody>
</table>
<div>
	<a href="<c:url value='/board/boardModify?boardNo=${board.getBoardNo()}' />"><input type="button" value="수정"></a>
	<a href="<c:url value='/board/boardRemove?boardNo=${board.getBoardNo()}' />"><input type="button" value="삭제"></a>
	<a href="<c:url value='/board/boardList' />"><input type="button" value="리스트"></a>
</div>
</form>
</body>
</html>
