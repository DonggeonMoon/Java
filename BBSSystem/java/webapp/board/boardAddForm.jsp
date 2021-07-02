<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Write</title>
</head>
<body>
<h2>Board Write</h2>
<form action="<%=request.getContextPath()%>
/board/boardAddAction.jsp" method="post">
<div>boardPw : </div>
<div><input type="password" name="boardPw" id="boardPw" /></div>
<div>boardTitle : </div>
<div><input type="text" name="boardTitle" id="boardTitle" /></div>
<div>boardContent : </div>
<div><textarea rows="5" cols="50" name="boardContent"
id="boardContent"></textarea></div>
<div>boardName : </div>
<div><input type="text" name="boardUser" id="boardUser" /></div><br>
<div>
	<input type="submit" value="글입력" />
	<input type="reset" value="초기화" />
</div>
</form>
</body>
</html>
