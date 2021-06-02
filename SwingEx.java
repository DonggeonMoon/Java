package cms;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SwingEx extends JFrame implements ActionListener, WindowListener {
	
	JTabbedPane jtp;
	Tab1 tab1;
	Tab2 tab2;
	Tab3 tab3;
	Tab4 tab4;
	JButton jb1;
	JTextField jtf1;
	JTable jt1;
	
	static Scanner sc = new Scanner(System.in);
	static int index = -1;
	static CustomerInfoManager cim = new CustomerInfoManager();
	
	SwingEx(String title){
		super(title);
		setLocation(400, 0);
		setSize(660, 500);
		setVisible(true);
		setLayout(new BorderLayout());
		this.addWindowListener(this);
		
		jtp = new JTabbedPane();
		tab1 = new Tab1();
		tab2 = new Tab2();
		tab3 = new Tab3();
		tab4 = new Tab4();
		
		jtp.addTab("조회", tab1);
		jtp.addTab("추가", tab2);
		jtp.addTab("갱신", tab3);
		jtp.addTab("삭제" , tab4);
		add(jtp);
		
		Handler1 hd1 = new Handler1();
		jb1.addActionListener(hd1);
		
		revalidate();
	}
	public static void main(String[] args) throws Exception {
		
		File file2 = new File(System.getenv("USERPROFILE")+"\\Desktop\\result2.txt");
		if(file2.exists()) {
			System.out.println(System.getenv("USERPROFILE")+"\\Desktop\\result2.txt");
			FileInputStream fis = new FileInputStream(file2);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			cim.customerInfoList = (ArrayList) ois.readObject();
		}
		
		new SwingEx("고객 관리 시스템");
	}
	
	public class Handler1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼 눌림");
			String query = jtf1.getText();
			cim.customerInfoList.get(0);
			String[][] contents;
			int n = 0;
			for (int i=0; i<cim.customerInfoList.size();i++) {
				if(cim.customerInfoList.get(i).getName().equals(query)) {
					jt1.setValueAt(cim.customerInfoList.get(i).getName().toString(), n, 0);
					jt1.setValueAt(cim.customerInfoList.get(i).getGender(), n, 1);
					jt1.setValueAt(cim.customerInfoList.get(i).getEmail().toString(), n, 2);
					jt1.setValueAt(cim.customerInfoList.get(i).getBirthYear(), n, 3);
					n++;
				}
			}
			
		}
		
	}
	
	public class Tab1 extends JPanel {
		public Tab1() {
			setLayout(null);
			JLabel jl1 = new JLabel("이름");
			jtf1 = new JTextField(10);
			jb1 = new JButton("확인");
			jt1 = new JTable(20, 4);
			
			jl1.setLocation(200, 20);
			jl1.setSize(100, 30);
			jtf1.setLocation(260, 20);
			jtf1.setSize(100, 30);
			jb1.setLocation(380, 20);
			jb1.setSize(100, 30);
			
			jt1.setLocation(20, 70);
			jt1.setSize(600, 320);
			
			add(jl1);
			add(jtf1);
			add(jb1);
			add(jt1);
		}
	}
	public class Tab2 extends JPanel {
		public Tab2() {
			setLayout(new GridBagLayout());
			JLabel jl1 = new JLabel("이름");
			JTextField jtf1 = new JTextField(10);
			JButton jb1 = new JButton("확인");
			JTable jt1 = new JTable(10, 4);
			
			add(jl1);
			add(jtf1);
			add(jb1);
			add(jt1);
		}
	}
	
	public class Tab3 extends JPanel {
		public Tab3() {
			setLayout(new GridBagLayout());
			JLabel jl1 = new JLabel("이름");
			JTextField jtf1 = new JTextField(10);
			JButton jb1 = new JButton("확인");
			JTable jt1 = new JTable(10, 4);
			
			add(jl1);
			add(jtf1);
			add(jb1);
			add(jt1);
		}
	}
	
	public class Tab4 extends JPanel {
		public Tab4() {
			setLayout(new GridBagLayout());
			JLabel jl1 = new JLabel("이름");
			JTextField jtf1 = new JTextField(10);
			JButton jb1 = new JButton("확인");
			JTable jt1 = new JTable(10, 4);
			
			add(jl1);
			add(jtf1);
			add(jb1);
			add(jt1);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
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
		} catch(Exception ex) {
			System.exit(-1);
		}
		System.exit(0);
	}
	@Override
	public void windowClosed(WindowEvent e) {
		
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
