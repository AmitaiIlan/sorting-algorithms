package sorts;
import util.Time;
import util.Util;
import list.Queue;

public class QuickSort {
	public static void main(String[] args){
		Queue q = Util.randomList(10);
		System.out.println(q.toString());
		sort(q);
	    System.out.println(q.toString());
	    
	    System.out.println();
	    for(int i = 1000; i <= 1000000; i*=10){
		    Time timer = new Time();
		    q = Util.randomList(i);
		    timer.start();
		    sort(q);
		    timer.stop();
		    System.out.print("Sorting " + i + " Integers: ");
		    timer.print();
	    }
	}
	
	  public static void sort(Queue q) {
		  if(q.size() < 2) return;
		  int pivotIndex = (int) (q.size() * Math.random())+1;
		  Comparable pivot = (Comparable)q.get(pivotIndex);
		  Queue small = new Queue();
		  Queue equal = new Queue();
		  Queue large = new Queue();
		  partition(q,pivot,small,equal,large);
		  sort(small);
		  sort(large);
		  q.append(small);;
		  q.append(equal);
		  q.append(large);
	  }
	
	public static void partition(Queue input, Comparable pivot, Queue small, Queue equal, Queue large) {
		while(!input.isEmpty()){
			Comparable item = (Comparable)input.dequeue();
			if(item.compareTo(pivot) < 0) small.enqueue(item);
			else if(item.compareTo(pivot) == 0) equal.enqueue(item);
			else large.enqueue(item);
		}
		  
	}
}
