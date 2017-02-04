

public class ReverseLinkList {
	static Node head;
	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}

	void printLinkedList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		ReverseLinkList list = new ReverseLinkList();
		list.head = new Node(90);
		list.head.next = new Node(70);
		list.head.next.next = new Node(6);
		list.head.next.next.next = new Node(1);

		System.out.println("The list in proper order");
		list.printLinkedList(head);
		head = list.reverseLinkedList(head);
		System.out.println("");
		System.out.println("The linkedList that is reversed");
		list.printLinkedList(head);
	}

	Node reverseLinkedList(Node n) {
		Node prevNode = null;
		Node currentNode = n;
		Node nextNode = null;
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		n = prevNode;
		return n;
	}
}
