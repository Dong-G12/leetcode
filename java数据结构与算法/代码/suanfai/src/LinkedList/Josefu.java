package LinkedList;

public class Josefu {
     public static void main(String[] args) {
	         //测试一把
    	 CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
    	 circleSingleLinkedList.addBoy(5);
    	 circleSingleLinkedList.showBoy();
    	 
    	 circleSingleLinkedList.countBoy(1,2,25);
}
}


//创建环形单向链表
class CircleSingleLinkedList{
	private Boy first = new Boy(-1);
	//
	public void addBoy(int nums) {
		//nums 做一个数据校验
		
		if(nums<1) {
			System.out.println("nums的值不正确");
			return;
		}
		
		Boy curBoy = null;
		for(int i =1;i<=nums;i++) {
			//根据编号创建小孩结点
			
			Boy boy = new Boy(i);
			
			//如果是第一个小孩
			if(i==1) {
				first = boy;
				first.setNext(first);//构成一个环
				curBoy = first;
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
				
			}
		}
	}
	
	//遍历当前的环形链表
	public void showBoy() {
		if(first == null) {
			System.out.println("链表为空");
			return;
		}
		//因为first不能动，因此我们仍然使用辅助指针完成遍历
		
		Boy curBoy = first;
		while(true) {
			System.out.printf("小孩的编号%d \n",curBoy.getNo());
			if(curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
		
	}
	
	//根据用户的输入，计算出小孩出圈的顺序
	/**
	 * 
	 * @param startNo 表示从第几个小孩开始数数
	 * @param countNum 表示数几下
	 * @param nums 表示最初有多少小孩在圈中
	 */
	public void countBoy(int startNo,int countNum,int nums) {
		//先对数据进行校验
		if(first == null || startNo < 1 || startNo > countNum) {
			System.out.println("参数输入有误，请重新输入");
			return;
		}
		Boy helper = first;
		while(true) {
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		//小孩报数前
		for(int j = 0; j < startNo-1;j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		//小孩报数时，循环操作，直到圈中只有一个节点
		while(true) {
			if(helper == first) {
				break;
			}
			for(int j = 0;j<countNum - 1;j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("小孩%d出圈\n",first.getNo());
			
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("最后留在圈中的小孩编号%d \n",helper.getNo());
	}
}
//创建Boy类表示结点
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
