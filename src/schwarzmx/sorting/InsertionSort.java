package schwarzmx.sorting;

import schwarzmx.utils.Utils;

public class InsertionSort implements Sort {
	
	public int[] sort(int sequence[]) {
		
		for (int j = 1; j < sequence.length; j++) {
			int key = sequence[j];
			int i = j - 1;
			
			while (i >= 0 && sequence[i] > key) {
				sequence[i + 1] = sequence[i];
				i--;
			}
			
			sequence[i + 1] = key;
		}
		
		return sequence;
	}
}
