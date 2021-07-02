<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="service.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
if(request.getParameter("boardNo") == null 
	|| request.getParameter("boardPw") == null){
	response.sendRedirect(request.getContextPath()+
			"/board/boardList.jsp");
}else{
	int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	System.out.println("BoardModifyAction boardNo : " + boardNo);
	String boardPw = request.getParameter("boardPw");
	System.out.println("BoardModifyAction boardPw : " + boardPw);
	String boardTitle = request.getParameter("boardTitle");
	System.out.println("BoardModifyAction boardTitle : " + boardTitle);
	String boardContent = request.getParameter("boardContent");
	System.out.println("BoardModifyAction boardContent : " + boardContent);
	
	Board board = new Board();
	board.setBoardNo(boardNo);
	board.setBoardPw(boardPw);
	board.setBoardTitle(boardTitle);
	board.setBoardContent(boardContent);
	
	BoardDAO boardDao = new BoardDAO();
	boardDao.updateBoard(board);
	
	response.sendRedirect(request.getContextPath()+
			"/board/boardView.jsp?boardNo="+boardNo);	
}
%>
</body>
</html>
