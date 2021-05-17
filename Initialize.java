package Day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class practice {
	public static void main(String[] args) {		
		try {
			BufferedReader br = new BufferedReader(new FileReader("data.txt"));
			String line = null;
			
			ArrayList list2 = new ArrayList();
			while((line = br.readLine()) != null ){
				String[] s = line.split("\t");
				int i;
				ArrayList list = new ArrayList();
				for (i=0; i<s.length; i++) {
					list.add(s[i]);
				}
				list2.add(list);
			}
			br.close();
			for (int i = 0; i<list2.size(); i++) {
				System.out.println(list2.get(i));
			}
			
		} catch (IOException ie) {
			System.out.println(ie);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
