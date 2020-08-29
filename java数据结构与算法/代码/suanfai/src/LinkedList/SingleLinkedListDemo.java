package LinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
  public static void main(String[] args) {
	    HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
	    HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
	    HeroNode hero3 = new HeroNode(3,"吴用","智多星");
	    HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
	    
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
	    System.out.println("修改后链表");
	    HeroNode newHeroNode = new HeroNode(2,"小卢","玉麒麟--");
	    singleLinkedList.update(newHeroNode);
	    singleLinkedList.list();
	    
	    System.out.println("删除");
	    singleLinkedList.delete(1);
	    singleLinkedList.delete(2);
	    singleLinkedList.list();
	    System.out.println("删除");
	
	    singleLinkedList.list();
	    
	    System.out.println(getLength(singleLinkedList.getHead()));
	    
	    HeroNode res = findLastIndex(singleLinkedList.getHead(),1);
	    System.out.println(res);
	    
	    //反转链表
	    reverselist(singleLinkedList.getHead());
	    singleLinkedList.list();
	    reverseprint(singleLinkedList.getHead());
}
  //方法：获取单链表的节点的个数（如果带头结点。需求不统计头节点）
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
  //查找单链表中的倒数第K个结点
  public static HeroNode findLastIndex(HeroNode head,int index) {
	  if(head.next == null) {
		  return null;
	  }
	  //第一次遍历，得到链表的长度
	  
	  int size = getLength(head);
	  //第二次遍历size-index
	  //先做一个index的校验
	  
	  if(index <= 0 || index > size ) {
		  return null;
	  }
	  
	  HeroNode cur = head.next;
	  for(int i = 0; i<size - index;i++) {
		  cur = cur.next;
	  }
	  return cur;
  }
  //将单链表进行反转
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

//定义SingleLinkedList 管理英雄
class SingleLinkedList{
	//初始化一个头结点，头结点不要动
	
	private HeroNode head = new HeroNode(0,"","");
	
	
	//添加结点到单向链表
	
	public HeroNode getHead() {
		return head;
	}


	public void setHead(HeroNode head) {
		this.head = head;
	}


	public void add(HeroNode heroNode) {
		//因为head节点不能动，所以需要一个辅助变量temp
		HeroNode temp = head;
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
	}
	
	
	//第二种添加英雄的方式
	public void addByOrder(HeroNode heroNode) {
		//因为头结点不能用，需要辅助变量temp
		HeroNode temp = head;
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
	
	public void update(HeroNode newHeroNode) {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		
		HeroNode temp = head.next;
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
			System.out.printf("没有找到编号为%d的节点，不能删除\n",no);
		}
	}
	
	//显示链表
	public void list() {
		if(head.next == null) {
			System.out.println("链表为空");
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












//定义HeroNode

class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//指向下一个节点
	
	public HeroNode(int hNo,String hName,String hNickname) {
		this.no = hNo;
		this.name = hName;
		this.nickname = hNickname;
	}
	
	//为了显示方便重写toString方法
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}