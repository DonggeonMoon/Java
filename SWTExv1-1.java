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
	JButton jb1, jb2, jb3, jb4;
	JTextField jtf1, jtf2, jtf3, jtf4;
	JTable jt1, jt2, jt3, jt4;
	
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
		Handler2 hd2 = new Handler2();
		jb1.addActionListener(hd1);
		Handler3 hd3 = new Handler3();
		jb1.addActionListener(hd1);
		Handler4 hd4 = new Handler4();
		jb1.addActionListener(hd1);
		jb1.addActionListener(hd2);
		jb1.addActionListener(hd3);
		jb1.addActionListener(hd4);
		
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
	
	public class Handler2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class Handler3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class Handler4 implements ActionListener {

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
			setLayout(null);
			JLabel jl21 = new JLabel("이름");
			jtf1 = new JTextField(10);
			JLabel jl22 = new JLabel("성별");
			jtf2 = new JTextField(10);
			JLabel jl23 = new JLabel("이메일");
			jtf3 = new JTextField(10);
			JLabel jl24 = new JLabel("성별");
			jtf4 = new JTextField(10);
			jb2 = new JButton("확인");
			jt2 = new JTable(20, 4);
			
			jl2.setLocation(20, 20);
			jl2.setSize(100, 30);
			jtf1.setLocation(50, 20);
			jtf1.setSize(70, 30);
			
			jl3.setLocation(125, 20);
			jl3.setSize(100, 30);
			jtf2.setLocation(155, 20);
			jtf2.setSize(70, 30);
			
			jl4.setLocation(230, 20);
			jl4.setSize(100, 30);
			jtf3.setLocation(270, 20);
			jtf3.setSize(100, 30);
			
			jl5.setLocation(375, 20);
			jl5.setSize(100, 30);
			jtf4.setLocation(405, 20);
			jtf4.setSize(70, 30);
			
			jb2.setLocation(520, 20);
			jb2.setSize(100, 30);
			
			jt1.setLocation(20, 70);
			jt1.setSize(600, 320);
			
			add(jl1);
			add(jtf1);
			add(jl2);
			add(jtf2);
			add(jl3);
			add(jtf3);
			add(jl4);
			add(jtf4);
			add(jb1);
			add(jt1);
		}
	}
	
	public class Tab3 extends JPanel {
		public Tab3() {
			setLayout(null);
			JLabel jl1 = new JLabel("이름");
			jtf1 = new JTextField(10);
			JLabel jl2 = new JLabel("성별");
			jtf2 = new JTextField(10);
			JLabel jl3 = new JLabel("이메일");
			jtf3 = new JTextField(10);
			JLabel jl4 = new JLabel("성별");
			jtf4 = new JTextField(10);
			jb3 = new JButton("확인");
			jt3 = new JTable(20, 4);
			
			jl1.setLocation(20, 20);
			jl1.setSize(100, 30);
			jtf1.setLocation(50, 20);
			jtf1.setSize(70, 30);
			
			jl2.setLocation(125, 20);
			jl2.setSize(100, 30);
			jtf2.setLocation(155, 20);
			jtf2.setSize(70, 30);
			
			jl3.setLocation(230, 20);
			jl3.setSize(100, 30);
			jtf3.setLocation(270, 20);
			jtf3.setSize(100, 30);
			
			jl4.setLocation(375, 20);
			jl4.setSize(100, 30);
			jtf4.setLocation(405, 20);
			jtf4.setSize(70, 30);
			
			jb3.setLocation(520, 20);
			jb3.setSize(100, 30);
			
			jt3.setLocation(20, 70);
			jt3.setSize(600, 320);
			
			add(jl1);
			add(jtf1);
			add(jl2);
			add(jtf2);
			add(jl3);
			add(jtf3);
			add(jl4);
			add(jtf4);
			add(jb3);
			add(jt3);
		}
	}
	
	public class Tab4 extends JPanel {
		public Tab4() {
			setLayout(null);
			JLabel jl1 = new JLabel("이름");
			jtf1 = new JTextField(10);
			jb1 = new JButton("확인");
			jt1 = new JTable(20, 4);
			
			jl1.setLocation(200, 20);
			jl1.setSize(100, 30);
			jtf1.setLocation(260, 20);
			jtf1.setSize(100, 30);
			jb4.setLocation(380, 20);
			jb4.setSize(100, 30);
			
			jt4.setLocation(20, 70);
			jt4.setSize(600, 320);
			
			add(jl1);
			add(jtf1);
			add(jb4);
			add(jt4);
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
