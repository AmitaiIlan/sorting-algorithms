package sorts;

import util.Time;
import util.Util;

public class RadixSortMSD{ 
	private static final int RADIX = 64; 
	private static final int BITS = 6;
	private static final int MASK = RADIX-1;
	
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
	
	public static void sort(int[] input){
		if(input.length == 0) return;
		int[] output = new int[input.length];
		int max = getMax(input);
		int min = getMin(input);
		int maxDigits = (int)(Math.log(max-min)/Math.log(RADIX));
		if(max-min == 0) maxDigits = 0; //log(0) = undefined
		countingSort(input,output, maxDigits,0,input.length-1,min);
    }

    private static void countingSort(int[] input, int[] output, int place, int low, int high, int min){
        if(high-low < 15){
		InsertionSort.insertionSort(input, low, high);
		return;
        }
    	int[] count = new int[RADIX];

        for(int i=low; i <= high; i++){
            int digit = getDigit(input[i]-min, place);
            count[digit]++;
        }
        
        int total = 0;
		for(int i = 0; i < count.length; i++){
			int tmp = count[i];
			count[i] = total;
			total = total + tmp;
		}
		
		for(int i = low; i <= high; i++){	
			int digit = getDigit(input[i]-min, place);
			
			output[count[digit]] = input[i];
			count[digit]++;
		}
		
		for(int i = low; i <= high; i++){
			input[i] = output[i-low];
		}
		
		if(place == 0) return;

		int low2 = 0; 
		for(int i = 0; i < count.length-1; i++){
			int newlow = low+low2;
			int newhigh = low+count[i]-1;
			if(newlow >= high) return;
			if(newhigh <= newlow) continue;
			countingSort(input,output,place-1,newlow,newhigh,min); 
			low2 = count[i];
		}

    }
    
    private static int getMin(int list[])
    {
        int min = list[0];
        for (int i = 1; i < list.length; i++)
            if (list[i] < min) min = list[i];
        return min;
    }

    
    private static int getMax(int list[])
    {
        int max = list[0];
        for (int i = 1; i < list.length; i++)
            if (list[i] > max) max = list[i];
        return max;
    }

    private static int getDigit(int value, int digitPlace){
    	return (value>>BITS*digitPlace) & MASK;
    }
}
