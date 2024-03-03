package com.staticvoid.dsa.recursion;

import java.util.Stack;

public class ReverseStack {

	private static Stack<Integer> newStack = new Stack<>();


	public static void insertAtBottom(Stack<Integer> original, int item) {

		if (original.isEmpty()) {
			original.push(item);
			return;
		}

		int top = original.pop();
		insertAtBottom(original, item);
		original.push(top);

	}

	public static void main(String[] args) {
		Stack<Integer> old = new Stack<>();
		old.add(1);
		old.add(2);
		old.add(3);

		//		Stack<Integer> reversed = ReverseStack.reverseStack(old);
		//
		//
		//		for (int a : reversed) {
		//			System.out.print(a);
		//		}

		ReverseStack.reverseStackWithoutExtraSpace(old);

		System.out.println("Reversed without extra space ");

		for (int a : old) {
			System.out.print(a);
		}

	}

	public static Stack<Integer> reverseStack(Stack<Integer> original) {

		if (original.isEmpty()) {
			return ReverseStack.newStack;
		}

		newStack.push(original.pop());

		return reverseStack(original);

	}

	public static void reverseStackWithoutExtraSpace(Stack<Integer> original) {

		if (original.isEmpty()) {
			return;
		}

		int top = original.pop();
		reverseStackWithoutExtraSpace(original);

		insertAtBottom(original, top);

	}
}
