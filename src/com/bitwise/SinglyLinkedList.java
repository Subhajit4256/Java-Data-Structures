package com.bitwise;

public class SinglyLinkedList implements LinkedList{
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public Node head = null;
	public Node tail = null;
	
	public void insert(int data) {
		Node newNode = new Node(data);

		if(head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
	}
	
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			Node temp = head;
			head = newNode;
			head.next = temp;
		}
	}
	
	public void insertAtNth(int pos,int data) {
		Node newNode = new Node(data);
		
		if(pos == 0) {
			Node temp = head;
			head = newNode;
			head.next = temp;
		} else {
			Node temp = head;
			for(int i=1;i<pos-1;i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}
	
	public void display() {
		Node temp = head;
		
		if(temp == null) {
			System.out.println("EMPTY LIST");
			return;
		}
		
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("END");
	}
	
	public void find(int item) {
		Node temp = head;
		int pos = 1, flag = 0;
		if(temp == null) {
			System.out.println("EMPTY LIST");
			return;
		}
		
		while(temp != null) {
			if(temp.data == item) {
				System.out.print(temp.data + " found at position : " + pos);
				flag = 1;
				break;
			} else {
				temp = temp.next;
			}
			pos++;
		}
		if(flag == 0)
			System.out.println("Item not found");
	}
	
	public int deleteAtBeginning() {
		int item;
		if(head ==  null) {
			System.out.println("EMPTY LIST");
			item = -9999;
		} else {
			item = head.data;
			head = head.next;
		}
		return item;
	}
	
	public int deleteAtNth(int pos) {
		int item;
		if(pos == 1) {
			item = head.data;
			head = head.next;
		} else {
			Node current = head;
			for(int i=1;i<pos-1;i++) {
				current = current.next;
			}
			item = current.next.data;
			current.next = current.next.next;
		}
		return item;
	}
	
	public int deleteAtEnd() {
		int item;
		if(head ==  null) {
			System.out.println("EMPTY LIST");
			item = -9999;
		} else if(head.next == null) {
			item = head.data;
			head = tail = null;
		}else {
			Node current = head;
			Node temp = current;
			while(current.next != null) {
				temp = current;
				current = current.next;
			}
			item = current.data;
			temp.next = null;
			tail = temp;
		}
		return item;
	}
	
	public static void main(String args[]) {
		SinglyLinkedList linkedList =new SinglyLinkedList();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(10);
		/*linkedList.insertAtNth(3, 6);
		linkedList.display();
		linkedList.insertAtNth(4, 7);
		linkedList.display();
		linkedList.insertAtNth(0,0);
		linkedList.display();
		System.out.println("Deleted Data at the beginning : " + linkedList.deleteAtBeginning());
		linkedList.display();
		System.out.println("Deleted Data at the beginning : " + linkedList.deleteAtBeginning());
		linkedList.display();
		System.out.println("Deleted Data at the beginning : " + linkedList.deleteAtBeginning());
		linkedList.display();
		System.out.println("Deleted Data at the End : " + linkedList.deleteAtEnd());
		linkedList.display();
		System.out.println("Deleted Data at the End : " + linkedList.deleteAtEnd());
		linkedList.display();
		System.out.println("Deleted Data at the End : " + linkedList.deleteAtEnd());
		linkedList.display();
		linkedList.display();
		System.out.println("Deleted Data at 1 : " + linkedList.deleteAtNth(1));
		linkedList.display();
		System.out.println("Deleted Data at 3 : " + linkedList.deleteAtNth(3));
		linkedList.display();
		*/
		
		linkedList.find(5);
	}
}
