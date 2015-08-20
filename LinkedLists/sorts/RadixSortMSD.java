package sorts;
import util.Time;
import util.Util;
import list.Queue;

public class RadixSortMSD {
	private static final int RADIX = 64; 
	private static final int BITS = 6;
	private static final int MASK = RADIX-1;
	
	
	public static void main(String[] args){
		int n = 10;
		Queue q = Util.randomList(n);
		System.out.println(q.toString());
		sort(q,n);
	    System.out.println(q.toString());
	    
	    System.out.println();
	    for(int i = 1000; i <= 1000000; i*=10){
		    Time timer = new Time();
		    q = Util.randomList(i);
		    timer.start();
		    sort(q,i);
		    timer.stop();
		    System.out.print("Sorting " + i + " Integers: ");
		    timer.print();
	    }
	}
	
	
	public static void sort(Queue q, int max){
		int maxDigits = (int)(Math.log(max)/Math.log(RADIX));
		if(max == 0) maxDigits = 0; //log(0) = undefined
		bucketSort(q, maxDigits);
	}
	
	public static void bucketSort(Queue q, int place){
		if(place  < 0) return;
		  
		Queue[] buckets = new Queue[RADIX];
		while(!q.isEmpty()){
			int key = (int)q.dequeue();
			int digit = getDigit(key,place);
				  
			if(buckets[digit] == null)
				buckets[digit] = new Queue();
				buckets[digit].enqueue(key);
			}
		for(int i = 0; i < buckets.length; i++){
			if(buckets[i] != null){
				bucketSort(buckets[i],place-1);
				q.append(buckets[i]);
			}
		}
	}
	  
	private static int getDigit(int value, int digitPlace){
	   return (value>>BITS*digitPlace) & MASK;
	}
}
