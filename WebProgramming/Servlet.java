import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/servlet")
public class Servlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String sessionid = session.getId();
		session.setMaxInactiveInterval(60*5);
		int sessionMaxinterval = session.getMaxInactiveInterval();
		
		
				
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
		out.println(id + "님 환영합니다.<br>");
		out.println("session ID: " + sessionid +"<br>");
		out.println(String.valueOf(sessionMaxinterval/60) + "분간 로그인 세션이 유지됩니다."); 
		out.println("</body>");
		out.println("</html>");
	}
}
