package sorts;

import util.Time;
import util.Util;

public class BucketSort{ 
	public static void main(String[] args){	
		int[] list = Util.random(10,10);
		Util.print(list);
		sort(list);
		Util.print(list);
		
		System.out.println();
		for(int i = 1000; i <= 10000000; i*=10){
			System.out.print("Sorting " + i + " Integers: ");
			list = Util.random(i,100);
			Time timer = new Time();
			timer.start();
			sort(list);
			timer.stop();
			timer.print();
		}
	}
	
	static void sort(int[] list){
		//find the min and max
		int min = list[0];
		int max = min;
		for(int i = 0; i < list.length;i++){
			if(list[i] < min) min = list[i];
			else if (list[i] > max) max = list[i];
		}
		
		int[] buckets = new int[max-min+1];
		
		for(int i = 0; i < list.length; i++){
			buckets[list[i]-min]++;
		}
		
		int index = 0;
		for(int i = 0; i < buckets.length; i++){		
			for(int j = 0; j < buckets[i]; j++){
				list[index] = i+min;
				index++;
			}
		}
	}
}