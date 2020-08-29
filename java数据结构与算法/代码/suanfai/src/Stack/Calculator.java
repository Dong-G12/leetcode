package Stack;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String expression = "70+2*6-4";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;
        int num1=0;
        int num2=0;
        int oper=0;
        int res = 0;
        char ch=' ';
        String keepNum ="";
        while(true) {
        	ch = expression.substring(index, index+1).charAt(0);
        	//判断ch是什么，然后做相应的处理
        	if(operStack.isOper(ch)) {
        		if(!operStack.isEmpty()) {
        			if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
        				//
        				num1 = numStack.pop();
        				num2 = numStack.pop();
        				oper = operStack.pop();
        				res = numStack.call(num1, num2, oper);
        				
        				numStack.push(res);
        				operStack.push(ch);
        			}else {
        				operStack.push(ch);
        			}
        		}else {
        			operStack.push(ch);//
        		}
        	}else {
        		//处理多位数
        		keepNum += ch;
        		if(index == expression.length()-1) {
        			numStack.push(Integer.parseInt(keepNum));
        		}else{
        			if(operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
        			numStack.push(Integer.parseInt(keepNum));
        			keepNum ="";
        			}
        		}
        		
        	}
        	index++;
        	if(index >= expression.length()) {
        		break;
        	}
        }
        numStack.list();
        operStack.list();
        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号。并运行
        while(true) {
        	if(operStack.isEmpty()) {
        		break;
        	}
        	num1 = numStack.pop();
        	System.out.println(num1);
			num2 = numStack.pop();
			System.out.println(num2);
			oper = operStack.pop();
			System.out.println(oper);
			res  = numStack.call(num1, num2, oper);
			System.out.println(oper);
			numStack.push(res);
			numStack.list();
        }
        int res2 = numStack.pop();
        System.out.printf("表达式%s = %d",expression,res2);
	}

}

//先创建一个栈

class ArrayStack2{
	private int maxSize;//栈的大小
	private int[] stack;
	private int top = -1;
	
	public ArrayStack2(int maxSize) {
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
	//返回运算符的优先级，优先级使用数字表示
	public int priority(int oper) {
		if(oper == '*' || oper == '/') {
			return 1;
		}else if(oper == '+' || oper == '-') {
			return 0;
		}else {
			return -1;
		}
	}
	//判断是不是一个运算符
	public boolean isOper(char val) {
		return val =='+'||val =='-'|| val =='*'|| val =='/';
	}
	//计算方法
	
	public int call(int num1,int num2,int oper) {
		int res = 0;
		switch(oper) {
		case '+':
			res = num1+num2;
			break;
		case '-':
			res = num2-num1;
			break;
		case '*':
			res = num1*num2;
			break;
		case '/':
			res = num2/num1;
			break;
		default:
			break;
		}
		return res;
	}
	
	public int peek() {
		return stack[top];
	}
}
