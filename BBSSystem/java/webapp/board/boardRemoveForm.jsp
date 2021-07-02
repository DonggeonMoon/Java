<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Remove</title>
</head>
<body>
<%
if(request.getParameter("boardNo") == null){
	response.sendRedirect(request.getContextPath()+
			"/board/boardList.jsp");
	}else{
%>
<form action="<%=request.getContextPath()%>
/board/boardRemoveAction.jsp" method="post">
<input name="boardNo" type="hidden" 
	value="<%=request.getParameter("boardNo")%>" />
<div>비밀번호 확인 : </div>
<div><input name="boardPw" type="password"></div>
<div>
	<input type="submit" value="삭제" />
	<input type="reset" value="초기화" />
</div>
</form>
<%}%>
</body>
</html>
