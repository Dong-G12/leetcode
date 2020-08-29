package Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
	      
}
}

class ArrayStack{
	private int maxSize;//ջ�Ĵ�С
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
			System.out.println("ջ��");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	public int pop() {
		if(isEmpty()) {
			//�׳��쳣
			throw new RuntimeException("ջ�գ�û������");
		
		}
		int value = stack[top];
		top--;
		return value;
	}
	//����ʱ����Ҫ��ջ����ʼ��ʾ����
	public void list() {
		if(isEmpty()) {
			//�׳��쳣
			System.out.println("ջ��");
			return;
		}
		for(int i = top;i>=0;i--) {
			System.out.printf("stack[%d] = %d\n",i,stack[i]);
		}
	}
}
