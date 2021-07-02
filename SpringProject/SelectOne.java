package spring_app09.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring_app09.service.DAO;
import spring_app09.service.EmpDTO;

public class SelectOne {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("app.xml");
		DAO d = context.getBean("dao", DAO.class);
		
		EmpDTO empDto = new EmpDTO();
		empDto = d.selectOne(7900);
		
		System.out.print("empno: "+empDto.getEmpno());
		System.out.print(", ename: "+empDto.getEname());
		System.out.print(", sal: "+empDto.getSal());
		System.out.print(", detpno: "+empDto.getDeptno());
		System.out.println();
	}
}
