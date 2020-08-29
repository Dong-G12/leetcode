package HashTab;

import java.util.Scanner;

public class HashtabDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           //����һ����ϣ��
		HashTab hashTab = new HashTab(7);
		String key="";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("add:��ӹ�Ա");
			System.out.println("list:��ʾ��Ա");
			System.out.println("find:�ҹ�Ա");
			System.out.println("delete:ɾ����Ա");	
			System.out.println("exit:�˳�ϵͳ");
			key = scanner.next();
			switch(key) {
			case "add":
				System.out.println("����id");
				int id = scanner.nextInt();
				System.out.println("��������");
				String name = scanner.next();
				Emp emp = new Emp(id,name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("������Ҫ���ҵ�id");
				id = scanner.nextInt();
				hashTab.findEmployID(id);
				break;
			case "delete":
				System.out.println("������Ҫɾ����id");
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
//���������������
class HashTab{
	private EmpLinkedList[] emLinkedListArray;
	private int size; //��ʾ���ж���������
	//������
	
	public HashTab(int size) {
		//��ʼ��emLinkedListArray
		this.size = size;
		emLinkedListArray = new EmpLinkedList[size];
		//?��һ����
		for(int i = 0;i<size;i++) {
			emLinkedListArray[i] = new EmpLinkedList();
		}
	}
	//��ӹ�Ա
	public void add(Emp emp) {
		//����Ա����id���õ���Ա��Ӧ����ӵ���������
		int emLinkedListArrayNo = hashFunc(emp.id);
		emLinkedListArray[emLinkedListArrayNo].add(emp);
	}
	//�������е�����
	public void list() {
		for(int i =0;i<size;i++) {
			emLinkedListArray[i].list(i);
		}
	}
	
	
	//��дһ��ɢ�к�����ʹ��һ���򵥵�ȡģ��
	
	public int hashFunc(int id) {
		return id % size;
	}
	
	public void findEmployID(int id) {
		int emLinkedListArrayNo = hashFunc(id);
		Emp emp = emLinkedListArray[emLinkedListArrayNo].findEmpById(id);
		if(emp != null) {
			System.out.printf("�ڵ�%d���������ҵ���Ա id = %d\n",(emLinkedListArrayNo+1),id);
		}else {
			System.out.println("�ڹ�ϣ���У�û���ҵ��ù�Ա");
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
	public Emp next;//Ĭ��Ϊnull
	public Emp(int id,String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

//����EmpLinkedList,��ʾ����
class EmpLinkedList{
	//ͷָ�룬ָ���һ����ԱEmp�������������headֱ��ָ���һ��Emp
	private Emp head;
	
	//��ӹ�Ա������
	
	public void add(Emp emp) {
		//�������ӵ�һ����Ա
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
		//�˳�ʱֱ�ӽ�emp��������
		curEmp.next = emp;
	}
	
	public void list(int no) {
		if(head == null) {
			System.out.println("��"+(no+1)+"������Ϊ��");
			return;
		}
		System.out.print("��"+(no+1)+"���������ϢΪ");
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
			System.out.println("����Ϊ��");
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
			System.out.println("����Ϊ��");
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
				System.out.println("û��Ҫɾ���Ľڵ�");
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
			System.out.printf("û���ҵ����Ϊ%d�Ľڵ㣬����ɾ��\n",id);
		}
		

	}
}