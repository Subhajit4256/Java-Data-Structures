package com.bitwise;

public class DoublyLinkedList implements LinkedList {

	static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node head;
	private Node tail;

	@Override
	public void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.left = tail;
			tail.right = newNode;
		}
		tail = newNode;
	}

	@Override
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			head.left = newNode;
			newNode.right = head;
			head = newNode;
		}
	}

	@Override
	public void insertAtNth(int pos, int data) {
		Node newNode = new Node(data);
		if(pos == 1) {
			head = newNode;
		} else {
			Node previousNode = head;
			for(int i=1;i<pos-1;i++) {
				previousNode = previousNode.right;
			}
			newNode.left = previousNode;
			newNode.right = previousNode.right;
			previousNode.right.left = newNode;
			previousNode.right = newNode;
		}
	}

	@Override
	public void display() {
		Node current = head;
		System.out.println("\nForward Direction");
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.right;
		}
		System.out.print("END");
		System.out.println();
		System.out.println("Backward Direction");
		current = tail;
		while (current != null) {
			System.out.print(current.data + " -> ");
			current = current.left;
		}
		System.out.print("END");
	}

	@Override
	public void find(int item) {
		Node current = head;
		int index = 1, flag = 0;
		while (current != null) {
			if(item == current.data) {
				System.out.println("ITEM FOUND AT : "+index);
				flag = 1;
			}
			index++;
			current = current.right;
		}
		if(flag == 0)
			System.out.println("ITEM NOT FOUND");
	}

	@Override
	public int deleteAtBeginning() {
		int item = 0;
		if(head == null) {
			System.out.println("EMPTY LIST");
			item = -9999;
		} else {
			head = head.right;
			head.left = null;
		}
		return item;
	}

	@Override
	public int deleteAtNth(int pos) {
		int item = 0;
		if(head == null) {
			System.out.println("EMPTY LIST");
			item = -9999;
		} else {
			Node nodeToBeDeleted = head;
			for(int i=1;i<pos;i++) {
				nodeToBeDeleted = nodeToBeDeleted.right;
			}
			item = nodeToBeDeleted.data;
			Node temp = nodeToBeDeleted.left;
			nodeToBeDeleted.right.left = temp;
			nodeToBeDeleted.left.right = nodeToBeDeleted.right;
		}
		return item;
	}

	@Override
	public int deleteAtEnd() {
		int item = 0;
		if(head == null) {
			System.out.println("EMPTY LIST");
			item = -9999;
		} else {
			item = tail.data;
			tail = tail.left;
			tail.right = null;
		}
		return item;
	}

	public static void main(String args[]) {
		DoublyLinkedList linkedList = new DoublyLinkedList();
		linkedList.insertAtBeginning(1);
		linkedList.insertAtBeginning(2);
		linkedList.insertAtBeginning(3);
		linkedList.insertAtBeginning(4);
		linkedList.insertAtBeginning(5);
		linkedList.insert(55);
		linkedList.insert(66);
		linkedList.insertAtBeginning(10);
		linkedList.insertAtNth(3, 77);
		//linkedList.display();
		//linkedList.deleteAtEnd();
		//linkedList.display();
		linkedList.find(55);
	}
}
