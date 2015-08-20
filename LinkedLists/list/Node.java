package list;

class Node {
  Object data;
  Node next;

  Node(Object data) {
    this.data = data;
    this.next = null;
  }

  Node(Object data, Node next) {
    this.data = data;
    this.next = next;
  }

}
