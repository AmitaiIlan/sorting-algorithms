package sorts;

import util.Time;
import util.Util;

public class CountingSort{ 
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
	
	public static void sort(int[] input){
		//find the min and max
		int min = input[0];
		int max = min;
		for(int i = 0; i < input.length;i++){
			if(input[i] < min) min = input[i];
			else if (input[i] > max) max = input[i];
		}
		
		//count # occurrences
		int[] count = new int[max-min+1];
		for(int i = 0; i < input.length; i++){
			count[input[i]-min]++;
		}
		
		int total = 0;
		for(int i = 0; i < count.length; i++){
			int tmp = count[i];
			count[i] = total;
			total = total + tmp;
		}
		
		int[] output = new int[input.length];
		for(int i = 0; i < input.length; i++){		
			output[count[input[i]-min]] = input[i];
			count[input[i]-min]++;
		}
		
		Util.copy(input, output); //copy the output into the input
	}
}