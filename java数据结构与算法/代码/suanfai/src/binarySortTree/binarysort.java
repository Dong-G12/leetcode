package binarySortTree;

public class binarysort{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //int[] arr = {7,3,10,12,5,1,9,0};
		int[] arr = {7,3};
        BinarySorttree binarySort = new BinarySorttree();
        for(int i =0;i<arr.length;i++) {
        	binarySort.add(new Node(arr[i]));
        }
        binarySort.infixOrder();
        
        //测试一下删除叶子节点
        binarySort.delNode(7);
        System.out.println("删除节点后");
        binarySort.delNode(3);
        binarySort.infixOrder();
	}

}

//创建二叉排序树
class BinarySorttree{
	private Node root;
	
	public Node search(int value) {
		if(root == null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	/**
	 * 
	 * @param node  传入的节点
	 * @return 返回以node为根节点的二叉排序树的最小节点的值
	 * 删除以node为根节点的二叉排序树的最小节点的值
	 */
	public int delRightTreeMin(Node node) {
		Node target = node;
		while(target.left != null) {
			target = target.left;
		}
		delNode(target.value);
		return target.value;
	}
	public Node searchParent(int value) {
		if(root == null) {
			return null;
		}else {
			return root.searchParent(value);
		}
	}
	//删除结点
	
	public void delNode(int value) {
		if(root == null) {
			return;
		}else {
			Node targetNode = search(value);
			if(targetNode ==null) {
				return;
			}
			//如果我们发现当前这颗二叉排序树只有一个结点
			if(root.left == null && root.right == null) {
				root = null;
				return;
			}
			
			//去找到targetNode的父节点
//			if(root.value == value && (root.left == null || root.right == null)){
//				if(root.left == null) {
//					root = root.right;
//					return;
//				}else {
//					root = root.left;
//					return;
//				}
//			}
			Node parent = searchParent(value);
			
			if(targetNode.left == null && targetNode.right == null ) {
				//判断targetNode是父节点的左子结点还是右子结点
				if(parent.left != null && parent.left.value == value) {
					parent.left = null;
				}else if(parent.right != null && parent.right.value == value) {
					parent.right = null;
				}
			}else if(targetNode.left != null && targetNode.right != null ) {
				int minVal = delRightTreeMin(targetNode.right);
				targetNode.value = minVal;
			}else { //删除只有一颗子树的节点
				if(targetNode.left != null) {
				  if(parent != null) {
					  if(parent.left.value == value) {
						  parent.left = targetNode.left;
					   }else {
						   parent.right = targetNode.left;
					   }
				    }else {
					     root = targetNode.left;
				    }
				}else{
					if(parent != null) {
					   if(parent.left.value == value) {
						   parent.left = targetNode.right;
					   }else {
						   parent.right = targetNode.right;
					   }
					}else {
						root = targetNode.right;
					}
				}
			}
			
		}
	}

	public void add(Node node) {
		if(root == null) {
			root = node;
		}else {
			root.add(node);
		}
	}
	public void infixOrder() {
		if(root != null) {
			root.infixOrder();
		}else {
			System.out.println("二叉树为空，不能遍历");
		}
	}
}

class Node{
	int value;
	Node left;
	Node right;	
	public Node(int value) {
		
		this.value = value;
	}
	
	//查找要删除的结点
	
	public Node search(int value) {
		if(value == this.value) {
			return this;
		}else if(value < this.value) { //如果查找的值小于当前结点，向左子树递归查找
			if(this.left == null) {
				return null;
			}
			
			return this.left.search(value);	
		}else {
			if(this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}
	
	
	//查找要删除结点的父节点
	/**
	 * 
	 */
	public Node searchParent(int value) {
		//如果当前结点就是要删除的结点的父节点
		if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			  return this;
		}else {
			//如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
			
			if(value < this.value && this.left != null) {
				 return this.left.searchParent(value);
			}else if(value >= this.value && this.right != null) {
				 return this.right.searchParent(value);
			}else {
				 return null;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}



	//递归的形式添加结点
	public void add(Node node) {
		if(node == null) {
			return;
		}
		
		//判断传入的结点的值，和当前子树的根节点的值的关系
		
		if(node.value < this.value) {
			if(this.left == null) {
				this.left = node;
			}else {
				this.left.add(node);
			}
		}else { //添加的结点值大于当前结点的值
			if(this.right == null) {
				this.right = node;
			}else {
				this.right.add(node);
			}
		}
	}
	
	
	public void infixOrder() {
		if(this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
}


