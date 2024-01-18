package com.staticvoid.dsa.queue;

public class CircularQueue {

	private static final int DEFAULT_SIZE = 5;

	public static void main(String[] args) throws QueueException {
		CircularQueue queue = new CircularQueue();
		// queue.remove(); // exception
		queue.insert(3);
		queue.insert(6);
		queue.insert(5);
		queue.insert(19);
		queue.insert(1);

		System.out.println(queue.remove());
		queue.display();
		queue.insert(133);

		System.out.println(queue.remove());
		queue.display();
		queue.insert(99);
		queue.insert(199); // full
	}

	/*
	 * Inserted 3 3 -> END Inserted 6 3 -> 6 -> END Inserted 5 3 -> 6 -> 5 -> END
	 * Inserted 19 3 -> 6 -> 5 -> 19 -> END Inserted 1 3 -> 6 -> 5 -> 19 -> 1 -> END
	 * 3 6 -> 5 -> 19 -> 1 -> END Inserted 133 6 -> 5 -> 19 -> 1 -> 133 -> END 6 5
	 * -> 19 -> 1 -> 133 -> END Inserted 99 5 -> 19 -> 1 -> 133 -> 99 -> END
	 * Circular Q is full
	 */

	protected int start;
	protected int end;

	protected int[] data;

	protected int size; // total elements on array

	public CircularQueue() {
		this(DEFAULT_SIZE);
	}

	public CircularQueue(int size) {
		data = new int[size];
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Empty");
			return;
		}
		int i = start;
		do {
			System.out.print(data[i] + " -> ");
			i++;
			i %= data.length;
		} while (i != end);
		System.out.println("END");
		System.out.println("START " + start + " END " + end);

	}

	public int front() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Q is empty to show at front");
		}
		return data[start];
	}

	public boolean insert(int item) {
		if (isFull()) {
			System.out.println("Circular Q is full");
			return false;
		}
		data[end++] = item;
		end = end % data.length; // if we go out of bound this brings back to 0
		size++;
		System.out.println("Inserted " + item);
		display();
		return true;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == data.length;
	}

	public int remove() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("Q is empty to remove");
		}
		int removed = data[start++];
		start = start % data.length;
		size--;
		return removed;
	}

}
