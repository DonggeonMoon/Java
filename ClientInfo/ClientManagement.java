package ClientInfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientManagement implements Serializable {
	static ArrayList<ClientInfo> clientinfolist = new ArrayList<ClientInfo>();//새로운 ArrayList 객체 clientinfolist 선언 및 생성
	static Scanner scan = new Scanner(System.in);
	static boolean sexflag = false;
	static boolean emailflag = false;
	
	public static void saveClientInfo() {
		ClientInfo clfo = new ClientInfo();
		System.out.print("이름: ");
		clfo.setName(scan.nextLine().trim());
		
		sexflag = true;
		while(sexflag) {
			System.out.print("성별 (M, F)로 표기합니다.");
			String sex = scan.nextLine().trim();
			if(sex.length() <= 0 || sex == null)//길이가 0 이하이거나 null이면 다시 입력
				sexflag = true;
			if(sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F")) {// 성별이 'M' 또는 'F'가 아니면 다시 입력
				clfo.setSex(sex);
				sexflag = false;
			} else {
				sexflag = true;
			}
		}
		
		System.out.print("이메일: ");	
		clfo.setEmail(scan.nextLine().trim());
		
		emailflag = true;
		while (emailflag) {
			System.out.print("숫자로 생년을 입력해주세요: ");
			
			String birthyear = scan.nextLine().trim();			
			int select1 = intReturn(birthyear );
			
			clfo.setBirthyear(select1);
			}
		
		clientinfolist.add(clfo);
		printClientInfo(clientinfolist.size()-1)	;
	}	
	
	public static void printClientInfo(int idx) {		 
		ClientInfo cls = clientinfolist.get(idx);
		
		System.out.println("*****************************************");
		System.out.println(" 이름은 : " + cls.getName());
		System.out.println(" 성별 : " + cls.getSex());
		System.out.println(" 이메일 : " + cls.getEmail());
		System.out.println(" 출생년도 : " + cls.getBirthyear());
		System.out.println("*****************************************");
		
	}
	
	public static void printAllClientInfo() {		
		int count = clientinfolist.size();
		ClientInfo ccs ;		
		if (count <= 0 ) {
				System.out.println("회원정보가 없습니다.");
		
			} else {
						for(int i=0;i< count ;i++) {
							ccs = clientinfolist.get(i);
							
							System.out.println("*****************************************");
							System.out.println(" 이름은 : " + clientinfolist.get(i).getName() );
							System.out.println(" 성별 : " + clientinfolist.get(i).getSex());
							System.out.println(" 이메일 : " +clientinfolist.get(i).getEmail());
							System.out.println(" 출생년도 : " + clientinfolist.get(i).getBirthyear());							
							System.out.println("*****************************************");
					}
			}
	}
	
	public static void deleteClientInfo(int idx) {
		clientinfolist.remove(idx);
	}
	
	
	public static int searchClientInfoByName() {
		
		System.out.print("이름을 입력하세요 : ");
		String name = scan.nextLine().trim();
		
		for(int i=0;i< clientinfolist.size();i++) {
			if(clientinfolist.get(i).getName().equals(name)) {
				return i;			
			}
		}
		return -1;
	}
	public static int strChak(String val) {
		String str1 = "";
				
		if (val.length() < 0 || val.length() > 1) {
			return 1;
		}else if(val.length() == 1) {
				 String arrString= "I,A,C,S,P,N,Q,D,U,G,F,R,O,J";
				 String[] arradd = arrString.split(",");
				
				
				for(int i =0;i<arradd.length;i++) {
						str1 = arradd[i];						
						if (val.equalsIgnoreCase(str1)) { 
							return 2;							 
						} 
				} 
				return 1;
	
		}
		return 1;		 
	}
	
	public static void updateClientInfo(int idx) {
		
			System.out.println(" 고객정보를 수정합니다........");
			ClientInfo cms = clientinfolist.get(idx);
			
			System.out.printf(" 이름 (%s) : " , cms.getName());
		 	String name = scan.nextLine().trim();
			if(name != null && name.length()>=0) { 		 
				cms.setName(name);					 
			}
			
			System.out.printf(" 성별 (%s) :", cms.getSex());
			
			
			while(sexflag) {
				System.out.print("성별 (M,F)로 표기합니다.");
				String sex = scan.nextLine().trim();
				
				 	if (sex.length() <= 0 || sex == null) sexflag = true ;
				 
					if (sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F") ) {	cms.setSex(sex );sexflag = false;}
					else {sexflag = true;}
			}
			
			System.out.printf(" 이메일 (%s) :" , cms.getEmail());
			String email = scan.nextLine().trim();
			if(email != null && email.length()>=0) { 		 
				cms.setEmail(email);					 
			}
			
			System.out.printf(" 출생년도(%d) : " , cms.getBirthyear() );
			System.out.println();
			
			while (emailflag) {
				System.out.println("숫자로 입력해주세요 : ");
				String select = scan.nextLine().trim();					
				int select1 = intReturn(select );					 	 
				cms.setBirthyear(select1);
				 
			}
			
			printClientInfo(clientinfolist.size()-1);
	}

	public static int intReturn(String str) {
		int selec = 0;
	
		try {
				selec = Integer.parseInt(str);
				emailflag = false;
		} catch (NumberFormatException e) {
			emailflag = true;
			return 0;
		}
		return selec;
	}
	
		public static void downloadFile() {
			try {

				File file = new File("result.txt");
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				clientinfolist.clear();
				String line ="";
				while ((line = br.readLine())!=null) { 
					ClientInfo clfo = new ClientInfo();
					 String[] arr = line.toString().trim().split(",") ;
					 clfo.setName(arr[0]);
					 clfo.setSex(arr[1] );
					 clfo.setEmail(arr[2]);
					 Integer a = new Integer(arr[3]);
					 clfo.setBirthyear(a);
					 clientinfolist.add(clfo);
					 System.out.println(line.toString());
				}	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void uploadFile () {
			 		try {
						
												
						File outFile = new File("result.txt");//해당파일이 있느지 없느지를 확인해보자 new File("C:/javawork/result.txt")
						boolean isexists = outFile.exists();
								 
						if (isexists = false ) { outFile.createNewFile();}					 
						 
						FileOutputStream fos = new FileOutputStream(outFile);//선택된 파일에 쓰기 위해서 파일을 열고
						OutputStreamWriter osw = new OutputStreamWriter(fos);//선택된 파일에 스트림으로 열어서 통로를 만들고 
						BufferedWriter bw = new BufferedWriter(osw);		//버퍼에 실어서 작성하기 위해 
						 
					for(int i = 0;i < clientinfolist.size();i++) {
						String str = clientinfolist.get(i).getName() + "," + clientinfolist.get(i).getSex() + "," + 
								clientinfolist.get(i).getEmail() + "," + clientinfolist.get(i).getBirthyear();
						
							bw.write(str);//버퍼에 string을 넣는다. 
							bw.newLine();
						}
						bw.flush();//이걸 해주지 않으면 실제 쓰여지지 않는다. 버퍼에만 썼기 때문에 //버퍼에 써준다.
						System.out.println("저장되었습니다. 확이하세요");
						
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("에러 발생");
					}
		}
		
		public static <Clientinfo> void downloadObject() throws Exception {
			File infile = new File("result.bin");//현재 위치에 저장된 바이너리 파일 불러오기
			if (infile.exists()) {
				FileInputStream fis = new FileInputStream(infile);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				clientinfolist = (ArrayList<ClientInfo>)ois.readObject();
				ois.close();
				System.out.println("리스트에 저장완료");
			 	System.out.println(clientinfolist.size());
				for (int i = 0;i < clientinfolist.size();i++) {
						String str = clientinfolist.get(i).getName() + "," + clientinfolist.get(i).getSex() + "," + 
									clientinfolist.get(i).getEmail() + "," + clientinfolist.get(i).getBirthyear();
					System.out.println(str);
				}
			} else {
				System.out.println("바이너리 파일이 존재하지 않습니다.");
			}
		}
		
		public static void uploadObject() throws Exception {
			 File outFile = new File("result.bin");//바이너리 파일로 현재 위치에 저장
			 FileOutputStream fos = new FileOutputStream(outFile);
			 ObjectOutputStream oos = new ObjectOutputStream(fos);
			 
			 oos.writeObject(clientinfolist);
			 oos.close();
			 System.out.println("저장되었습니다. 확인하세요");
		}
}
