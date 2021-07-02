package spring_app09.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring_app09.service.DAO;
import spring_app09.service.EmpDTO;

public class insertOne {
	
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("app.xml");
		DAO d = context.getBean("dao", DAO.class);
		
		EmpDTO empDto = new EmpDTO();
		
		int empno = 8000;
		String name = "홍길동";
		int sal = 3000;
		int deptno = 40;
		
		empDto.setEmpno(empno);
		empDto.setEname(name);
		empDto.setSal(sal);
		empDto.setDeptno(deptno);
		
		d.insertOne(empDto);
	}
}
