package LinkedList;

public class DoubleLinkedListDemo {
  public static void main(String[] args) {
	  System.out.println("双向链表的测试");
	  HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
	  HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
	  HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
	  HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");
	  
	  DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
	  doubleLinkedList.add(hero1);
	  doubleLinkedList.add(hero2);
	  doubleLinkedList.add(hero3);
	  doubleLinkedList.add(hero4);
	  
	  doubleLinkedList.list();
	  
	  //修改
	  HeroNode2 newhero = new HeroNode2(4,"公孙胜","入云龙");
	  doubleLinkedList.update(newhero);
	  System.out.println("修改后链表情况");
	  doubleLinkedList.list();
	  
	  //删除
	  doubleLinkedList.delete(3);
	  doubleLinkedList.list();
	  
	  
}
}

class DoubleLinkedList{
	//初始化一个头结点，头结点不要动
	
	private HeroNode2 head = new HeroNode2(0,"","");
	
	
	//添加结点到单向链表
	
	public HeroNode2 getHead() {
		return head;
	}


	public void setHead(HeroNode2 head) {
		this.head = head;
	}


	public void add(HeroNode2 heroNode) {
		//因为head节点不能动，所以需要一个辅助变量temp
		HeroNode2 temp = head;
		//遍历链表
		
		while(true) {
			//
			if(temp.next == null) {
				break;
			}
			//如果没有找到最后
			
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	
	
	//第二种添加英雄的方式
	public void addByOrder(HeroNode2 heroNode) {
		//因为头结点不能用，需要辅助变量temp
		HeroNode2 temp = head;
		boolean flag = false;//添加的节点是否存在
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no > heroNode.no) {
				break;
			}else if(temp.next.no == heroNode.no) {
				flag = true ; //说明编号存在
				break;
			}
			temp = temp.next;
		}
		//判断flag的值
		
		if(flag) {
			System.out.printf("准备插入的英雄的编号%d已经存在了，不能加入\n",heroNode.no);
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}
	//修改节点
	
	public void update(HeroNode2 newHeroNode) {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		
		HeroNode2 temp = head.next;
		boolean flag = false;//添加的节点是否存在
		while(true) {
			if(temp == null) {
				break;//已经遍历完链表
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
			System.out.printf("没有找到编号为%d的节点，不能修改加入\n",newHeroNode.no);
		}
	}
	
	
	//删除节点
	
	public void delete(int no) {
		
		
		if(head.next == null) {
			System.out.println("链表为空，无法删除");
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
			//如果删除最后一个结点，会有问题
			//如果是最后一个节点就不需要执行下面这句话
			if(temp.next != null) {
			     temp.next.pre = temp.pre;
			     }
			
		}else {
			System.out.printf("没有找到编号为%d的节点，不能删除\n",no);
		}
	}
	
	//显示链表
	public void list() {
		if(head.next == null) {
			System.out.println("链表为空");
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
	public HeroNode2 next;//指向下一个节点,默认为null
	public HeroNode2 pre;
	
	public HeroNode2(int hNo,String hName,String hNickname) {
		this.no = hNo;
		this.name = hName;
		this.nickname = hNickname;
	}
	
	//为了显示方便重写toString方法
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}