package avl;


public class AVLTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            //int[] arr = {4,3,6,5,7,8};
		
		    //int[] arr = {10,12,8,9,7,6};
		
		    int[] arr = {10,11,7,6,8,9};
            AVLTree avltree = new AVLTree();
            
            for(int i = 0;i< arr.length;i++) {
            	avltree.add(new Node(arr[i]));
            }
            System.out.println("�������");
            avltree.infixOrder();
            
            System.out.println("��ƽ�⴦���--");
            System.out.println("���ĸ߶�="+avltree.getRoot().height());
            System.out.println("�������ĸ߶�="+avltree.getRoot().left.height());
            System.out.println("�������ĸ߶�="+avltree.getRoot().right.height());
            System.out.println("��ǰ���ڵ�Ϊ"+avltree.getRoot());
            System.out.println("��ǰ���ڵ�����ӽ��Ϊ"+avltree.getRoot().left);
            System.out.println("��ǰ���ڵ�����ӽ��Ϊ"+avltree.getRoot().right);
	}

}


//
class AVLTree{
    private Node root;
    
	public Node getRoot() {
		return root;
	}
	public Node search(int value) {
		if(root == null) {
			return null;
		}else {
			return root.search(value);
		}
	}
	/**
	 * 
	 * @param node  ����Ľڵ�
	 * @return ������nodeΪ���ڵ�Ķ�������������С�ڵ��ֵ
	 * ɾ����nodeΪ���ڵ�Ķ�������������С�ڵ��ֵ
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
	//ɾ�����
	
	public void delNode(int value) {
		if(root == null) {
			return;
		}else {
			Node targetNode = search(value);
			if(targetNode ==null) {
				return;
			}
			//������Ƿ��ֵ�ǰ��Ŷ���������ֻ��һ�����
			if(root.left == null && root.right == null) {
				root = null;
				return;
			}
			
			//ȥ�ҵ�targetNode�ĸ��ڵ�
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
				//�ж�targetNode�Ǹ��ڵ�����ӽ�㻹�����ӽ��
				if(parent.left != null && parent.left.value == value) {
					parent.left = null;
				}else if(parent.right != null && parent.right.value == value) {
					parent.right = null;
				}
			}else if(targetNode.left != null && targetNode.right != null ) {
				int minVal = delRightTreeMin(targetNode.right);
				targetNode.value = minVal;
			}else { //ɾ��ֻ��һ�������Ľڵ�
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
			System.out.println("������Ϊ�գ����ܱ���");
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
	//�����������ĸ߶�
	public int leftHeight() {
		if(this.left == null) {
			return 0;
		}
		return this.left.height();
	}	
	//�����������ĸ߶�
		public int RightHeight() {
			if(this.right == null) {
				return 0;
			}
			return this.right.height();
		}	
	//���ص�ǰ�ڵ�ĸ߶ȣ��Ըýڵ�Ϊ���ڵ�����ĸ߶�	
	public int height() {
		return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height())+1;
	} //?����this��Ϊʲô���ﲻ��thisҲ����
		
	//����ת����
	
	private void leftRotate() {
		Node newnode = new Node(value);
		//���µĽڵ�����������óɵ�ǰ�ڵ��������		
		newnode.left = left;	
		//���µĽڵ�����������óɵ�ǰ�ڵ����������������		
		newnode.right = right.left;		
		//�ѵ�ǰ�ڵ��ֵ�滻�����ӽ���ֵ		
		value = right.value;		
		//�ѵ�ǰ�������������óɵ�ǰ������������������		
		right = right.right;		
		//�ѵ�ǰ�������ӽ�����ó��µĽ��		
		left = newnode;		
	}
	
	//����ת
	private void rightRotate() {
		Node newnode = new Node(value);
		//���µĽڵ�����������óɵ�ǰ�ڵ��������		
		newnode.right = this.right;	
		//���µĽڵ�����������óɵ�ǰ�ڵ����������������		
		newnode.left = this.left.right;		
		//�ѵ�ǰ�ڵ��ֵ�滻�����ӽ���ֵ		
		value = this.left.value;		
		//�ѵ�ǰ�������������óɵ�ǰ������������������		
		this.left = this.left.left;		
		//�ѵ�ǰ�������ӽ�����ó��µĽ��		
		this.right = newnode;		
	}
	//����Ҫɾ���Ľ��
	
	public Node search(int value) {
		if(value == this.value) {
			return this;
		}else if(value < this.value) { //������ҵ�ֵС�ڵ�ǰ��㣬���������ݹ����
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
	
	
	//����Ҫɾ�����ĸ��ڵ�
	/**
	 * 
	 */
	public Node searchParent(int value) {
		//�����ǰ������Ҫɾ���Ľ��ĸ��ڵ�
		if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			  return this;
		}else {
			//������ҵ�ֵС�ڵ�ǰ����ֵ�����ҵ�ǰ�������ӽ�㲻Ϊ��
			
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



	//�ݹ����ʽ��ӽ��
	public void add(Node node) {
		if(node == null) {
			return;
		}
		
		//�жϴ���Ľ���ֵ���͵�ǰ�����ĸ��ڵ��ֵ�Ĺ�ϵ
		
		if(node.value < this.value) {
			if(this.left == null) {
				this.left = node;
			}else {
				this.left.add(node);
			}
		}else { //��ӵĽ��ֵ���ڵ�ǰ����ֵ
			if(this.right == null) {
				this.right = node;
			}else {
				this.right.add(node);
			}
		}
		//�������һ������������������ĸ߶�-�������ĸ߶ȣ���1������ת
		
		if(RightHeight() - leftHeight() > 1) {
			
			//����������������������ĸ߶ȴ��������������ĸ߶�
			if(left != null && left.RightHeight() > left.leftHeight()) {
				right.rightRotate();
				leftRotate();
			}else {
				//ֱ�ӽ�������ת����
				leftRotate();
			}
			
			return;
		}
		
		if(leftHeight() - RightHeight() > 1) {
			
			//����������������������ĸ߶ȴ��������������ĸ߶�
			if(left != null && left.RightHeight() > left.leftHeight()) {
				left.leftRotate();
				rightRotate();
			}else {
				//ֱ�ӽ�������ת����
				rightRotate();
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