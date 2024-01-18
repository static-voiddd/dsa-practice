package com.staticvoid.dsa.queue;

import com.staticvoid.dsa.stack.StackException;

public class CustomQueue {
	
	private int[] data;
	private static final int DEFAULT_SIZE = 10;
	int end = 0; 
	
	//Constructor
	public CustomQueue() {
		this(DEFAULT_SIZE);
	}
	
	public CustomQueue(int size) {
		this.data = new int[size];
	}
	
	public boolean isFull() {
		return data.length-1 == end;
		
	}
	
	public boolean isEmpty() {
		return end == 0;
	}
	
	//insert at the end
	// O(1)
	public boolean insert(int item) {
		if (isFull()) {
			System.out.println("Queue is already full");
			return false;
		}
		data[end++] = item;
		display();
		return true;
	}
	
	
	// remove from the head
	// O(n) 
	// 3 9 4 18 77 becomes
	// 9 4 18 77 0
	public int remove() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Queue is empty, nothing to remove");
		}
		int removed = data[0];
		for (int i=0; i< data.length-1; i++) {
			data[i] = data[i+1];
		}
		
		end--;
		display();
		return removed;
	}
	
	public int peek() throws StackException {
		if (isEmpty()) {
			throw new StackException ("Queue is empty, cannt peek");
		}
		return data[end];
	}
	
	public void display() {
		for (int i= 0; i < end; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("END");
	}

	public static void main(String[] args) throws QueueException {
		// TODO Auto-generated method stub
		CustomQueue queue = new CustomQueue();
		queue.insert(3);
		queue.insert(9);
		queue.insert(4);
		queue.insert(9);
	
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();

	}

}
