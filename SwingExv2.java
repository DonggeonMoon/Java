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

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class SwingEx extends JFrame implements ActionListener, WindowListener {
	
	JTabbedPane jtp;
	Tab1 tab1;
	Tab2 tab2;
	Tab3 tab3;
	Tab4 tab4;
	JButton jb1, jb2, jb3, jb4;
	JTextField jtf11, jtf12, jtf13, jtf14, jtf21, jtf22, jtf23, jtf24, jtf31, jtf32, jtf33, jtf34, jtf41, jtf42, jtf43, jtf44;
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
		jb2.addActionListener(hd2);
		jb3.addActionListener(hd3);
		jb4.addActionListener(hd4);
		
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
			searchAndSet(jtf11, jt1);
		}
		
	}
	
	public class Handler2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			searchAndSet(jtf21, jt2);
		}
	}
	
	public class Handler3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			searchAndSet(jtf31, jt3);
		}
	}
	
	public class Handler4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			searchAndSet(jtf41, jt4);
		}
		
	}
	
	public class Tab1 extends JPanel {
		public Tab1() {
			setLayout(null);
			JLabel jl1 = new JLabel("이름");
			jtf11 = new JTextField(10);
			jb1 = new JButton("확인");
			jt1 = new JTable(20, 4);
			
			jl1.setLocation(200, 20);
			jl1.setSize(100, 30);
			jtf11.setLocation(260, 20);
			jtf11.setSize(100, 30);
			jb1.setLocation(380, 20);
			jb1.setSize(100, 30);
			
			jt1.setLocation(20, 70);
			jt1.setSize(600, 320);
			
			add(jl1);
			add(jtf11);
			add(jb1);
			add(jt1);
		}
	}
	public class Tab2 extends JPanel {
		public Tab2() {
			setLayout(null);
			JLabel jl21 = new JLabel("이름");
			jtf21 = new JTextField(10);
			JLabel jl22 = new JLabel("성별");
			jtf22 = new JTextField(10);
			JLabel jl23 = new JLabel("이메일");
			jtf23 = new JTextField(10);
			JLabel jl24 = new JLabel("성별");
			jtf24 = new JTextField(10);
			jb2 = new JButton("확인");
			jt2 = new JTable(20, 4);
			
			jl21.setLocation(20, 20);
			jl21.setSize(100, 30);
			jtf21.setLocation(50, 20);
			jtf21.setSize(70, 30);
			
			jl22.setLocation(125, 20);
			jl22.setSize(100, 30);
			jtf22.setLocation(155, 20);
			jtf22.setSize(70, 30);
			
			jl23.setLocation(230, 20);
			jl23.setSize(100, 30);
			jtf23.setLocation(270, 20);
			jtf23.setSize(100, 30);
			
			jl24.setLocation(375, 20);
			jl24.setSize(100, 30);
			jtf24.setLocation(405, 20);
			jtf24.setSize(70, 30);
			
			jb2.setLocation(520, 20);
			jb2.setSize(100, 30);
			
			jt2.setLocation(20, 70);
			jt2.setSize(600, 320);
			
			add(jl21);
			add(jtf21);
			add(jl22);
			add(jtf22);
			add(jl23);
			add(jtf23);
			add(jl24);
			add(jtf24);
			add(jb2);
			add(jt2);
		}
	}
	
	public class Tab3 extends JPanel {
		public Tab3() {
			setLayout(null);
			JLabel jl31 = new JLabel("이름");
			jtf31 = new JTextField(10);
			JLabel jl32 = new JLabel("성별");
			jtf32 = new JTextField(10);
			JLabel jl33 = new JLabel("이메일");
			jtf33 = new JTextField(10);
			JLabel jl34 = new JLabel("성별");
			jtf34 = new JTextField(10);
			jb3 = new JButton("확인");
			jt3 = new JTable(20, 4);
			
			jl31.setLocation(20, 20);
			jl31.setSize(100, 30);
			jtf31.setLocation(50, 20);
			jtf31.setSize(70, 30);
			
			jl32.setLocation(125, 20);
			jl32.setSize(100, 30);
			jtf32.setLocation(155, 20);
			jtf32.setSize(70, 30);
			
			jl33.setLocation(230, 20);
			jl33.setSize(100, 30);
			jtf33.setLocation(270, 20);
			jtf33.setSize(100, 30);
			
			jl34.setLocation(375, 20);
			jl34.setSize(100, 30);
			jtf34.setLocation(405, 20);
			jtf34.setSize(70, 30);
			
			jb3.setLocation(520, 20);
			jb3.setSize(100, 30);
			
			jt3.setLocation(20, 70);
			jt3.setSize(600, 320);
			
			add(jl31);
			add(jtf31);
			add(jl32);
			add(jtf32);
			add(jl33);
			add(jtf33);
			add(jl34);
			add(jtf34);
			add(jb3);
			add(jt3);
		}
	}
	
	public class Tab4 extends JPanel {
		public Tab4() {
			setLayout(null);
			JLabel jl41 = new JLabel("이름");
			jtf41 = new JTextField(10);
			jb4 = new JButton("확인");
			jt4 = new JTable(20, 4);
			
			jl41.setLocation(200, 20);
			jl41.setSize(100, 30);
			jtf41.setLocation(260, 20);
			jtf41.setSize(100, 30);
			jb4.setLocation(380, 20);
			jb4.setSize(100, 30);
			
			jt4.setLocation(20, 70);
			jt4.setSize(600, 320);
			
			add(jl41);
			add(jtf41);
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
	
	public void searchAndSet(JTextField jtf, JTable jt) {
		System.out.println("버튼 눌림");
		String query = jtf.getText();
		cim.customerInfoList.get(0);
		String[][] contents;
		int n = 0;
		for (int i=0; i<cim.customerInfoList.size();i++) {
			if(cim.customerInfoList.get(i).getName().equals(query)) {
				jt.setValueAt(cim.customerInfoList.get(i).getName().toString(), n, 0);
				jt.setValueAt(cim.customerInfoList.get(i).getGender(), n, 1);
				jt.setValueAt(cim.customerInfoList.get(i).getEmail().toString(), n, 2);
				jt.setValueAt(cim.customerInfoList.get(i).getBirthYear(), n, 3);
				n++;
			}
		}
	}
}
