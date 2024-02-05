package com.staticvoid.dsa.basics.queue;

import com.staticvoid.dsa.basics.stack.StackException;

public class CustomQueue {

	private static final int DEFAULT_SIZE = 10;

	public static void main(String[] args) throws QueueException {
		CustomQueue queue = new CustomQueue();
		queue.insert(3);
		queue.insert(9);
		queue.insert(4);
		queue.insert(9);
		queue.insert(13);
		queue.insert(19);
		queue.insert(14);
		queue.insert(29);
		queue.insert(33);
		queue.insert(39);

		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();

	}

	private int[] data;

	int end = 0;

	// Constructor
	public CustomQueue() {
		this(DEFAULT_SIZE);
	}

	public CustomQueue(int size) {
		this.data = new int[size];
	}

	public void display() {
		for (int i = 0; i < end; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("END");
	}

	// insert at the end
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

	public boolean isEmpty() {
		return end == 0;
	}

	public boolean isFull() {
		return data.length == end;

	}

	public int peek() throws StackException {
		if (isEmpty()) {
			throw new StackException("Queue is empty, cannt peek");
		}
		return data[end];
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
		for (int i = 0; i < data.length - 1; i++) {
			data[i] = data[i + 1];
		}

		end--;
		display();
		return removed;
	}

}
