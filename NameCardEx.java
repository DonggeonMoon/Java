//NameCardEx.java

package Customer;

import java.util.Scanner;

public class NameCardEx {

	static Scanner scan = new Scanner(System.in);
	static int index = -1;
	static NameCardManager nc = new NameCardManager();
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("메뉴를 입력하세요.");
			System.out.println("(I)nsert, (S)elect, (U)pdate, (D)elete, (Q)uit");
			String menu = scan.nextLine();
			menu = menu.toLowerCase();
			switch(menu.charAt(0)) {
			case 'i' :
				System.out.println("명함 정보를 입력합니다.");
				nc.insertNameCardInfo();
				break;
			case 's' :
				System.out.println("명함 정보를 조회합니다.");
				index = nc.searchNameCardByName();
				if(index >= 0) {
					nc.printNameCardInfo(index);
				}else {
					System.out.println("조회한 정보가 없습니다.");
				}
				break;
			case 'u' :
				System.out.println("명함 정보를 수정합니다.");
				index = nc.searchNameCardByName();
				if(index >= 0) {
					nc.updateNameCardInfo(index);
				}else {
					System.out.println("수정할 정보가 없습니다.");
				}
				break;
			case 'd' :
				System.out.println("명함 정보를 삭제합니다.");
				index = nc.searchNameCardByName();
				if(index >= 0) {
					nc.deleteNameCardInfo(index);
				}else {
					System.out.println("삭제할 정보가 없습니다.");
				}
				break;
			case 'q' :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("없는 메뉴 입니다.");
				break;
			}
		}
	}

}
