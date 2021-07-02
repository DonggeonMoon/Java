<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
if(request.getParameter("boardNo") == null || 
request.getParameter("boardPw") == null){
	response.sendRedirect(request.getContextPath()+
			"/board/boardList.jsp");
}else{
	int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	System.out.println("Remove boardNo : " + boardNo);
	String boardPw = request.getParameter("boardPw");
	System.out.println("Remove boardPw : " + boardPw);
	Board board = new Board();
	board.setBoardNo(boardNo);
	board.setBoardPw(boardPw);
	
	BoardDAO boardDao = new BoardDAO();
	
	if(boardDao.deleteBoard(board)==1){
		response.sendRedirect(request.getContextPath()
				+"/board/boardList.jsp");		
	}else{
		response.sendRedirect(request.getContextPath()
+"/board/boardRemoveForm.jsp?boardNo="+boardNo);
	}
}
%>
</body>
</html>
