package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Board;
import service.BoardDAO;

@WebServlet("/board/boardList")
public class BoardListServlet extends HttpServlet {
	private BoardDAO boardDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int currentPage;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} else {
			currentPage = 1;
		}
		
		boardDao = new BoardDAO();
		int totalRowCount = boardDao.selectTotalBoardCount();
		
		List<Board> list = boardDao.selectBoardList();
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalRowCount", totalRowCount);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
		System.out.println(list);
	}
}
