package sorts;
import util.Time;
import util.Util;
import list.Queue;

public class RadixSortLSD {
	
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
		double maxDigits = (Math.log(max)/Math.log(256));
		
		for(int place=0; place <= maxDigits; place++){
			bucketSort(q, place);
        }
	}
	
	public static void bucketSort(Queue q, int place){
		Queue[] buckets = new Queue[256];
		  
		while(!q.isEmpty()){
			int key = (int)q.dequeue();
			int digit = getDigit(key,place);
				  
			if(buckets[digit] == null)
				buckets[digit] = new Queue();
				buckets[digit].enqueue(key);
			}
			for(int i = 0; i < buckets.length; i++){
				if(buckets[i] != null)
				q.append(buckets[i]);
			}
	}
	  
	private static int getDigit(int value, int digitPlace){
		return (value>>8*digitPlace) & 0x000000ff;
	}
}
