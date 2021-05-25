//NameCardManager.java

package Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class NameCardManager {

	static ArrayList<NameCard> nameCardList = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
		
	public static void deleteNameCardInfo(int idx) {
		nameCardList.remove(idx);
	}

	public static void updateNameCardInfo(int idx) {
		System.out.println("명함 정보를 수정합니다......");
		NameCard nameCard = nameCardList.get(idx);
		System.out.printf("회사이름(%s)", nameCard.getOfficeName());
		String officeName = scan.nextLine().trim();
		if(officeName != null && officeName.length()>=0) {
			nameCard.setOfficeName(officeName);
		}
		System.out.printf("직무(%s)", nameCard.getJob());
		String job = scan.nextLine().trim();
		if(job != null && job.length() >= 0) {
			nameCard.setJob(job);
		}
		System.out.printf("전화번호(%s)", nameCard.getPhone());
		String phone = scan.nextLine().trim();
		if(phone != null && phone.length() >= 0) {
			nameCard.setPhone(phone);
		}
		System.out.printf("회사전화번호(%s)", nameCard.getOfficePhone());
		String officePhone = scan.nextLine().trim();
		if(officePhone != null && officePhone.length() >= 0) {
			nameCard.setOfficePhone(officePhone);
		}
		System.out.printf("이메일(%s)", nameCard.getEmail());
		String email = scan.nextLine().trim();
		if(email != null && email.length() >= 0) {
			nameCard.setEmail(email);
		}
	}
	
	public static int searchNameCardByName() {
		System.out.print("이름을 입력하세요 : ");
		String name = scan.nextLine().trim();
		for(int i=0; i<nameCardList.size(); i++) {
			if(nameCardList.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public static void insertNameCardInfo() {
		NameCard nameCard = new NameCard();			
		System.out.print("이름: ");	
		nameCard.setName(scan.nextLine().trim());
		System.out.print("회사명: ");		
		nameCard.setOfficeName(scan.nextLine().trim());
		System.out.print("직무: ");			
		nameCard.setJob(scan.nextLine().trim());
		System.out.print("전화번호: ");		
		nameCard.setPhone(scan.nextLine().trim());
		System.out.print("회사전화번호: ");
		nameCard.setOfficePhone(scan.nextLine().trim());
		System.out.print("이메일주소: ");	
		nameCard.setEmail(scan.nextLine().trim());
		nameCardList.add(nameCard);
		printNameCardInfo(nameCardList.size()-1);
	}
	public static void printNameCardInfo(int idx) {
		NameCard nameCard = nameCardList.get(idx);
		System.out.printf("이름: %s, 회사명: %s, 직무: %s, \n전화: %s, 회사전화: %s, 이메일: %s\n", 
				nameCard.getName(), nameCard.getOfficeName(), 
				nameCard.getJob(), nameCard.getPhone(), 
				nameCard.getOfficePhone(), nameCard.getEmail());
	}
}
