package com.staticvoid.dsa.stack;

public class CustomStack {

	private static final int DEFAULT_SIZE = 10;

	public static void main(String[] args) throws StackException {
		CustomStack stack = new CustomStack();
		stack.push(10);
		stack.push(20);
		stack.push(1);
		stack.push(11);
		stack.push(22);
		stack.push(12);
		stack.push(10);
		stack.push(20);
		stack.push(1);
		stack.push(16);

		// stack is full after 10th push
		stack.push(22);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		// Throws Exception after 10th pop
		System.out.println(stack.pop());

	}

	protected int[] data;

	private int pointer = 0;

	public CustomStack() {
		this(DEFAULT_SIZE);
	}

	public CustomStack(int size) {
		data = new int[size];
	}

	public void display() {
		for (int i = 0; i < pointer; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println("END");
	}

	public boolean isEmpty() {
		return pointer == 0;
	}

	public boolean isFull() {
		return data.length == pointer;
	}

	public int peek() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack is empty, cannt peek");
		}
		return data[pointer];
	}

	public int pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack is empty, cannt pop");
		}
		display();
		return data[pointer--];
	}

	public boolean push(int item) {
		if (isFull()) {
			System.out.println("Stack is full");
			return false;
		}
		data[pointer++] = item;
		display();
		return true;
	}

}
