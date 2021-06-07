package ClientInfo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import ClientInfo.JTable1; 
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Scanner;

public class CustomerHandler extends Exception {
	 private static final int EXIT_ON_CLOSE=0;
	 static Scanner scan = new Scanner(System.in);
	 static ClientManagement  clm = new ClientManagement();
	 static int index = -1;
	 static String str = "";
	 
	 public static void questionView() {
		  	System.out.println("****************************************");
			System.out.println(" 원하는 작업을 선택하세요. : ");
			System.out.println(" (I)Insert, (U)Update, (D)Delete,(S)Search, (A)All_Search,  (P)Prev, (N)Next,\n" + 
							   " (O)오브젝트 작업, (J)오브젝트 다운 , \n " + 
							   " (F)파일업, (R)파일다운, G(Graphics), (Q)Quit ");
		  	System.out.println("******************************************");
		  	
		  	str = scan.next();
		  	str = str.toUpperCase().trim();
		  	
		  	int valueT = ClientManagement.strCheck(str);
		    
		  	if (str.equalsIgnoreCase("Q")) {
		  		valueT = 2;
		  		}
		  	if (valueT == 1) {
		  		System.out.println(" 작업 메뉴에 없는 호출정보입니다. 다시 입력해주세요.");				
		  		questionView();
				}
		  	}
	 
	public static void main(String[] args) throws IOException, Exception {
			while(true) {
				questionView();
				switch(str.charAt(0)){
				case 'O' :
						 clm.uploadObject();
						break;
				case 'J' :
					clm.downloadObject();
						break;
				case 'I' :
						System.out.println(" 고객의 정보를 입력해주세요.");
						clm.saveClientInfo();
						break;
				case 'D' :
						index = clm.searchClientInfoByName();
						if (index >= 0) {
							System.out.printf(" 고객을 삭제하겠습니다. ");
							clm.deleteClientInfo(index);
							System.out.println(" 삭제되었습니다. ");
						}else {
							System.out.println(" 없는 고객정보 입니다.");
						}
							break;
				case 'U' :
						index = clm.searchClientInfoByName();
						if (index >= 0) {
							clm.byflag = true;
							clm.sexflag = true;
							clm.updateClientInfo(index);										  
						}else {
							System.out.println("고객 정보가 없습니다.");
						}
						break;
				case 'S' :
						index = clm.searchClientInfoByName();
						if (index >= 0) {
							clm.printClientInfo(index);
						}else {
							System.out.println("고객정보가 없습니다.");
						}
						break;
				case 'A' :									 
					clm.printAllClientInfo();
						break;
				case 'C' :
						if (index <0) {
							System.out.println(" 현재 고객이 없습니다. ");
						}else {
							clm.printClientInfo(index);
						}
						break;
				case 'P' :
						System.out.println("이전 데이타를 출력합니다.");
						if (index <= 0){
							System.out.println("이전데이타가 존재하지 않습니다.");
						}else {
							index--;
							clm.printClientInfo(index);
						}
						break;
				case 'N':
						System.out.println("다음 고객을 출력합니다.");
						if (index >= ClientManagement.clientinfolist.size()-1) {
							System.out.println("더이상의 고객은 존재하지 않습니다.");
						}else {
							index++;
							clm.printClientInfo(index);											
						}
						break;
				case 'Q' :
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
				case 'G' :
						JTabbedPaneTest jt = new JTabbedPaneTest();
					    jt.setDefaultCloseOperation(EXIT_ON_CLOSE);
					    break;
				case 'F' :
					clm.uploadFile();
					 break;
				case 'R' :
					clm.downloadFile();
					break;
				default :
						questionView();
						break;
						}
				}
			}
	}
