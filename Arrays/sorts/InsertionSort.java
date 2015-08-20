package sorts;

import util.Time;
import util.Util;

public class InsertionSort{ 
	public static void main(String[] args){
		int[] list = Util.random(10,10);
		Util.print(list);
		sort(list);
		Util.print(list);
		
		System.out.println();
		for(int i = 1000; i <= 100000; i*=10){
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
		insertionSort(list,0,list.length-1);
	}
	
	static void insertionSort(int[] list, int low, int high){
		for(int i = low; i < high+1; i++){
			int tmp = list[i];
			int j;
			for(j = i-1; j >= 0 && tmp < list[j]; j--)
				list[j+1] = list[j];
			list[j+1] = tmp;
		}
	}
}