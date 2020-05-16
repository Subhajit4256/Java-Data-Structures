package com.bitwise;

public class CircularQueue {
	private int queue[];
	private int capacity;
	int front,rear;
	
	CircularQueue(int size) {
		this.capacity = size;
		this.queue = new int[size];
		this.front = this.rear = -1;
	}
	
	boolean isFull() {
		if((front == -1 && rear == capacity - 1) || (front == rear + 1))
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
		rear = (rear + 1) % capacity;
		queue[rear] = elm;
	}
	
	int dequeue() {
		if(isEmpty()) {
			System.out.println("Underflow");
			return -1;
		}
		int temp = queue[front];
		if(front == rear) {
			front = rear = -1;
		} else
			front = (front + 1) % capacity;
		return temp;
	}
	
	void display() {
		if(isEmpty()) {
			System.out.println("Underflow");
			return;
		} else {
			int i;
			for(i=front;i!=rear;i = (i+1) % capacity) {
				System.out.print(queue[i] + "\t");
			}
			System.out.println(queue[i]);
		}
	}
	
	public static void main(String args[]) {
		CircularQueue queue = new CircularQueue(5);
		System.out.println("Pushing...........");
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(6);
		queue.enqueue(7);
		queue.display();
	}
}
