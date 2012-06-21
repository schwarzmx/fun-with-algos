package schwarzmx.inversions;

import schwarzmx.utils.Utils;

public class NumberOfInversions {
	
	private long totalInversions = 0;

	public static void main(String[] args) {
		int sequence[] = Utils.readIntegerArrayFile();
		NumberOfInversions algorithm = new NumberOfInversions();
		sequence = algorithm.sortAndCount(sequence);
		long answer = algorithm.totalInversions;
		
		System.out.println("Total inversions: " + answer);
	}
	
	public int[] sortAndCount(int[] sequence) {
		if (sequence.length <= 1)
			return sequence;
		
		// split in two arrays
		int middle = sequence.length / 2;
		int left[] = new int[middle];
		int right[] = new int[sequence.length - middle];
		
		for (int i = 0; i < middle; i++) {
			left[i] = sequence[i];
		}
		for (int j = 0; j < sequence.length - middle; j++) {
			right[j] = sequence[j + middle];
		}
		
		left = sortAndCount(left);
		right = sortAndCount(right);
		
		return mergeAndCount(left, right);
	}
	
	private int[] mergeAndCount(int left[], int right[]) {
		int sequence[] = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < sequence.length; k++) {
			if (i < left.length && j < right.length) {
				if (left[i] <= right[j])
					sequence[k] = left[i++];
				else if (left[i] > right[j]) {
					sequence[k] = right[j++];
					int rest = left.length - i;
					//System.out.println("rest: " + rest);
					totalInversions += rest;
				}
			} else if (i < left.length) {
				sequence[k] = left[i++];
			} else if (j < right.length) {
				sequence[k] = right[j++];
				
				totalInversions += left.length - i; // should be zero at all times actually
			}
		}
		
		return sequence;
	}
}
