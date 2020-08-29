package Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
	      
}
}

class ArrayStack{
	private int maxSize;//栈的大小
	private int[] stack;
	private int top = -1;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	public boolean isEmpty() {
		return top == -1;	
	}
	
	public void push(int value) {
		if(isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	public int pop() {
		if(isEmpty()) {
			//抛出异常
			throw new RuntimeException("栈空，没有数据");
		
		}
		int value = stack[top];
		top--;
		return value;
	}
	//遍历时，需要从栈顶开始显示数据
	public void list() {
		if(isEmpty()) {
			//抛出异常
			System.out.println("栈空");
			return;
		}
		for(int i = top;i>=0;i--) {
			System.out.printf("stack[%d] = %d\n",i,stack[i]);
		}
	}
}
