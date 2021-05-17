package Day6;

import java.util.Scanner;

public class practice {
	public static void main(String[] args) {
		while (true) {
			System.out.println("이름을 입력하세요");
			Scanner sc1 = new Scanner(System.in);
			String name = sc1.next();
			System.out.println(name + "님 환영합니다.");
			System.out.println("커피를 주문하시겠습니까?(Y/N)");
			Scanner sc2 = new Scanner(System.in);
			char answer = sc2.next().charAt(0);
			while (true) {
				if (answer == 'Y'){
					System.out.println("수량을 입력하세요");
					Scanner sc3 = new Scanner(System.in);
					try {
						int numCups = sc3.nextInt();
						System.out.println(name + "님, 주문하신 커피 " + numCups + "잔 나왔습니다. 다음 손님 들어오세요!" );
						//sc3.close();
						break;
					} catch (Exception e) {
						System.out.println("숫자만 입력하셔야 합니다.("+ e + ")");
						continue;
					}
				} else if(answer == 'N') {
					System.out.println(name + "님, 안녕히 가십시오");
					break;
				} else {
					System.out.println("잘못입력하셨습니다. 'Y' 또는 'N'을 입력해주세요");
					answer = sc2.next().charAt(0);
				}
			}
		}
	}
}
