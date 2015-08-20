package sorts;

import util.Time;
import util.Util;

public class QuickSort{ 
	public static void main(String[] args){	
		int[] list = Util.random(10,10);
		Util.print(list);
		sort(list);
		Util.print(list);
		
		System.out.println();
		for(int i = 1000; i <= 10000000; i*=10){
			System.out.print("Sorting " + i + " Integers: ");
			list = Util.random(i,i);
			Time timer = new Time();
			timer.start();
			sort(list);
			timer.stop();
			timer.print();
		}
		
	}
	
	public static void sort(int[] list){
		
		quickSort(list,0,list.length-1);
	}

	private static void quickSort(int[] list, int low, int high){
		if(low >= high) return;
		
		int v = (int) ((high-low) * Math.random())+low; //choose pivot
		
		//swap
		int pivot = list[v];
		list[v] = list[high];
		list[high] = pivot;
		
		int i = low-1;
		int j = high;
		do {
			do { i++; } while(list[i] < pivot);
			do { j--; } while(j > low && list[j] > pivot);
			if(i < j) swap(list,i,j);
		} while(i < j);
		
		list[high] = list[i];
		list[i] = pivot;
		
		quickSort(list, low, i-1);
		quickSort(list, i+1, high);
	}
	
	private static void swap(int[] list, int index1, int index2){
		int temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}
}