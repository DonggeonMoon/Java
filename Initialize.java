import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

class Initialize {
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
			System.out.println(list2);
			
		} catch (IOException ie) {
			System.out.println(ie);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
