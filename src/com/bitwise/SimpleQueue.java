package com.bitwise;

public class SimpleQueue {
	private int queue[];
	private int capacity;
	int front,rear;
	
	SimpleQueue(int size) {
		this.capacity = size;
		this.queue = new int[size];
		this.front = this.rear = -1;
	}
	
	boolean isFull() {
		if(front == -1 && rear == capacity - 1)
			return true;
		else
			return false;
	}
	
	boolean isEmpty() {
		if(front == -1)
			return true;
		else
			return false;
	}
	
	void enqueue(int elm) {
		if(isFull()) {
			System.out.println("Overflow");
			return;
		}
		if(front == -1)
			front = 0;
		queue[++rear] = elm;
	}
	
	int dequeue() {
		if(isEmpty()) {
			System.out.println("Underflow");
			return -1;
		}
		int temp = queue[front];
		if(front >= rear) {
			front = rear = -1;
		} else
			front++;
		return temp;
	}
	
	void display() {
		if(isEmpty()) {
			System.out.println("Underflow");
			return;
		} else {
			for(int i=front;i<=rear;i++) {
				System.out.print(queue[i] + "\t");
			}
		}
	}
	
	public static void main(String args[]) {
		SimpleQueue queue = new SimpleQueue(5);
		System.out.println("Pushing...........");
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.display();
		System.out.println();
		System.out.println("Pulling...........");
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(5);
		queue.display();
	}
}
