package com.staticvoid.dsa.queue;

import java.util.Stack;

public class QueueStackPushEfficient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Stack<Integer> first;

	private Stack<Integer> second;

	public QueueStackPushEfficient() {
		first = new Stack<>();
		second = new Stack<>();
	}

	public void add(int item) {
		first.push(item);
	}

	private int getResult(boolean isForPeak) {
		while (!first.isEmpty()) {
			second.push(first.pop());
		}
		int peek = isForPeak ? second.peek() : second.pop();

		while (!second.isEmpty()) {
			first.push(second.pop());
		}
		return peek;
	}

	public boolean isEmpty() {
		return first.isEmpty();
	}

	public int peek() {
		return getResult(false);
	}

	public int remove() {
		return getResult(true);
	}

}

// 1 2 3 5 4
// 4 5 3 2 1
// 4 5 3 2

// 2 3 5 4