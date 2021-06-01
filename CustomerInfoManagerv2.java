package cms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerInfoManager implements Serializable {
	
	static ArrayList <CustomerInfo> customerInfoList = new ArrayList<CustomerInfo>();
	public static Scanner sc = new Scanner(System.in);
	
	
	public static int saveCustomerInfo() {
		CustomerInfo ci = new CustomerInfo();
		System.out.println("중복된 고객 이름인지 확인 후 고객 정보를 저장합니다. 이름을 입력하세요:");
		String name = sc.next().trim();
		System.out.println("입력한 이름: " + name);
		for (int i=0; i<customerInfoList.size();i++) {
			if(customerInfoList.get(i).getName().equals(name)) {
				return i;
			}
		}
		//매개변수로 받은 이름 전달
		ci.setName(name);
		
		//성별 받기
		System.out.println("성별(M/F):");
		char gender = sc.next().trim().charAt(0);
		
		while(!(gender == 'M' || gender == 'F')) {
			System.out.println("M 또는 F를 입력하세요");
			gender = sc.next().trim().charAt(0);
		}
		ci.setGender(gender);
		
		//이메일 받기
		System.out.println("이메일:");
		ci.setEmail(sc.next().trim());
	
		//태어난 연도 받기
		System.out.println("태어난 연도:");
		String s = sc.next().trim();
		
		char[] c = s.toCharArray();
		boolean b = false;
	
		do {
			for (int i = 0;i<c.length;i++) {
				if ((int) c[i] < 48 || (int) c[i] > 57) {
					b = true;
					System.out.println("숫자로만 입력해주세요.");
					s = sc.next().trim();
					System.out.println("입력받은 값: " + s);
					c = s.toCharArray();
					break;
				} else {
					b = false;
				}
		}
		} while (b);
		ci.setBirthYear(Integer.parseInt(s));
		
		customerInfoList.add(ci);
		printCustomerInfo(customerInfoList.size() - 1);
		return -1;
	}
	
	public static int searchInfoByName() {
		String name = sc.next().trim(); 
		System.out.println("입력한 이름: " + name);
		for (int i=0; i<customerInfoList.size();i++) {
			if(customerInfoList.get(i).getName().equals(name)) {
				//System.out.println(i);
				return i;
			}
		}
		return -1;
	}
	public static void updateCustomerInfo(int idx) {
		CustomerInfo ci = customerInfoList.get(idx);
		System.out.println(ci.getName() + "의 고객 정보를 수정합니다.");
		System.out.println("이름:");
		ci.setName(sc.next().trim());
		System.out.println("성별(M/F):");
		char gender = sc.next().trim().charAt(0);
		while(!(gender == 'M' || gender == 'F')) {
			//System.out.println((gender != 'M' || gender != 'F'));
			System.out.println("M 또는 F를 입력하세요");
			gender = sc.next().trim().charAt(0);
		}
		ci.setGender(gender);
		System.out.println("이메일:");
		ci.setEmail(sc.next().trim());

		System.out.println("태어난 연도:");
		String s = sc.next().trim();
		char[] c = s.toCharArray();
		boolean b = false;
		do {
		for (int i = 0;i<c.length;i++) {
			if ((int) c[i] < 48 || (int) c[i] > 57) {
				b = true;
				System.out.println("숫자로만 입력해주세요.");
				s = sc.next().trim();
				c = s.toCharArray();
				break;
			}
		}
		} while (b);
		ci.setBirthYear(Integer.parseInt(s));
		printCustomerInfo(idx);
	}
	public static void deleteCustomerInfo(int idx) {
		customerInfoList.remove(idx);
		System.out.println("--------------------------------");
		System.out.println("삭제가 완료되었습니다.");
		System.out.println("--------------------------------");
	}
	public static void printCustomerInfo(int idx) {
		CustomerInfo ci = customerInfoList.get(idx);
		System.out.println("--------------------------------");
		System.out.println("이름:"+ ci.getName() + ", 성별:" + ci.getGender() + ", 이메일: " + ci.getEmail() + ", 태어난 연도:" + ci.getBirthYear());
		System.out.println("--------------------------------");
	}
	public static void allPrintClientInfo( ) {
		
		int count = customerInfoList.size();  
		
		if (count <= 0 ) {
			System.out.println("*****************************************");
			System.out.println("고객정보가 없습니다 ");
			System.out.println("*****************************************");
		
			} else {
				
				CustomerInfo ccs;
				for(int i=0; i< count; i++) {	
					
					ccs = customerInfoList.get(i);
					//현재 리스트에 값을 출력하기 위해 출력한다
					System.out.println("*****************************************");
					System.out.println(" 이름은	: " + ccs.getName() );
					System.out.println(" 성별	: " + ccs.getGender());
					System.out.println(" 이메일	: " +ccs.getEmail());
					System.out.println(" 출생년도	: " + ccs.getBirthYear());
					System.out.println("*****************************************");
					}
		}
	}
}
