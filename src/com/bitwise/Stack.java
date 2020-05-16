package com.bitwise;

public class Stack {
	
	private int arr[];
	private int capacity;
	private int top;
	
	Stack(int size) {
		this.capacity = size;
		this.arr = new int[size];
		this.top = -1;
	}
	
	boolean isFull() {
		return top == capacity - 1;
	}
	
	boolean isEmpty() {
		return top == -1;
	}
	
	void push(int elm) {
		if(isFull()) {
			System.out.println("Stack Overflow");
			return;
		}
		arr[++top] = elm;
	}
	
	int pop() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return arr[top--];
	}
	
	void printStack() {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	public static void main(String args[]) {
		Stack stack = new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.printStack();
		System.out.println();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
