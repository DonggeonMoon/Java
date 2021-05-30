package cms;

import java.util.Scanner;

public class CustomerInfoEx {
	
	static Scanner sc = new Scanner(System.in);
	static int index = -1;
	static CustomerInfoManager cim = new CustomerInfoManager();
	
	public static char questionView() { //원하는 작업을 호출하는 메소드	 
	 	
		System.out.println("******************************************");
	  	System.out.println("메뉴를 입력하세요");
		System.out.println("I - 고객정보 입력\n"
				+ "A - 전체 고객정보 조회\n"
				+ "P - 이전 고객정보 조회\n"
				+ "N - 다음 고객정보 조회\n"
				+ "U - 고객정보 수정\n"
				+ "D - 고객정보 삭제\n"
				+ "Q - 프로그램 종료");
	  	System.out.println("******************************************");
	   
		//여기서 예외처리하자
	  	String menu = sc.next().toUpperCase().trim(); // 해당값을 받아 무조건 대문자로 바꾸어준다.
	  	if (menu.length() > 1) {
			System.out.println("작업 메뉴에 없는 호출정보입니다. 다시 입력해주세요.");				
			questionView(); //재귀함수			
       }
	  	return menu.charAt(0);
	}
	
	public static void main(String[] args) {
		
		while(true) {
			char menu = questionView();
			switch (menu) {
			case 'I', 'i' :
				System.out.println("고객정보를 저장합니다.");
				index = cim.saveCustomerInfo();
				if (index != -1) {
					System.out.println("--------------------------------");
					System.out.println("이미 같은 이름의 고객이 존재합니다.");
					System.out.println("--------------------------------");
				} else {
					System.out.println("저장 완료");
					System.out.println("--------------------------------");
				}
				break;
			case 'P', 'p':
				System.out.println("입력한 고객 이전 고객의 정보를 조회합니다. 조회할 고객의 이름을 입력하세요.");
				index = cim.searchInfoByName();
				if (index >= 0) {
					if (index == 0) {
						System.out.println("--------------------------------");
						System.out.println("이전 고객정보가 없습니다.");
						System.out.println("--------------------------------");
					} else {
						cim.printCustomerInfo(index - 1);
					}
				} else {
					System.out.println("--------------------------------");
					System.out.println("조회한 정보가 없습니다.");
					System.out.println("--------------------------------");
				}
				break;
			case 'N', 'n':
				System.out.println("입력한 고객 다음 고객의 정보를 조회합니다. 조회할 고객의 이름을 입력하세요.");
				index = cim.searchInfoByName();
				if (index >= 0) {
					if (index == cim.customerInfoList.size() - 1) {
						System.out.println("--------------------------------");
						System.out.println("다음 고객정보가 없습니다.");
						System.out.println("--------------------------------");
					} else {
						cim.printCustomerInfo(index + 1);
					}
				} else {
					System.out.println("--------------------------------");
					System.out.println("조회한 정보가 없습니다.");
					System.out.println("--------------------------------");
				}
				break;
			case 'U', 'u':
				System.out.println("고객정보를 수정합니다. 수정할 고객의 이름을 입력하세요.");
				index = cim.searchInfoByName();
				if (index >= 0) {
					cim.updateCustomerInfo(index);
				} else {
					System.out.println("--------------------------------");
					System.out.println("수정할 정보가 없습니다.");
					System.out.println("--------------------------------");
				}
				break;
			case 'D', 'd':
				System.out.println("고객정보를 삭제합니다. 삭제할 고객의 이름을 입력하세요.");
				index = cim.searchInfoByName();
				if (index >= 0) {
					cim.deleteCustomerInfo(index);
				} else {
					System.out.println("--------------------------------");
					System.out.println("삭제할 정보가 없습니다.");
					System.out.println("--------------------------------");
				}
				break;
			case 'Q', 'q':
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 'A', 'a':
				cim.allPrintClientInfo();
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
				break;
			}	
		}
	}	
}
