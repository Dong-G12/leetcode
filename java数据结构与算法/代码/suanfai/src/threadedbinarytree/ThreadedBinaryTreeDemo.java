package threadedbinarytree;



public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         HeroNode root = new HeroNode(1,"tom");
         HeroNode node2 = new HeroNode(3,"jack");
         HeroNode node3 = new HeroNode(6,"smith");
         HeroNode node4 = new HeroNode(8,"mary");
         HeroNode node5 = new HeroNode(10,"king");
         HeroNode node6 = new HeroNode(14,"dim");
         
         
         root.setLeft(node2);
         root.setRight(node3);
         node2.setLeft(node4);
         node2.setRight(node5);
         node3.setLeft(node6);
         
         ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
         threadedBinaryTree.setRoot(root);
         threadedBinaryTree.threadedNodes();
         
         HeroNode leftnode = node5.getLeft();
         HeroNode rightnode = node5.getRight();
         System.out.println("ǰ���ڵ�Ϊ=" + leftnode);
         System.out.println("��̽ڵ�Ϊ=" + rightnode);
         
         System.out.println("ʹ���������ķ�ʽ����������������");
         threadedBinaryTree.threadList();
	}

}

class ThreadedBinaryTree{
	private HeroNode root;
	//Ϊ��ʵ������������Ҫ����ָ��ǰ�ڵ��ǰ���ڵ� ��ָ��
	//�ڵݹ����������ʱ�����pre���Ǳ���ǰһ�����
	private HeroNode pre = null;
	
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	public void threadedNodes() {
		this.threadedNodes(root);
	}
	
	//�����������������ķ���
	public void threadList() {
		//����һ���������洢��ǰ�����Ľڵ�
		
		HeroNode node = root;
		while(node != null) {
			while(node.getLefttype() == 0) {
				node = node.getLeft();
			}
			
			System.out.println(node);
			
			while(node.getRighttype() == 1) {
				//��ȡ����ǰ�ڵ�ĺ�̽ڵ�
				
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
	
	
	
	
	
	
	
	//��д�Զ��������������������ķ���
	
	public void threadedNodes(HeroNode node) {
		if(node == null) {
			return;
		}
		//
		threadedNodes(node.getLeft());
		if(node.getLeft() == null) {
			//�õ�ǰ������ָ��ָ��ǰ�����
			node.setLeft(pre);
			node.setLefttype(1);
		}
		
		//�����̽��
		if(pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRighttype(1);
		}
		
		pre = node;
		
		threadedNodes(node.getRight());
		
		
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

}






class HeroNode{
	private int no;
	private String name;
	private HeroNode right;//Ĭ��Ϊnull
	private HeroNode left;
	
	//���lefttype = 0����ʾָ������������������1�Ļ����ʾָ��ǰ���ڵ�
	private int lefttype;
	public int getLefttype() {
		return lefttype;
	}
	public void setLefttype(int lefttype) {
		this.lefttype = lefttype;
	}
	public int getRighttype() {
		return righttype;
	}
	public void setRighttype(int righttype) {
		this.righttype = righttype;
	}

	private int righttype;
	
	
	
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