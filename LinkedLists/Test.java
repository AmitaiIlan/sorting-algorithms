import sorts.MergeSort;
import sorts.QuickSort;
import sorts.RadixSortLSD;
import sorts.RadixSortMSD;
import util.Time;
import util.Util;
import list.*;

public class Test {

	private final static int SIZE = 100000;

	public static void main(String [] args) {
		Queue q;
		System.out.println("For " + SIZE + " Integers:");
		Time timer = new Time();
		q = Util.randomList(SIZE);
		timer.start();
		RadixSortLSD.sort(q,SIZE);
		timer.stop();
		System.out.print("RadixSort(LSD): ");
		timer.print();
    
		q = Util.randomList(SIZE);
		timer.start();
		RadixSortMSD.sort(q,SIZE);
		timer.stop();
		System.out.print("RadixSort(MSD): ");
		timer.print();
		
		q = Util.randomList(SIZE);
		timer.start();
		QuickSort.sort(q);
		timer.stop();
		System.out.print("Quicksort: ");
		timer.print();
		
		q = Util.randomList(SIZE);
		timer.start();
		MergeSort.sort(q);
		timer.stop();
		System.out.print("Mergesort: ");
		timer.print();
    
	}

}
