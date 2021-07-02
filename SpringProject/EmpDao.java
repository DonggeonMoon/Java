package spring_app09.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmpDao implements DAO {
	
	private JdbcTemplate jdbcTemplate;
	//PreparedStatement pstmt;
	ResultSet rs;
	StringBuffer sb = new StringBuffer();

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<EmpDTO> selectAll() {
		sb.setLength(0);
		sb.append("select * from emp");
		
		RowMapper<EmpDTO> rm = new RowMapper<EmpDTO>() {
			
			@Override
			public EmpDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
				return new EmpDTO(rs.getInt("empno"), rs.getString("ename"), rs.getInt("sal"), rs.getInt("deptno"));
			}
		};
		
		List <EmpDTO> list = jdbcTemplate.query(sb.toString(), rm);
		return list;
	}

	@Override
	public EmpDTO selectOne(int no) {
		sb.setLength(0);
		sb.append("select empno, ename, sal, deptno from emp where empno = ? ");
		
		RowMapper<EmpDTO> rm = new RowMapper<EmpDTO>() {

			@Override
			public EmpDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpDTO dto = new EmpDTO(rs.getInt("empno"), rs.getString("ename"), rs.getInt("sal"), rs.getInt("deptno"));
				return dto;
			}
		};
		EmpDTO dto = jdbcTemplate.queryForObject(sb.toString(), rm, no);
		return dto;
	}

	@Override
	public void insertOne(EmpDTO dto) {
		// TODO Auto-generated method stub
		sb.setLength(0);
		sb.append("insert into emp(empno, ename, sal, deptno) values(?, ?, ?, ?) ");
		
		int result = jdbcTemplate.update(sb.toString(), dto.getEmpno(), dto.getEname(), dto.getSal(), dto.getDeptno());
		System.out.println("insert result:"+result);
	}

	@Override
	public void updateOne(EmpDTO dto) {
		// TODO Auto-generated method stub
		sb.setLength(0);
		sb.append("update emp set ename = ?, sal = ?, deptno = ? where empno = ? ");
		
		int result = jdbcTemplate.update(sb.toString(), dto.getEname(), dto.getSal(), dto.getDeptno(), dto.getEmpno());
		System.out.println("update result:"+result);
	}

	@Override
	public void deleteOne(int no) {
		// TODO Auto-generated method stub
		sb.setLength(0);
		sb.append("delete emp where empno= ? ");
		
		int result = jdbcTemplate.update(sb.toString(), no);
		System.out.println("delete result:"+result);
	}
}
