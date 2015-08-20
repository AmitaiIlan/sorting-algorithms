package sorts;

import util.Time;
import util.Util;

public class MergeSort{ 
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
		int[] tmp = new int[list.length];
		mergeSort(list,tmp,0,list.length-1);
	}
	
	private static void mergeSort(int[] list, int[] tmp, int low, int high){
		if(low < high){
			int middle = (low+high)/2;
			mergeSort(list,tmp, low,middle);
			mergeSort(list,tmp, middle+1,high);
			merge(list,tmp, low,middle,high);
		}
	}
	
	private static void merge(int[] list, int[] tmp, int low, int middleLow, int high){
		for(int i = low; i <= high; i++){
			tmp[i] = list[i];
		}
		
		int i = low;
		int j = middleLow+1;
		int k = low;
		
		while(i <= middleLow && j <= high){
			if(tmp[i] <= tmp[j]){
				list[k] = tmp[i];
				i++;
			} else {
				list[k] = tmp[j];
				j++;
			}
			k++;
		}
		while(i <= middleLow){
			list[k] = tmp[i];
			k++;
			i++;
		}
	}
}