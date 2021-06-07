package ClientInfo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public  class JTabbedPaneTest extends JFrame implements ActionListener, WindowListener {
		static JTabbedPane tab;
		static JTable1 j1;
		static JButton btn;
		int cnt = 0;
			    public void setDefaultCloseOperation(int arg0) {
			    	super.setDefaultCloseOperation(EXIT_ON_CLOSE);
			    }
			    public JTabbedPaneTest() {
			        super("고객정보 데이타");			      
			        try {
				        tab = new JTabbedPane(JTabbedPane.RIGHT);
				        JPanel one = new JPanel();
				        JButton btn  = new JButton("파일변환");
				        j1 = new JTable1();
				        
				        one.add(j1);
				        tab.addTab("고객정보", one);
				        this.add(btn, BorderLayout.EAST);
				        getContentPane().add(tab, BorderLayout.CENTER);
				        getContentPane().getBackground().getRGB();
				        getContentPane().getForeground().getBlue();
				        setSize(700, 700);
				        
				        ListSelectionModel model  = j1.table.getSelectionModel();
						btn.addActionListener(this);
				        setVisible(true);
			        }catch(Exception c) {
						System.out.println(c.getMessage());
					}
			    }
			    
			 	@Override
				public void actionPerformed(ActionEvent e) {
			 	 	String selectedData ="";
			 		Object obj = e.getSource();
			 		
			 		j1.table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			 		
				 		try {
					 			File outFile = new File("result.txt");
								boolean isexists = outFile.exists();
								
								if (isexists = false ) {
									outFile.createNewFile();
									}
								FileOutputStream fos = new FileOutputStream(outFile);
								OutputStreamWriter osw = new OutputStreamWriter(fos);
								BufferedWriter bw = new BufferedWriter(osw);
								
		  					    for (int i = 0; i < j1.table.getRowCount(); i++) {
		  					      for (int j = 0; j < j1.table.getColumnCount(); j++) {		  					        
		  					    	  if (j==0) {
		  					    	   selectedData = (String) j1.table.getValueAt(i,j);
		  					    	  } else {
		  					    	   selectedData  = selectedData.trim()+ ","+ (String) j1.table.getValueAt(i,j);
		  					    	   }		  					         
		  					      }
		  					        bw.write(selectedData);
									bw.newLine();
		  					        selectedData ="";
		  					    }
		  					    bw.flush();
								System.out.println("저장되었습니다. 확이하세요");
				      	   } catch(Exception ew) {  ew.getMessage(); System.out.println("에러 발생"); }	      		   
				       }
			 	
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					
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
}
