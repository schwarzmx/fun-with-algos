package schwarzmx.sorting;

import schwarzmx.utils.Utils;

public class RunAlgorithms {

	public static void main(String[] args) {
		int[] sequence = Utils.generateSequence(1100);
		Sort algorithms[] = {new InsertionSort(), new MergeSort()};
		
		for (Sort algorithm : algorithms) {
			System.out.println("Sequence: " + Utils.sequenceToString(sequence));	
			int sortedSequence[] = algorithm.sort(sequence);
			System.out.println("New sequence: " + Utils.sequenceToString(sortedSequence));
		}
	}

}
