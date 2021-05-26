package cms;

import java.util.Scanner;

public class CustomerInfoEx {
	
	static Scanner sc = new Scanner(System.in);
	static int index = -1;
	static CustomerInfoManager cim = new CustomerInfoManager();
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("메뉴를 입력하세요");
			System.out.println("I - 고객정보 입력\n"
					+ "P - 이전 고객정보 조회\n"
					+ "N - 다음 고객정보 조회\n"
					+ "U - 고객정보 수정\n"
					+ "D - 고객정보 삭제\n"
					+ "Q - 프로그램 종료");
			String menu = sc.next();
			switch (menu.charAt(0)) {
			case 'I', 'i' :
				System.out.println("고객정보를 입력합니다.");
				cim.saveCustomerInfo();
				break;
			case 'P', 'p':
				System.out.println("입력한 고객 이전 고객의 정보를 조회합니다.");
				index = cim.searchInfoByName();
				System.out.println("--------------------------------");
				if (index >= 0) {
					if (index == 0) {
						System.out.println("이전 고객정보가 없습니다.");
					} else {
						cim.printCustomerInfo(index - 1);
					}
				} else {
					System.out.println("조회한 정보가 없습니다.");
				}
				System.out.println("--------------------------------");
				break;
			case 'N', 'n':
				System.out.println("입력한 고객 다음 고객의 정보를 조회합니다.");
				index = cim.searchInfoByName();
				System.out.println("--------------------------------");
				if (index >= 0) {
					if (index == cim.customerInfoList.size() - 1) {
						System.out.println("다음 고객정보가 없습니다.");
					} else {
						cim.printCustomerInfo(index + 1);
					}
				} else {
					System.out.println("조회한 정보가 없습니다.");
				}
				System.out.println("--------------------------------");
				break;
			case 'U', 'u':
				System.out.println("고객정보를 수정합니다.");
				index = cim.searchInfoByName();
				if (index >= 0) {
					cim.updateCustomerInfo(index);
				} else {
					System.out.println("수정할 정보가 없습니다.");
				}
				break;
			case 'D', 'd':
				System.out.println("고객정보를 삭제합니다.");
				index = cim.searchInfoByName();
				if (index >= 0) {
					cim.deleteCustomerInfo(index);
				} else {
					System.out.println("삭제할 정보가 없습니다.");
				}
				break;
			case 'Q', 'q':
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("잘못 입력하셨습니다.");
				break;
			}	
		}
	}	
}
