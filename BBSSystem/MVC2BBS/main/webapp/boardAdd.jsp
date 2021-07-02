<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Write</title>
</head>
<body>
<h2>Board Write</h2>
<form action="<c:url value='/board/boardAdd'/>" method="post">
	<div>boardPw:</div>
	<div></div><input name="boardPw" type="password" id="boardPw"></div>
	<div>boardTitle: </div>
	<div><input name="boardTitle"type="text" id="boardContent"></div>
	<div>boardContent: </div>
	<div><textarea name="boardContent" rows="5" cols="50"></textarea></div>
	<div>boardUser: </div>
	<div><input name="boardUser"type="text" id="boardUser"></div><br/>
	<div>
		<input type="submit" value="글입력">
			<a href="<c:url value='/board/boardList' />"><input type="button" value="리스트"></a>
	</div>
</form>
</body>
</html>
