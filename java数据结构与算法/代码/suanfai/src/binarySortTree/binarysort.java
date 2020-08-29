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
        
        //����һ��ɾ��Ҷ�ӽڵ�
        binarySort.delNode(7);
        System.out.println("ɾ���ڵ��");
        binarySort.delNode(3);
        binarySort.infixOrder();
	}

}

//��������������
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


