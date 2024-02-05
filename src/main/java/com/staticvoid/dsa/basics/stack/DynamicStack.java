package com.staticvoid.dsa.basics.stack;


// Stack that is never full unlike CustomStack which had size restriction
public class DynamicStack extends CustomStack {
	
	public DynamicStack() {
		super();
	}
	
	public DynamicStack(int size) {
		super(size);
	}
	
	@Override()
	public boolean push(int item) {
		if (this.isFull()) {
			// double array size
			
			int[] temp = new int[data.length*2];
			
			//copy all previous item
			for (int i=0; i < data.length; i++) {
				temp[i] = data[i];
			}
			data = temp;
			System.out.println("Increased size to " + temp.length);
		}
		//insert normally
		super.push(item);
		return true;
	}
	

	public static void main(String[] args) throws StackException {
		DynamicStack stack = new DynamicStack();
		
		//CustomStack stack = new DynamicStack();
		//OOP concept 
		
		
		stack.push(10);
		stack.push(20);
		stack.push(1);
		stack.push(11);
		stack.push(22);
		stack.push(12);
		stack.push(10);
		stack.push(20);
		stack.push(1);
		stack.push(11);
		
		//stack is not after 10th push
		stack.push(22);
		stack.push(12);
		
		
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
		System.out.println(stack.pop());

	}

}
