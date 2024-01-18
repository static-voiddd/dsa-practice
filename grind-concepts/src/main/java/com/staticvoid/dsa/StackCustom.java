package com.staticvoid.dsa;

public class StackCustom {
	
	private int[] data;
	private int pointer = -1;
	private static final int DEFAULT_SIZE = 10;
	
	
	public StackCustom() {
		this(DEFAULT_SIZE);
	}
	
	public StackCustom(int size) {
		data = new int[size];
	}
	
	public boolean push(int item) {
		if (isFull()) {
			System.out.println("Stack is full");
			return false;
		}
		pointer++;
		data[pointer] = item;
		return true;
	}
	
	public int pop() throws StackException {
		if (isEmpty()) {
			throw new StackException ("Stack is empty, cannt pop");
		}
		return data[pointer--]; 	
	}
	
	public int peek() throws StackException {
		if (isEmpty()) {
			throw new StackException ("Stack is empty, cannt peek");
		}
		return data[pointer];
	}
	
	public boolean isFull() {
		return data.length-1 == pointer;
	}
	
	public boolean isEmpty() {
		return pointer == -1;
	}
	

	public static void main(String[] args) throws StackException {
		// TODO Auto-generated method stub
		StackCustom stack = new StackCustom();
		stack.push(10);
		stack.push(20);
		stack.push(1);
		stack.push(11);
		stack.push(22);
		stack.push(12);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
