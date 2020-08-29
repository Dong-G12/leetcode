package queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
	    System.out.println("测试数组模拟环形队列的代码");
	    CircleArray queue = new CircleArray(4);//说明设置4，其队列的有效数据最大是3
		char key =' ';//接收用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		//输出一个菜单
		
		System.out.println("s(show):显示队列");
		System.out.println("e(exit):退出程序");
		System.out.println("a(add):添加数据到队列");
		System.out.println("g(get):从队列取出数据");
		System.out.println("h(head):查看队列头的数据");
		while(loop) {
			key = scanner.next().charAt(0);//接收一个字符
			switch(key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("添加一个数");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				};
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("队列头的数据是%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				};
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序退出");
	
}
}


class CircleArray{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	public CircleArray(int arrMaxSize){
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}
	public boolean isFull() {
		return (rear+1) % maxSize == front;	
	}
	public boolean isEmpty() {
		return rear == front;	
	}
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("队列已满，不能加入数据");
			return;
		}
		arr[rear] = n;
		rear = (rear+1) % maxSize;
	}
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空，不能取数据");
		}
		//这里需要分析front是指向队列的第一个元素
		//1，先把front对应的值保留到一个临时变量
		//2，将front后移
		//3，将临时保存的变量返回
		int value = arr[front];
		front = (front+1) % maxSize;
		return value;
		
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("队列是空的，没有数据");
			return;
		}
		//思路，从front开始遍历，遍历多少个元素
		//动脑筋
		
		for(int i=front;i<front+size();i++) {
			System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
		}
	}
	
	public int size() {
		return(rear + maxSize - front)%maxSize;
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列是空的");
		}
		return arr[front+1];
	}
}