package schwarzmx.utils;

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

}
