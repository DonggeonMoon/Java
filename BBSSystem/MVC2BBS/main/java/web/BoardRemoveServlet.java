package web;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Board;
import service.BoardDAO;

@WebServlet("/board/boardRemove")
public class BoardRemoveServlet extends HttpServlet {
	private BoardDAO boardDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if (request.getParameter("boardNo")==null) {
			response.sendRedirect(request.getContextPath()+"/board/boardList");
		} else {
			request.getRequestDispatcher("/board/boardRemove.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if (request.getParameter("boardNo")==null||request.getParameter("boardPw")==null) {
			response.sendRedirect(request.getContextPath()+"/board/boardList");
			System.out.println("삭제 실패1");
		} else {
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			String boardPw = request.getParameter("boardPw");
			Board board = new Board();
			board.setBoardNo(boardNo);
			board.setBoardPw(boardPw);
			BoardDAO boardDao = new BoardDAO();
			if(boardDao.deleteBoard(board)==1) {
				response.sendRedirect(request.getContextPath()+"/board/boardList");
				System.out.println("삭제 성공");
			} else {
				response.sendRedirect(request.getContextPath()+"/board/boardRemove?boardNo="+boardNo);
				System.out.println("삭제 실패2");
			}
			
		}
	}
}
