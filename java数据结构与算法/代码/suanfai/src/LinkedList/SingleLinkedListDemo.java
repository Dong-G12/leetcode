package LinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
  public static void main(String[] args) {
	    HeroNode hero1 = new HeroNode(1,"�ν�","��ʱ��");
	    HeroNode hero2 = new HeroNode(2,"¬����","������");
	    HeroNode hero3 = new HeroNode(3,"����","�Ƕ���");
	    HeroNode hero4 = new HeroNode(4,"�ֳ�","����ͷ");
	    
	    SingleLinkedList singleLinkedList = new SingleLinkedList();
//	    singleLinkedList.add(hero1);
//	    singleLinkedList.add(hero2);
//	    singleLinkedList.add(hero3);
//	    singleLinkedList.add(hero4);
	    
	    
	    singleLinkedList.addByOrder(hero1);
	    singleLinkedList.addByOrder(hero3);
	    singleLinkedList.addByOrder(hero4);
	    singleLinkedList.addByOrder(hero2);
	    singleLinkedList.list();
	    System.out.println("�޸ĺ�����");
	    HeroNode newHeroNode = new HeroNode(2,"С¬","������--");
	    singleLinkedList.update(newHeroNode);
	    singleLinkedList.list();
	    
	    System.out.println("ɾ��");
	    singleLinkedList.delete(1);
	    singleLinkedList.delete(2);
	    singleLinkedList.list();
	    System.out.println("ɾ��");
	
	    singleLinkedList.list();
	    
	    System.out.println(getLength(singleLinkedList.getHead()));
	    
	    HeroNode res = findLastIndex(singleLinkedList.getHead(),1);
	    System.out.println(res);
	    
	    //��ת����
	    reverselist(singleLinkedList.getHead());
	    singleLinkedList.list();
	    reverseprint(singleLinkedList.getHead());
}
  //��������ȡ������Ľڵ�ĸ����������ͷ��㡣����ͳ��ͷ�ڵ㣩
  /**
   * 
   */
  public static int getLength(HeroNode head) {
	  if(head.next == null) {
		  return 0;
	  }
	  int length = 0;
	  HeroNode cur = head.next;
	  while(cur != null) {
		  length++;
		  cur = cur.next;
	  }
	  return length;
  }
  //���ҵ������еĵ�����K�����
  public static HeroNode findLastIndex(HeroNode head,int index) {
	  if(head.next == null) {
		  return null;
	  }
	  //��һ�α������õ�����ĳ���
	  
	  int size = getLength(head);
	  //�ڶ��α���size-index
	  //����һ��index��У��
	  
	  if(index <= 0 || index > size ) {
		  return null;
	  }
	  
	  HeroNode cur = head.next;
	  for(int i = 0; i<size - index;i++) {
		  cur = cur.next;
	  }
	  return cur;
  }
  //����������з�ת
  public static void reverselist(HeroNode head) {
	  if(head.next ==null || head.next.next == null ) {
		  return;
	  }
	  
	  //
	  HeroNode cur = head.next;
	  HeroNode next = null;
	  HeroNode reverseHead = new HeroNode(0,"","");
	  
	  while(cur != null) {
		  next = cur.next;
		  cur.next = reverseHead.next;
		  reverseHead.next = cur;
		  cur = next;
	  }
	  // 
	  head.next = reverseHead.next;
	  
  }
  public static void reverseprint(HeroNode head) {
	  if(head.next ==null) {
		  return;
	  }
	  
	  Stack<HeroNode> stack = new Stack<HeroNode>();
	  HeroNode cur = head.next;  
	  while(cur != null) {
		  stack.push(cur);
		  cur = cur.next;
	  }
	  // 
	  while(stack.size() > 0) {
		  System.out.println(stack.pop());
	  }
  }
}

//����SingleLinkedList ����Ӣ��
class SingleLinkedList{
	//��ʼ��һ��ͷ��㣬ͷ��㲻Ҫ��
	
	private HeroNode head = new HeroNode(0,"","");
	
	
	//��ӽ�㵽��������
	
	public HeroNode getHead() {
		return head;
	}


	public void setHead(HeroNode head) {
		this.head = head;
	}


	public void add(HeroNode heroNode) {
		//��Ϊhead�ڵ㲻�ܶ���������Ҫһ����������temp
		HeroNode temp = head;
		//��������
		
		while(true) {
			//
			if(temp.next == null) {
				break;
			}
			//���û���ҵ����
			
			temp = temp.next;
		}
		temp.next = heroNode;
	}
	
	
	//�ڶ������Ӣ�۵ķ�ʽ
	public void addByOrder(HeroNode heroNode) {
		//��Ϊͷ��㲻���ã���Ҫ��������temp
		HeroNode temp = head;
		boolean flag = false;//��ӵĽڵ��Ƿ����
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no > heroNode.no) {
				break;
			}else if(temp.next.no == heroNode.no) {
				flag = true ; //˵����Ŵ���
				break;
			}
			temp = temp.next;
		}
		//�ж�flag��ֵ
		
		if(flag) {
			System.out.printf("׼�������Ӣ�۵ı��%d�Ѿ������ˣ����ܼ���\n",heroNode.no);
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}
	//�޸Ľڵ�
	
	public void update(HeroNode newHeroNode) {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		
		HeroNode temp = head.next;
		boolean flag = false;//��ӵĽڵ��Ƿ����
		while(true) {
			if(temp == null) {
				break;//�Ѿ�����������
			}
			if(temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		}else {
			System.out.printf("û���ҵ����Ϊ%d�Ľڵ㣬�����޸ļ���\n",newHeroNode.no);
		}
	}
	
	
	//ɾ���ڵ�
	
	public void delete(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if (flag) {
			temp.next = temp.next.next;
			
		}else {
			System.out.printf("û���ҵ����Ϊ%d�Ľڵ㣬����ɾ��\n",no);
		}
	}
	
	//��ʾ����
	public void list() {
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
}












//����HeroNode

class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//ָ����һ���ڵ�
	
	public HeroNode(int hNo,String hName,String hNickname) {
		this.no = hNo;
		this.name = hName;
		this.nickname = hNickname;
	}
	
	//Ϊ����ʾ������дtoString����
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}