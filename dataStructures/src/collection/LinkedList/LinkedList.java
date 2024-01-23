package collection.LinkedList;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}

public class LinkedList {

	Node head;

	LinkedList() {
		head = null;
	}

	void insert(int data) {
		Node temp = head;
		if (head == null) {
			head = new Node(data);
			return;
		}
		while (temp.next != null)
			temp = temp.next;

		temp.next = new Node(data);
	}

	void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList llist = new LinkedList();

//		for(int i=1;i<10;i++) {
//			llist.insert(2*i);
//		}
		llist.insert(2);
		llist.insert(3);
		llist.insert(14);
		llist.insert(5);
		llist.insert(7);
		llist.display();

	}

}
