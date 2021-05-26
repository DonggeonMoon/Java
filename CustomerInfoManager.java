package cms;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerInfoManager {
	
	static ArrayList <CustomerInfo> customerInfoList = new ArrayList<CustomerInfo>();
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void saveCustomerInfo() {
		CustomerInfo ci = new CustomerInfo();
		System.out.println("고객 정보를 저장합니다.");
		System.out.println("이름:");
		ci.setName(sc.next().trim());
		System.out.println("성별(M/F):");
		char gender = sc.next().trim().charAt(0);
		while(!(gender == 'M' || gender == 'F')) {
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
				System.out.println("입력받은 값: " + s);
				c = s.toCharArray();
				break;
			} else {
				b = false;
			}
			System.out.println("여기");
		}
		} while (b);
		ci.setBirthYear(Integer.parseInt(s));
		
		customerInfoList.add(ci);
		printCustomerInfo(customerInfoList.size()-1);
	}
	
	public static int searchInfoByName() {
		String name = sc.next().trim(); 
		System.out.println("입력한 이름: " + name);
		for (int i=0; i<customerInfoList.size();i++) {
			if(customerInfoList.get(i).getName().equals(name)) {
				System.out.println(i);
				return i;
			}
		}
		return -1;
	}
	
	public static void updateCustomerInfo(int idx) {
		CustomerInfo ci = customerInfoList.get(idx);
		System.out.println("고객 정보를 수정합니다.");
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
	}
	public static void deleteCustomerInfo(int idx) {
		customerInfoList.remove(idx);
		System.out.println("삭제가 완료되었습니다.");
	}
	public static void printCustomerInfo(int idx) {
		CustomerInfo ci = customerInfoList.get(idx);
		System.out.println("이름:"+ ci.getName() + ", 성별:" + ci.getGender() + ", 이메일: " + ci.getEmail() + ", 태어난 연도:" + ci.getBirthYear());
	}
}
