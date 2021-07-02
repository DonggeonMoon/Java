<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Modify</title>
</head>
<body>
<h2>Board Modify</h2>
<%	
	if(request.getParameter("boardNo") == null){
		response.sendRedirect(request.getContextPath()+
			"board/boardList.jsp");
	}else{
		int boardNo = Integer.parseInt
				(request.getParameter("boardNo"));
		System.out.println("boardModify boardNO : " + boardNo);
		BoardDAO boardDao = new BoardDAO();
		Board board = boardDao.selectBoardByKey(boardNo);
%>
<form action="<%=request.getContextPath()%>
/board/boardModifyAction.jsp" method="post">
<div>boardNo : </div>
<div><input name="boardNo" value="<%=board.getBoardNo()%>"
	type="text" readonly="readonly"></div>
<div>password : </div>
<div><input name="boardPw" type="password" 
	id="boardPw" /></div>
<div>boardTitle : </div>
<div><input name="boardTitle" type="text" 
id="boardTitle" value="<%=board.getBoardTitle()%>"/></div>
<div>boardContent : </div>
<div><textarea name="boardContent" id="boardContent" 
rows="5" cols="50"><%=board.getBoardContent()%>
</textarea></div><br>
<div>
	<input type="submit" value="글수정" />
	<input type="reset" value="초기화">
</div>
</form>
<%}%>
</body>
</html>
