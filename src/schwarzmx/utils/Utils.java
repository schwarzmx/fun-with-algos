package schwarzmx.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Utils {
	
	public static int[] generateSequence(int size) {
		
		if (size < 1) return null;
		
		int[] sequence = new int[size];
		
		for (int i = 0; i < sequence.length; i ++) { 
			sequence[i] = (int) Math.round(100 * Math.random());
		}
		
		return sequence;
	}
	
	public static String sequenceToString(int sequence[]) {
		String list = "";
		for (int i = 0; i < sequence.length; i++) {
			list += list.equals("") ? sequence[i] + "" : ", " + sequence[i];
		}
		
		return list;
	}
	
	public static int[] readIntegerArrayFile() {
		int list[] = new int[100000];
		try {
			FileInputStream inStream = new FileInputStream("./misc/IntegerArray.txt");
			DataInputStream in = new DataInputStream(inStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			String stdLine;
			int i = 0;
			
			while ((stdLine = br.readLine()) != null) {
				list[i++] = Integer.parseInt(stdLine.trim());
			}
			
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
