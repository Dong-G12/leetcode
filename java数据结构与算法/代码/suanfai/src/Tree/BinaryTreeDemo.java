package Tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //先需要创建一颗二叉树
		BinaryTree binary = new BinaryTree();
		HeroNode root = new HeroNode(1,"宋江");
		HeroNode node2 = new HeroNode(2,"吴用");
		HeroNode node3 = new HeroNode(3,"卢俊义");
		HeroNode node4 = new HeroNode(4,"林冲");
		HeroNode node5 = new HeroNode(5,"关胜");
		HeroNode node6 = new HeroNode(6,"鲁智深");
		HeroNode node7 = new HeroNode(7,"李逵");
		//先手动创建二叉树，后面使用递归方式创建二叉树
		
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node6);
		node2.setRight(node7);
		node3.setRight(node4);
		node3.setLeft(node5);
		binary.setRoot(root);
		//测试
//		System.out.println("前序遍历：");
//		binary.setRoot(root);
//		binary.preOrder();
//		
//		System.out.println("中序遍历：");
//		binary.infixOrder();
//		
//		System.out.println("后序遍历：");
//		binary.postOrder();
//		
//		System.out.println("前序遍历查找：");
//		HeroNode resNode = binary.preOrderSearch(5);
//		if(resNode != null) {
//			System.out.printf("找到了，信息为no = %d ，name = %s",resNode.getNo(),resNode.getName());
//		}else {
//			System.out.printf("没有找到，信息为no = %d的英雄",5);
//		}
		
//		System.out.println("中序遍历查找：");
//		HeroNode resNode = binary.infixOrderSearch(5);
//		if(resNode != null) {
//			System.out.printf("找到了，信息为no = %d ，name = %s",resNode.getNo(),resNode.getName());
//		}else {
//			System.out.printf("没有找到，信息为no = %d的英雄",5);
//		}
//		
//		System.out.println("后序遍历查找：");
//		HeroNode resNode = binary.postOrderSearch(15);
//		if(resNode != null) {
//			System.out.printf("找到了，信息为no = %d ，name = %s",resNode.getNo(),resNode.getName());
//		}else {
//			System.out.printf("没有找到，信息为no = %d的英雄",15);
//		}
		System.out.println("删除前，前序遍历：");
		binary.setRoot(root);
		binary.preOrder();
		binary.delete(5);
		System.out.println("删除后，前序遍历：");
		binary.preOrder();
	}

}
//定义二叉树
class BinaryTree{
	private HeroNode root;
	
	public void setRoot(HeroNode root) {
		this.root = root;
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
			System.out.println("空树，不能删除");
		}
	}
	
	
}
class HeroNode{
	private int no;
	private String name;
	private HeroNode right;//默认为null
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