package cms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
	
	public static void main(String[] args) throws IOException, Exception {
		/*
		File file = new File(System.getenv("USERPROFILE")+"\\Desktop\\result.txt");
		if(file.exists()) {
			FileReader fr = new FileReader(file);
			
			System.out.println(System.getenv("USERPROFILE")+"\\Desktop\\result.txt");
			BufferedReader br = new BufferedReader(fr);
			String s;
			while((s=br.readLine())!=null) {
				System.out.println(s);
				String[] data = s.split(",");
				CustomerInfo newci = new CustomerInfo();
				newci.setName(data[0].trim());
				newci.setGender(data[1].trim().charAt(0));
				newci.setEmail(data[2].trim());
				newci.setBirthYear(Integer.parseInt(data[3].trim()));
				
				cim.customerInfoList.add(newci);			
			}
			br.close();
		}
		*/
		File file2 = new File(System.getenv("USERPROFILE")+"\\Desktop\\result2.txt");
		if(file2.exists()) {
			System.out.println(System.getenv("USERPROFILE")+"\\Desktop\\result2.txt");
			FileInputStream fis = new FileInputStream(file2);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			cim.customerInfoList = (ArrayList) ois.readObject();
		}
		while(true) {
			char menu = questionView();
			switch (menu) {
			case 'I':
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
			case 'P':
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
			case 'N':
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
			case 'U':
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
			case 'D':
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
			case 'Q':
				System.out.println("프로그램을 종료합니다.");
				try {
					/*
					ArrayList<CustomerInfo> al = cim.customerInfoList;
					System.out.println(al.size());
					
					FileWriter fw = new FileWriter(new File(System.getenv("USERPROFILE")+"\\Desktop\\result.txt"));
					BufferedWriter bw = new BufferedWriter(fw);
					
					for (int i=0;i<al.size();i++) {
						bw.write(al.get(i).getName()+","+al.get(i).getGender()+","+al.get(i).getEmail()+","+al.get(i).getBirthYear()+"\r\n");
					}
					bw.flush();
					bw.close();
					*/
					
					FileOutputStream fos = new FileOutputStream(new File(System.getenv("USERPROFILE")+"\\Desktop\\result2.txt"));
					ObjectOutputStream oos = new ObjectOutputStream(fos);					
					
					oos.writeObject(cim.customerInfoList);
					
					fos.flush();
					fos.close();
					oos.close();
				} catch(Exception e) {
					System.exit(-1);
				}
				System.exit(0);
				break;
			case 'A':
				cim.allPrintClientInfo();
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}	
}
