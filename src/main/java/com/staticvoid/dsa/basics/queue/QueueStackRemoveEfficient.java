package com.staticvoid.dsa.basics.queue;

import java.util.Stack;

public class QueueStackRemoveEfficient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Stack<Integer> first;

	private Stack<Integer> second;

	public QueueStackRemoveEfficient() {
		first = new Stack<>();
		second = new Stack<>();
	}

	public void add(int item) {
		while (!first.isEmpty()) {
			second.push(first.pop());
		}
		first.push(item);

		while (!second.isEmpty()) {
			first.push(second.pop());
		}
	}

	public boolean isEmpty() {
		return first.isEmpty();
	}

	public int peek() {
		return first.peek();
	}

	public int remove() {
		return first.pop();
	}

}

// 1 2 3 5 4
// 4 5 3 2 1
// 4 5 3 2

// 2 3 5 4