<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Modify</title>
</head>
<body>
<h2>Board Modify</h2>
<form action="<c:url value='/board/boardModify' />" method="post">
<div>boardNo: </div>
<div><input name="boardNo" type="text" value="${board.boardNo}"></div>
<div>boardPw: </div>
<div><input name="boardPw" type="password" value="${board.boardPw}"></div>
<div>boardTitle: </div>
<div><input name="boardTitle" type="text" value="${board.boardTitle}"></div>
<div>boardContent: </div>
<div><textarea name="boardContent" type="text">${board.boardContent}</textarea></div>
<div>boardUser: </div>
<div><input name="boardNo" type="text" value="${board.boardUser}"></div>
<div>
<input type="submit" value="글수정">
<a href="<c:url value='/board/boardList'/>"><input type="button" value="리스트"></a>
</form>
</body>
</html>
