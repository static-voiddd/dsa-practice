package com.staticvoid.dsa.queue;

public class DynamicQueue extends CircularQueue {

	public static void main(String[] args) throws QueueException {
		DynamicQueue queue = new DynamicQueue();
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
		queue.insert(199); // not full and does resizing

	}

	@Override
	public boolean insert(int item) {
		if (isFull()) {
			System.out.println("Circular Q is full, increasing size...");
			int[] temp = new int[data.length * 2];
			for (int i = 0; i < data.length; i++) {
				// we dont do data[i] since ith element may not be same as front
				temp[i] = data[(start + i) % data.length];
			}
			start = 0;
			end = data.length - 1;
			data = temp;
		}

		return super.insert(item);
	}

}
