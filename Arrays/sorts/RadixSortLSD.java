package sorts;

import util.Time;
import util.Util;

public class RadixSortLSD{ 
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
		int[] output = input;
		int max = getMax(input);
		int min = getMin(input); //for negative values
		double maxDigits = (Math.log(max-min)/Math.log(16));
		
        for(int place=0; place <= maxDigits; place++){
            output = countingSort(output, place, min);
        }

        Util.copy(input, output);
    }

    private static int[] countingSort(int[] input, int place, int min){
        int[] count = new int[16];

        for(int i=0; i < input.length; i++){
            int digit = getDigit(input[i]-min, place);
            count[digit]++;
        }
        
        int total = 0;
		for(int i = 0; i < count.length; i++){
			int tmp = count[i];
			count[i] = total;
			total = total + tmp;
		}
		
		int[] output = new int[input.length];
		for(int i = 0; i < input.length; i++){	
			int digit = getDigit(input[i]-min, place);
			
			output[count[digit]] = input[i];
			count[digit]++;
		}

        return output;
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
    	return (value>>4*digitPlace) & 0x0000000f;
        //return ((value/digitPlace ) % 16); //slow
    }
}