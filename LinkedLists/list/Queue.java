package list;

public class Queue {

	private Node head;
	private Node tail;
	private int size;

	public Queue() {
		size = 0;
		head = null;
		tail = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(Object item) {
		if (head == null) {
			head = new Node(item);
			tail = head;
		} else {
			tail.next = new Node(item);
			tail = tail.next;
		}
		size++;
	}

	public Object dequeue() {
		if (head == null)
			return null;
		Object o = head.data;
		head = head.next;
		size--;
		if (size == 0)
			tail = null;
		return o;
	}

	public Object front() {
		if (head == null)
			return null;
    
		return head.data;
	}

	public Object get(int n) {
		Node node = head;
		for (; n > 1; n--)
			node = node.next;
		return node.data;
	}

	public void append(Queue q) {
		if (head == null) {
			head = q.head;
		} else {
			tail.next = q.head;
		}
		if (q.head != null) {
			tail = q.tail;
		}
		size = size + q.size;
		q.head = null;
		q.tail = null;
		q.size = 0;
	}


	public String toString() {
		String out = "[ ";
    
    	for (int i = 0; i < size(); i++) {
    		out = out + front() + " ";
    		enqueue(dequeue());
    	}
    	return out + "]";
	}
}
