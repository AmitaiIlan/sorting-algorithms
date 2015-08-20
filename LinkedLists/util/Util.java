package util;
import list.Queue;

public class Util {
	public static Queue randomList(int size) {
		Queue q = new Queue();
		for (int i = 0; i < size; i++) {
			q.enqueue(new Integer((int) (size * Math.random())));
		}
		return q;
	}
	
	public static Queue randomList(int size, int max) {
		Queue q = new Queue();
		for (int i = 0; i < size; i++) {
			q.enqueue(new Integer((int) (max * Math.random())));
		}
		return q;
	}
}
