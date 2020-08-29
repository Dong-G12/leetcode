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
         System.out.println("前驱节点为=" + leftnode);
         System.out.println("后继节点为=" + rightnode);
         
         System.out.println("使用线索化的方式遍历线索化二叉树");
         threadedBinaryTree.threadList();
	}

}

class ThreadedBinaryTree{
	private HeroNode root;
	//为了实现线索化，需要创建指向当前节点的前驱节点 的指针
	//在递归进行线索化时，这个pre总是保留前一个结点
	private HeroNode pre = null;
	
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	public void threadedNodes() {
		this.threadedNodes(root);
	}
	
	//遍历线索化二叉树的方法
	public void threadList() {
		//定义一个变量，存储当前遍历的节点
		
		HeroNode node = root;
		while(node != null) {
			while(node.getLefttype() == 0) {
				node = node.getLeft();
			}
			
			System.out.println(node);
			
			while(node.getRighttype() == 1) {
				//获取到当前节点的后继节点
				
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
	
	
	
	
	
	
	
	//编写对二叉树进行中序线索化的方法
	
	public void threadedNodes(HeroNode node) {
		if(node == null) {
			return;
		}
		//
		threadedNodes(node.getLeft());
		if(node.getLeft() == null) {
			//让当前结点的左指针指向前驱结点
			node.setLeft(pre);
			node.setLefttype(1);
		}
		
		//处理后继结点
		if(pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRighttype(1);
		}
		
		pre = node;
		
		threadedNodes(node.getRight());
		
		
	}
	
	
	
	
	
	
	
	//前序遍历
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
		
	}
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
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
	private HeroNode right;//默认为null
	private HeroNode left;
	
	//如果lefttype = 0，表示指向的是左子树，如果是1的话则表示指向前驱节点
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
	//编写前序遍历的方法
	public void preOrder() {
		System.out.println(this);//先输出父节点
		//递归向左子树遍历
		if(this.left != null) {
			this.left.preOrder();
		}
		//递归向右子树遍历
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	//中序遍历
	public void infixOrder() {
		//递归向左子树遍历
		if(this.left != null) {
			this.left.infixOrder();
		}
		//输出父节点
		System.out.println(this);
		//递归向右子树遍历
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	
	//后序遍历
	public void postOrder() {
		//递归向左子树遍历
		if(this.left != null) {
			this.left.postOrder();
		}
		//递归向右子树遍历
		if(this.right != null) {
			this.right.postOrder();
		}
		//输出父节点
		System.out.println(this);
	}
	
	//前序遍历查找
	public HeroNode preOrdersearch(int no) {
		System.out.println("进入前序遍历查找");
		if(this.no == no) {
			return this;
		}
		
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.preOrdersearch(no);
		}
		//递归向右子树遍历
		if(resNode != null) {
			return resNode; 
		}
		if(this.right != null) {
			resNode = this.right.preOrdersearch(no);
		}
		return resNode;
	}
	
	//中序遍历查找
	public HeroNode infixOrdersearch(int no) {
		
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.infixOrdersearch(no);
		}
		if(resNode != null) {
			return resNode; 
		}
		System.out.println("进入中序查找");
		
		if(this.no == no) {
			return this;
		}
		
		if(this.right != null) {
			resNode = this.right.infixOrdersearch(no);
		}
		return resNode;
	}
	//后序遍历查找
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
		System.out.println("进入后序查找");
		if (this.no == no) {
			return this;
		}

		return resNode;
	}
	
	//删除节点
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