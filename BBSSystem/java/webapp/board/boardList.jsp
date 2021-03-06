<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
<h2>Board List</h2>
<%
	int currentPage = 1;
	if(request.getParameter("currentPage")!=null){
		currentPage = 
			Integer.parseInt(
			request.getParameter("currentPage"));
	}
	BoardDAO boardDao = new BoardDAO();
	int totalRowCount = boardDao.selectTotalBoardCount();
	int pagePerRow = totalRowCount;
	int beginRow = (currentPage-1)*pagePerRow;
	List<Board> list = 
	boardDao.selectBoardListPerPage(beginRow, pagePerRow);
%>

<div>전체행의 수 : <%=totalRowCount%>/<%=list.size()%></div>
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
<%for(Board b : list){ %>
		<tr>
			<td><a href="<%=request.getContextPath()%>
			/board/boardView.jsp?boardNo=
			<%=b.getBoardNo()%>"><%=b.getBoardNo()%></td>
			<td><a href="<%=request.getContextPath()%>
			/board/boardView.jsp?boardNo=
			<%=b.getBoardNo()%>"><%=b.getBoardTitle()%></a></td>
			<td><%=b.getBoardUser()%></td>
			<td><%=b.getBoardDate()%></td>
		</tr>
<%}%>
	</tbody>
</table><br>
<div><a href="<%=request.getContextPath()%>
/board/boardAddForm.jsp">게시글 입력</a></div>
<%
	int lastPage = totalRowCount/pagePerRow;
	if(totalRowCount%pagePerRow !=0){
		lastPage++;
	}
%>
<div>
<%
	if(currentPage>1){
%>	
	<a href="<%=request.getContextPath()%>/board/boardList.jsp?currentPage=<%=currentPage-1%>">이전</a>
<%
	}
	if(currentPage < lastPage){
%>
	<a href="<%=request.getContextPath()%>/board/boardList.jsp?currentPage=<%=currentPage+1%>">다음</a>
<%
	}
%>
</div>
</body>
</html>
