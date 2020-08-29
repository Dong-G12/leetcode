package LinkedList;

public class DoubleLinkedListDemo {
  public static void main(String[] args) {
	  System.out.println("˫������Ĳ���");
	  HeroNode2 hero1 = new HeroNode2(1,"�ν�","��ʱ��");
	  HeroNode2 hero2 = new HeroNode2(2,"¬����","������");
	  HeroNode2 hero3 = new HeroNode2(3,"����","�Ƕ���");
	  HeroNode2 hero4 = new HeroNode2(4,"�ֳ�","����ͷ");
	  
	  DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
	  doubleLinkedList.add(hero1);
	  doubleLinkedList.add(hero2);
	  doubleLinkedList.add(hero3);
	  doubleLinkedList.add(hero4);
	  
	  doubleLinkedList.list();
	  
	  //�޸�
	  HeroNode2 newhero = new HeroNode2(4,"����ʤ","������");
	  doubleLinkedList.update(newhero);
	  System.out.println("�޸ĺ��������");
	  doubleLinkedList.list();
	  
	  //ɾ��
	  doubleLinkedList.delete(3);
	  doubleLinkedList.list();
	  
	  
}
}

class DoubleLinkedList{
	//��ʼ��һ��ͷ��㣬ͷ��㲻Ҫ��
	
	private HeroNode2 head = new HeroNode2(0,"","");
	
	
	//��ӽ�㵽��������
	
	public HeroNode2 getHead() {
		return head;
	}


	public void setHead(HeroNode2 head) {
		this.head = head;
	}


	public void add(HeroNode2 heroNode) {
		//��Ϊhead�ڵ㲻�ܶ���������Ҫһ����������temp
		HeroNode2 temp = head;
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
		heroNode.pre = temp;
	}
	
	
	//�ڶ������Ӣ�۵ķ�ʽ
	public void addByOrder(HeroNode2 heroNode) {
		//��Ϊͷ��㲻���ã���Ҫ��������temp
		HeroNode2 temp = head;
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
	
	public void update(HeroNode2 newHeroNode) {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		
		HeroNode2 temp = head.next;
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
		
		
		if(head.next == null) {
			System.out.println("����Ϊ�գ��޷�ɾ��");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp == null) {
				break;
			}
			if(temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if (flag) {
			temp.pre.next = temp.next;
			//���ɾ�����һ����㣬��������
			//��������һ���ڵ�Ͳ���Ҫִ��������仰
			if(temp.next != null) {
			     temp.next.pre = temp.pre;
			     }
			
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
		HeroNode2 temp = head.next;
		
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
}























class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;//ָ����һ���ڵ�,Ĭ��Ϊnull
	public HeroNode2 pre;
	
	public HeroNode2(int hNo,String hName,String hNickname) {
		this.no = hNo;
		this.name = hName;
		this.nickname = hNickname;
	}
	
	//Ϊ����ʾ������дtoString����
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}