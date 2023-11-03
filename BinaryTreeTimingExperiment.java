package assign08;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;


public class BinaryTreeTimingExperiment {
	public static void main(String[] args) {
		int startN = 10000;
	    int endN = 200000;
	    int stepSize = 10000;

	    System.out.println("N\tSorted Insertion Time (ns) \t Random Insertion Time (ns) \t Sorted Java Tree Insertion Time \t Random Java Tree Insertion Time" );

	    for (int N = startN; N <= endN; N += stepSize) {
	        BinarySearchTree<Integer> sortedBst = new BinarySearchTree<>();
	        BinarySearchTree<Integer> randomBst = new BinarySearchTree<>();
	        TreeSet<Integer> randomTree = new TreeSet<>();
	        TreeSet<Integer> sortedTree = new TreeSet<>();

	        
	        // Generate a random permutation of N unique integers for random insertion
	        int[] randomOrder = generateRandomOrder(N);

	        long startTimeSorted = System.nanoTime();
	        for (int i = 0; i < N; i++) {
	            sortedBst.add(i);
	        }
	        long stopTimeSorted = System.nanoTime();
	        long sortedTime = stopTimeSorted - startTimeSorted;

	        long startTimeRandom = System.nanoTime();
	        for (int i = 0; i < N; i++) {
	            randomBst.add(randomOrder[i]);
	        }
	        long stopTimeRandom = System.nanoTime();
	        long randomTime = stopTimeRandom - startTimeRandom;
	        
	        long startTimeSortedTree = System.nanoTime();
	        for(int i = 0; i < N; i++) {
	        	sortedTree.add(i);
	        }
	        long stopTimeSortedTree = System.nanoTime();
	        long javaSortedTreeTime = stopTimeSortedTree - startTimeSortedTree;
	        
	        long startTimeRandomTree = System.nanoTime();
	        for (int i = 0; i < N; i++) {
	            randomTree.add(randomOrder[i]);
	        }
	        long stopTimeRandomTree = System.nanoTime();
	        long treeRandomTime = stopTimeRandomTree - startTimeRandomTree;

	        System.out.println(N + "\t    " + sortedTime + "\t     " + randomTime + "\t      " + javaSortedTreeTime + "\t     " + treeRandomTime);
	    }
	}

	private static int[] generateRandomOrder(int N) {
	    int[] order = new int[N];
	    for (int i = 0; i < N; i++) {
	        order[i] = i;
	    }

	    Random random = new Random();
	    for (int i = N - 1; i > 0; i--) {
	        int j = random.nextInt(i + 1);
	        int temp = order[i];
	        order[i] = order[j];
	        order[j] = temp;
	    }

	    return order;
	}
}

