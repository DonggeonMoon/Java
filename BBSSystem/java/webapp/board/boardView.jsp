<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board View</title>
</head>
<body>
<h2>Board View</h2>
<%
	if(request.getParameter("boardNo") == null){
		response.sendRedirect(request.getContextPath()+
				"/board/boardList.jsp");
	}else{
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardDAO boardDao = new BoardDAO();
		Board board = boardDao.selectBoardByKey(boardNo);	
%>
<table border="1">
	<thead>
		<tr>
			<th>No</th>
			<th>Title</th>
			<th>Content</th>
			<th>User</th>
			<th>Date</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><%=board.getBoardNo()%></td>
			<td><%=board.getBoardTitle()%></td>
			<td><%=board.getBoardContent()%></td>
			<td><%=board.getBoardUser()%></td>
			<td><%=board.getBoardDate()%></td>
		</tr>
	</tbody>	
</table>
<div>
	<a href="<%=request.getContextPath()%>
	/board/boardModifyForm.jsp?boardNo=
	<%=board.getBoardNo()%>">수정</a>
	<a href="<%=request.getContextPath()%>
	/board/boardRemoveForm.jsp?boardNo=
	<%=board.getBoardNo()%>">삭제</a>
	<a href="<%=request.getContextPath()%>
	/board/boardList.jsp">리스트</a>
</div>
<%}%>
</body>
</html>
