package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Board;
import service.BoardDAO;

@WebServlet("/board/boardModify")
public class BoardModifyServlet extends HttpServlet {
	private BoardDAO boardDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		Board board;
		if(request.getParameter("boardNo")==null) {
			response.sendRedirect(request.getContextPath()+"/board/boardList");
		} else {
			int boardNo=Integer.parseInt(request.getParameter("boardNo"));
			System.out.println("boadrNo: "+boardNo);
			boardDao = new BoardDAO();
			Board board1 = boardDao.selectBoardByKey(boardNo);
			request.setAttribute("board", board1);
			request.getRequestDispatcher("/board/boardModify.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("boardNo")==null||request.getParameter("boardPw")==null) {
			response.sendRedirect(request.getContextPath()+"/board/boardList");
		} else {
			int boardNo=Integer.parseInt(request.getParameter("boardNo"));
			String boardPw = request.getParameter("boardPw");
			String boardTitle = request.getParameter("boardTitle");
			String boardContent = request.getParameter("boardContent");
			String boardUser = request.getParameter("boardUser");
			
			Board board= new Board();
			board.setBoardNo(boardNo);
			board.setBoardPw(boardPw);
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			
			boardDao = new BoardDAO();
			int rowCount = boardDao.updateBoard(board);
			System.out.println("rowCount: "+rowCount);
			if(rowCount > 0) {
				response.sendRedirect(request.getContextPath()+"/board/boardView?boardNo="+boardNo);
				System.out.println("성공");
			} else {
				response.sendRedirect(request.getContextPath()+"/board/boardModify?boardNo="+boardNo);
				System.out.println("실패");
			}
		}
	}
}
