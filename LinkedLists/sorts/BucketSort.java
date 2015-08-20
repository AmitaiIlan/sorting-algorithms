package sorts;
import util.Time;
import list.Queue;

public class BucketSort {
	
	public static void main(String[] args){
		Queue q = randomList(10,10);
		System.out.println(q.toString());
		bucketSort(q,10);
	    System.out.println(q.toString());
	    
	    System.out.println();
	    for(int i = 1000; i <= 1000000; i*=10){
		    Time timer = new Time();
		    q = randomList(i,100);
		    timer.start();
		    bucketSort(q,100);
		    timer.stop();
		    System.out.print("Sorting " + i + " Integers: ");
		    timer.print();
	    }
	}
	
	  public static void bucketSort(Queue q, int max){
		  Queue[] buckets = new Queue[max];
		  
		  while(!q.isEmpty()){
			  Integer item = (Integer)q.dequeue();
			  int key = item;
			  if(buckets[key] == null)
				  buckets[key] = new Queue();
			  buckets[key].enqueue(item);
		  }
		  for(int i = 0; i < buckets.length; i++){
			  if(buckets[i] != null)
				  q.append(buckets[i]);
		  }
	  }
	  
	  private static Queue randomList(int size, int max) {
		    Queue q = new Queue();
		    for (int i = 0; i < size; i++) {
		      q.enqueue(new Integer((int) (max * Math.random())));
		    }
		    return q;
	  }
}
