package com.bitwise;

public interface LinkedList {
	void insert(int data);
	void insertAtBeginning(int data);
	void insertAtNth(int pos,int data);
	void display();
	void find(int item);
	int deleteAtBeginning();
	int deleteAtNth(int pos);
	int deleteAtEnd();
}
