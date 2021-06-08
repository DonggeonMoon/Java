package ClientInfo;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class JPanel1 extends JPanel {	 
	JTable table;
	JScrollPane sp;
	
	public JPanel1(){	
    	ClientInfo ccs = new ClientInfo();
        String title[] = {"이름", "성별", "이메일", "생년월일"};
        int count = ClientManagement.clientinfolist.size();
        String data[][] = new String [count][4];
        System.out.println(count);
        if (count <= 0) {
			System.out.println(" 고객정보가 없습니다. ");
		} else {
			for(int i=0; i< count; i++) {
				ccs = ClientManagement.clientinfolist.get(i);
				for (int j=0; j< 4; j++) {
					data[i][0] = ccs.getName();
					data[i][1] = ccs.getSex();
					data[i][2] = ccs.getEmail();
					data[i][3] = String.valueOf(ccs.getBirthyear());
				}
				}
			DefaultTableModel model = new DefaultTableModel(data, title);
			table = new JTable(model);
			sp = new JScrollPane(table);
			this.add(sp);
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcmSchedule = table.getColumnModel();
			for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
	          	 tcmSchedule.getColumn(i).setCellRenderer(tcr);
	          	 tcmSchedule.getColumn(i).setPreferredWidth(10);
			}
		}
	}
}
