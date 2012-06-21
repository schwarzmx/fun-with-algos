package schwarzmx.sorting;

import schwarzmx.utils.Utils;

public class MergeSort implements Sort {
	
	public int[] sort(int[] sequence) {
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
		
		left = sort(left);
		right = sort(right);
		
		return merge(left, right);
	}
	
	private int[] merge(int left[], int right[]) {
		int sequence[] = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < sequence.length; k++) {
			if (i < left.length && j < right.length) {
				if (left[i] <= right[j])
					sequence[k] = left[i++];
				else if (left[i] > right[j])
					sequence[k] = right[j++];
			} else if (i < left.length) {
				sequence[k] = left[i++];
			} else if (j < right.length) {
				sequence[k] = right[j++];
			}
		}
		
		return sequence;
	}

}
