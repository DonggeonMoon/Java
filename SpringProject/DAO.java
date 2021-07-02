package spring_app09.service;

import java.util.List;
//명세서, 설계도
public interface DAO {
	
	public List<EmpDTO> selectAll();
	public EmpDTO selectOne(int no);
	public void insertOne(EmpDTO dto);
	public void updateOne(EmpDTO dto);
	public void deleteOne(int no);
}
