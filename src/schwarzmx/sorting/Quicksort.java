package schwarzmx.sorting;

public class Quicksort implements Sort {
	

	public int[] sort(int[] sequence) {
		
		
		quicksort(sequence, 0, sequence.length - 1);
		
		return sequence;
	}
	
	public String name() {
		return "Quicksort";
	}
	
	
	private void quicksort(int[] sequence, int left, int right) {
		
		if (left < right) {
			// choose first element as pivot
			int pivotIndex = left;
			
			pivotIndex = partition(sequence, left, right, pivotIndex);
			
			quicksort(sequence, left, pivotIndex - 1);
			quicksort(sequence, pivotIndex + 1, right);
		}
		
	}
	
	private int partition(int []sequence, int left, int right, int pivotIndex) {
		int newPivotIndex = left;
		int pivotValue = sequence[pivotIndex];
		
		// move pivot to end
		sequence[pivotIndex] = sequence[right];
		sequence[right] = pivotValue;
		
		
		for (int i = left; i < right; i++) {
			if (sequence[i] < pivotValue) {
				int swap = sequence[i];
				sequence[i] = sequence[newPivotIndex];
				sequence[newPivotIndex++] = swap;
			}
		}
		
		// move pivot to end
		pivotValue = sequence[newPivotIndex];
		sequence[newPivotIndex] = sequence[right];
		sequence[right] = pivotValue;
		
		return newPivotIndex;
	}

}
