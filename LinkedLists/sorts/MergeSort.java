package sorts;
import util.Time;
import util.Util;
import list.Queue;

public class MergeSort {
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
		Queue qq = queueOfQueues(q);
		  
		while(qq.size() > 1){
			Queue q1 = (Queue)qq.dequeue();
			Queue q2 = (Queue)qq.dequeue();
			qq.enqueue(merge(q1,q2));
		}
		q.append((Queue)qq.dequeue());
	}
	
	public static Queue merge(Queue q1, Queue q2) {
		Queue queue = new Queue();
		while(!q1.isEmpty() && !q2.isEmpty()){
			Comparable item1 = (Comparable)q1.front();
			Comparable item2 = (Comparable)q2.front();
			if(item1.compareTo(item2) <= 0){
				queue.enqueue(q1.dequeue());
			}
			else {
				queue.enqueue(q2.dequeue());
			}
		}
		if(q1.isEmpty())
			queue.append(q2);
		else
			queue.append(q1);
		return queue;
	}

	//put each item in the queue into its own queue
	public static Queue queueOfQueues(Queue q) {
		Queue queue = new Queue();
		while(!q.isEmpty()){
			Queue tmp = new Queue();
			tmp.enqueue(q.dequeue());
			queue.enqueue(tmp);
		}

	    return queue;
	}
}
