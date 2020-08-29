package queue;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class ArrayQueueDemo {
      public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		char key =' ';//�����û�����
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		//���һ���˵�
		
		System.out.println("s(show):��ʾ����");
		System.out.println("e(exit):�˳�����");
		System.out.println("a(add):������ݵ�����");
		System.out.println("g(get):�Ӷ���ȡ������");
		System.out.println("h(head):�鿴����ͷ������");
		while(loop) {
			key = scanner.next().charAt(0);//����һ���ַ�
			switch(key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("���һ����");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ����������%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				};
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("����ͷ��������%d\n",res);
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
		System.out.println("�����˳�");
	}
}


//ʹ������ģ�����-��дһ��Array Queue��

class ArrayQueue{
	private int maxSize;
	private int front;//����ͷ
	private int rear;//����β
	private int[] arr;//���������ڴ�����ݣ�ģ�����
	
	//�������еĹ�����
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front=-1;//ָ�����ͷ��,������front��ָ�����ͷ��ǰһ��λ��
		
		rear = -1;//ָ�����β��ָ�����β�����ݣ������Ƕ��е����һ�����ݣ�
		
	}
	
	public boolean isFull() {
		return rear == maxSize - 1;	
	}
	public boolean isEmpty() {
		return rear == front;	
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("�������������ܼ�������");
			return;
		}
		
		rear++;
		arr[rear] = n;
	}
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("���пգ�����ȡ����");
		}
		
		front++;
		return arr[front];
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("�����ǿյģ�û������");
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("�����ǿյ�");
		}
		return arr[front+1];
	}
	
	
}