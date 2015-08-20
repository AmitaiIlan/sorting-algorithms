package sorts;

import util.Time;
import util.Util;

public class HeapSort{ 
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
	
	
	private static int N;
	
	public static void sort(int[] list){
		N = list.length-1; //last node
		buildHeap(list);
		
		for(int i = N; i > 0; i--){
			swap(list, 0,i);
			N--;
			heapify(list,0);
		}
	}
	
	private static void buildHeap(int[] list){
		int start = (N-1)/2; //parent of N
		for(int i = start; i >= 0; i--)
			heapify(list, i);
	}
	
	private static void heapify(int[] list, int i){

		int left = 2*i+1;
		int right = 2*i+2;
		int max = i;
		
		if(left <= N && list[left] > list[i])
			max = left;
		if(right <= N && list[right] > list[max])
			max = right;
		
		if(max != i){
			swap(list, i,max);
			heapify(list, max);
		}
	}

	private static void swap(int[] list, int index1, int index2){
		int temp = list[index1];
		list[index1] = list[index2];
		list[index2] = temp;
	}
}