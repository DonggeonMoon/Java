package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	private final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost";
	private final String USER = "scott";
	private final String PASSWORD = "tiger";
	
	//DB : board, 기능 : 한 페이지의 데이터 가져오기
	public List<Board> selectBoardListPerPage
					(int beginRow, int pagePerRow){
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from "
				+ "(select row_number() over "
				+ "(order by board_no desc) num, "
				+ "A.* from board a order by board_no) "
				+ "where num between ? and ? ";
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, pagePerRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardUser(rs.getString("board_user"));
				board.setBoardDate(rs.getString("board_date"));
				list.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//DB : board , 기능 : 전체 로우 카운터 가져오기
	public int selectTotalBoardCount(){
		int rowCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from board ";
		
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rowCount = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(conn,pstmt,rs);
		}
		
		return rowCount;
	}
	
	//DB : board , 기능 : 데이터 삽입
	public int insertBoard(Board board) {
		int rowCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board "
				+ "(board_no, board_pw, board_title, "
				+ "board_content, board_user, board_date) "
				+ "values(board1.NEXTVAL, ?, ?, ?, ?, sysdate) ";
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardPw());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setString(4, board.getBoardUser());
			rowCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(conn,pstmt,null);
		}
		return rowCount;
	}
	
	//DB:board, 기능 : 하나의 데이터 가져오기
	public Board selectBoardByKey(int boardNo) {
		Board board = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select board_title, board_content "
				+ ",board_user, board_date "
				+ "from board where board_no=? ";
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,boardNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new Board();
				board.setBoardNo(boardNo);
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardContent(rs.getString("board_content"));
				board.setBoardUser(rs.getString("board_user"));
				board.setBoardDate(rs.getString("board_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(conn, pstmt, rs);
		}		
		return board;
	}
	
	//DB : board, 기능 : 데이터 수정
	public int updateBoard(Board board) {
		int rowCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set board_title=?, "
				+ "board_content=? where board_no=? "
				+ "and board_pw=? ";
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getBoardNo());
			pstmt.setString(4, board.getBoardPw());
			rowCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(conn,pstmt,null);
		}
		return rowCount;	
	}
	
	//DB : board, 기능 : 데이터 삭제
	
	public int deleteBoard(Board board) {
		int rowCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board where "
				+ "board_no=? and board_pw=? ";
		try {
			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardNo());
			pstmt.setString(2, board.getBoardPw());
			rowCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close(conn, pstmt, null);
		}
		return rowCount;
	}
	
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn, 
			PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(pstmt != null) {
			try {
				pstmt.close();			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
