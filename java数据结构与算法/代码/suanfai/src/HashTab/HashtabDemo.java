package HashTab;

import java.util.Scanner;

public class HashtabDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           //创建一个哈希表
		HashTab hashTab = new HashTab(7);
		String key="";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("add:添加雇员");
			System.out.println("list:显示雇员");
			System.out.println("find:找雇员");
			System.out.println("delete:删除雇员");	
			System.out.println("exit:退出系统");
			key = scanner.next();
			switch(key) {
			case "add":
				System.out.println("输入id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
				String name = scanner.next();
				Emp emp = new Emp(id,name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("请输入要查找的id");
				id = scanner.nextInt();
				hashTab.findEmployID(id);
				break;
			case "delete":
				System.out.println("请输入要删除的id");
				id = scanner.nextInt();
				hashTab.deleteEmployID(id);
				break;
			case "exit":
				scanner.close();
				System.exit(0);
				
	        default:
	        	break;
				
			}
		}
		
	}


}
//用来管理多条链表
class HashTab{
	private EmpLinkedList[] emLinkedListArray;
	private int size; //表示共有多少条链表
	//构造器
	
	public HashTab(int size) {
		//初始化emLinkedListArray
		this.size = size;
		emLinkedListArray = new EmpLinkedList[size];
		//?留一个坑
		for(int i = 0;i<size;i++) {
			emLinkedListArray[i] = new EmpLinkedList();
		}
	}
	//添加雇员
	public void add(Emp emp) {
		//根据员工的id，得到该员工应当添加到哪条链表
		int emLinkedListArrayNo = hashFunc(emp.id);
		emLinkedListArray[emLinkedListArrayNo].add(emp);
	}
	//遍历所有的链表
	public void list() {
		for(int i =0;i<size;i++) {
			emLinkedListArray[i].list(i);
		}
	}
	
	
	//编写一个散列函数，使用一个简单的取模法
	
	public int hashFunc(int id) {
		return id % size;
	}
	
	public void findEmployID(int id) {
		int emLinkedListArrayNo = hashFunc(id);
		Emp emp = emLinkedListArray[emLinkedListArrayNo].findEmpById(id);
		if(emp != null) {
			System.out.printf("在第%d条链表中找到雇员 id = %d\n",(emLinkedListArrayNo+1),id);
		}else {
			System.out.println("在哈希表中，没有找到该雇员");
		}
	}
	
	public void deleteEmployID(int id) {
		int emLinkedListArrayNo = hashFunc(id);
		emLinkedListArray[emLinkedListArrayNo].delete(id);
	}
}
class Emp{
	public int id;
	public String name;
	public Emp next;//默认为null
	public Emp(int id,String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

//创建EmpLinkedList,表示链表
class EmpLinkedList{
	//头指针，指向第一个雇员Emp，因此这个链表的head直接指向第一个Emp
	private Emp head;
	
	//添加雇员到链表
	
	public void add(Emp emp) {
		//如果是添加第一个雇员
		if(head == null) {
			head = emp;
			return;
		}
		//
		Emp curEmp = head;
		while(true) {
			if(curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		//退出时直接将emp加入链表
		curEmp.next = emp;
	}
	
	public void list(int no) {
		if(head == null) {
			System.out.println("第"+(no+1)+"条链表为空");
			return;
		}
		System.out.print("第"+(no+1)+"条链表的信息为");
		Emp curEmp = head;
		while(true) {
			System.out.printf("=> id=%d name = %s\t",curEmp.id,curEmp.name);
			System.out.println();
			if(curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
	}
	public Emp findEmpById(int id) {
		if(head == null) {
			System.out.println("链表为空");
			return null;
		}
		Emp curEmp = head;
		while(true) {
			if(curEmp.id == id) {
				break;
			}
			if(curEmp.next == null) {
				curEmp =null;
				break;
			}
			curEmp = curEmp.next;
		}
		
		return curEmp;
	}
	public void delete(int id) {
		if(head == null) {
			System.out.println("链表为空");
			return;
		}
		
		Emp curEmp = head;
		boolean flag1 = false;
		boolean flag2 = false;
		while(true) {
			if(head.id == id) {
				flag1 = true;
				break;
			}
			if (curEmp.next.id == id) {
					flag2 = true;
					break;
				}
			if (curEmp.next == null) {
				System.out.println("没有要删除的节点");
				break;
			 }
			   curEmp = curEmp.next;
			}
		if (flag1) {
			head = null;
			System.out.println("asdasdassd");
		}else if(flag2){
			curEmp.next = curEmp.next.next;
		}
		
		else {
			System.out.printf("没有找到编号为%d的节点，不能删除\n",id);
		}
		

	}
}