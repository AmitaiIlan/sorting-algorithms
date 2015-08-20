import java.util.Arrays;

import sorts.*;
import util.Time;
import util.Util;


public class Test {
	private final static int SIZE = 1000000;
	
	public static void main(String[] args){	
		Time timer = new Time();
		System.out.println("For " + SIZE + " Integers:");
		int[] list0 = Util.random(SIZE,SIZE);
		int[] list1 = Util.copy(list0);
		int[] list2 = Util.copy(list1);
		int[] list3 = Util.copy(list1);
		int[] list4 = Util.copy(list1);
		int[] list5 = Util.copy(list1);
		
		System.out.print("RadixSort(LSD): ");
		timer.start();
		RadixSortLSD.sort(list0);
		timer.stop();
		timer.print();
		
		System.out.print("RadixSort(MSD): ");
		timer.start();
		RadixSortMSD.sort(list1);
		timer.stop();
		timer.print();
		
		System.out.print("QuickSort: ");
		timer.start();
		QuickSort.sort(list2);
		timer.stop();
		timer.print();
		
		System.out.print("MergeSort: ");
		timer.start();
		MergeSort.sort(list3);
		timer.stop();
		timer.print();
		
		System.out.print("HeapSort: ");
		timer.start();
		HeapSort.sort(list4);
		timer.stop();
		timer.print();
		
		System.out.print("JavaSort: ");
		timer.start();
		Arrays.sort(list5);
		timer.stop();
		timer.print();
	}
}
