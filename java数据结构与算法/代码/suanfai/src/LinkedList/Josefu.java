package LinkedList;

public class Josefu {
     public static void main(String[] args) {
	         //����һ��
    	 CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
    	 circleSingleLinkedList.addBoy(5);
    	 circleSingleLinkedList.showBoy();
    	 
    	 circleSingleLinkedList.countBoy(1,2,25);
}
}


//�������ε�������
class CircleSingleLinkedList{
	private Boy first = new Boy(-1);
	//
	public void addBoy(int nums) {
		//nums ��һ������У��
		
		if(nums<1) {
			System.out.println("nums��ֵ����ȷ");
			return;
		}
		
		Boy curBoy = null;
		for(int i =1;i<=nums;i++) {
			//���ݱ�Ŵ���С�����
			
			Boy boy = new Boy(i);
			
			//����ǵ�һ��С��
			if(i==1) {
				first = boy;
				first.setNext(first);//����һ����
				curBoy = first;
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
				
			}
		}
	}
	
	//������ǰ�Ļ�������
	public void showBoy() {
		if(first == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//��Ϊfirst���ܶ������������Ȼʹ�ø���ָ����ɱ���
		
		Boy curBoy = first;
		while(true) {
			System.out.printf("С���ı��%d \n",curBoy.getNo());
			if(curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
		
	}
	
	//�����û������룬�����С����Ȧ��˳��
	/**
	 * 
	 * @param startNo ��ʾ�ӵڼ���С����ʼ����
	 * @param countNum ��ʾ������
	 * @param nums ��ʾ����ж���С����Ȧ��
	 */
	public void countBoy(int startNo,int countNum,int nums) {
		//�ȶ����ݽ���У��
		if(first == null || startNo < 1 || startNo > countNum) {
			System.out.println("����������������������");
			return;
		}
		Boy helper = first;
		while(true) {
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		//С������ǰ
		for(int j = 0; j < startNo-1;j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		//С������ʱ��ѭ��������ֱ��Ȧ��ֻ��һ���ڵ�
		while(true) {
			if(helper == first) {
				break;
			}
			for(int j = 0;j<countNum - 1;j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("С��%d��Ȧ\n",first.getNo());
			
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("�������Ȧ�е�С�����%d \n",helper.getNo());
	}
}
//����Boy���ʾ���
class Boy{
	private int no;
	private Boy next;
	
	
	public Boy(int no) {
		this.no = no;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public Boy getNext() {
		return next;
	}


	public void setNext(Boy next) {
		this.next = next;
	}
	
	
}
