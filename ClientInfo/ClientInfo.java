package ClientInfo;
import java.io.Serializable; 

public class ClientInfo implements Serializable{
	private String name;//이름
	private String sex;//성별
	private String email;//이메일 주소
	private int birthyear;//태어난 연도
	
	public ClientInfo(String name, String sex, String email, int birthyear){
		super();
		this.name = name;
		this.sex = sex;
		this.email= email;
		this.birthyear = birthyear;
	}

	public ClientInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public String toString() {
			
		String str = "Name = " + name + ", sex= " + sex + ", email = " + email + ", birthday = " + birthyear;
		return str;
	}
}
