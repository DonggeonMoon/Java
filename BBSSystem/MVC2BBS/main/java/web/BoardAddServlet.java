package web;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Board;
import service.BoardDAO;

@WebServlet("/board/boardAdd")
public class BoardAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/board/boardAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String boardPw = request.getParameter("boardPw");
		System.out.println(boardPw);
		String boardTitle = request.getParameter("boardTitle");
		System.out.println(boardTitle);
		String boardContent = request.getParameter("boardContent");
		System.out.println(boardContent);
		String boardUser = request.getParameter("boardUser");
		System.out.println(boardUser);
		
		Board board = new Board();
		board.setBoardPw(boardPw);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardUser(boardUser);
		
		BoardDAO boardDao = new BoardDAO();
		int rowCount = boardDao.insertBoard(board);
		
		response.sendRedirect(request.getContextPath()+"/board/boardList");		
	}

}
