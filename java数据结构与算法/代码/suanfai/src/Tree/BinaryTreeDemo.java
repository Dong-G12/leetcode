package Tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //����Ҫ����һ�Ŷ�����
		BinaryTree binary = new BinaryTree();
		HeroNode root = new HeroNode(1,"�ν�");
		HeroNode node2 = new HeroNode(2,"����");
		HeroNode node3 = new HeroNode(3,"¬����");
		HeroNode node4 = new HeroNode(4,"�ֳ�");
		HeroNode node5 = new HeroNode(5,"��ʤ");
		HeroNode node6 = new HeroNode(6,"³����");
		HeroNode node7 = new HeroNode(7,"����");
		//���ֶ�����������������ʹ�õݹ鷽ʽ����������
		
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node6);
		node2.setRight(node7);
		node3.setRight(node4);
		node3.setLeft(node5);
		binary.setRoot(root);
		//����
//		System.out.println("ǰ�������");
//		binary.setRoot(root);
//		binary.preOrder();
//		
//		System.out.println("���������");
//		binary.infixOrder();
//		
//		System.out.println("���������");
//		binary.postOrder();
//		
//		System.out.println("ǰ��������ң�");
//		HeroNode resNode = binary.preOrderSearch(5);
//		if(resNode != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪno = %d ��name = %s",resNode.getNo(),resNode.getName());
//		}else {
//			System.out.printf("û���ҵ�����ϢΪno = %d��Ӣ��",5);
//		}
		
//		System.out.println("����������ң�");
//		HeroNode resNode = binary.infixOrderSearch(5);
//		if(resNode != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪno = %d ��name = %s",resNode.getNo(),resNode.getName());
//		}else {
//			System.out.printf("û���ҵ�����ϢΪno = %d��Ӣ��",5);
//		}
//		
//		System.out.println("����������ң�");
//		HeroNode resNode = binary.postOrderSearch(15);
//		if(resNode != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪno = %d ��name = %s",resNode.getNo(),resNode.getName());
//		}else {
//			System.out.printf("û���ҵ�����ϢΪno = %d��Ӣ��",15);
//		}
		System.out.println("ɾ��ǰ��ǰ�������");
		binary.setRoot(root);
		binary.preOrder();
		binary.delete(5);
		System.out.println("ɾ����ǰ�������");
		binary.preOrder();
	}

}
//���������
class BinaryTree{
	private HeroNode root;
	
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	//ǰ�����
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
		
	}
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	
	public HeroNode preOrderSearch(int no) {
		if(this.root != null) {
			return this.root.preOrdersearch(no);
		}else {
			return null;
		}
		
	}
	
	public HeroNode infixOrderSearch(int no) {
		if(this.root != null) {
			return this.root.infixOrdersearch(no);
		}else {
			return null;
		}
		
	}
	
	public HeroNode postOrderSearch(int no) {
		if(this.root != null) {
			return this.root.postOrdersearch(no);
		}else {
			return null;
		}
		
	}
	
	
	public void delete(int no) {
		if(root != null) {
			if(root.getNo() == no) {
				root = null;
			}else {
				root.delete(no);
			}
		}else {
			System.out.println("����������ɾ��");
		}
	}
	
	
}
class HeroNode{
	private int no;
	private String name;
	private HeroNode right;//Ĭ��Ϊnull
	private HeroNode left;
	public HeroNode(int no,String name) {
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeroNode getRight() {
		return right;
	}
	public void setRight(HeroNode right) {
		this.right = right;
	}
	public HeroNode getLeft() {
		return left;
	}
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	//��дǰ������ķ���
	public void preOrder() {
		System.out.println(this);//��������ڵ�
		//�ݹ�������������
		if(this.left != null) {
			this.left.preOrder();
		}
		//�ݹ�������������
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	//�������
	public void infixOrder() {
		//�ݹ�������������
		if(this.left != null) {
			this.left.infixOrder();
		}
		//������ڵ�
		System.out.println(this);
		//�ݹ�������������
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	
	//�������
	public void postOrder() {
		//�ݹ�������������
		if(this.left != null) {
			this.left.postOrder();
		}
		//�ݹ�������������
		if(this.right != null) {
			this.right.postOrder();
		}
		//������ڵ�
		System.out.println(this);
	}
	
	//ǰ���������
	public HeroNode preOrdersearch(int no) {
		System.out.println("����ǰ���������");
		if(this.no == no) {
			return this;
		}
		
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.preOrdersearch(no);
		}
		//�ݹ�������������
		if(resNode != null) {
			return resNode; 
		}
		if(this.right != null) {
			resNode = this.right.preOrdersearch(no);
		}
		return resNode;
	}
	
	//�����������
	public HeroNode infixOrdersearch(int no) {
		
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.infixOrdersearch(no);
		}
		if(resNode != null) {
			return resNode; 
		}
		System.out.println("�����������");
		
		if(this.no == no) {
			return this;
		}
		
		if(this.right != null) {
			resNode = this.right.infixOrdersearch(no);
		}
		return resNode;
	}
	//�����������
	public HeroNode postOrdersearch(int no) {
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrdersearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		if (this.right != null) {
			resNode = this.right.postOrdersearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("����������");
		if (this.no == no) {
			return this;
		}

		return resNode;
	}
	
	//ɾ���ڵ�
	public void delete(int no) {
		if(this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		if(this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		
		if(this.left != null) {
			this.left.delete(no);
		}
		if(this.right != null) {
			this.right.delete(no);
		}
	}
	
}