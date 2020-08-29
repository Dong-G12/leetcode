package huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
	  int arr[] = {13,7,8,3,29,6,1};
	  //�����շ������ķ���
	  Node root = createHuffmanTree(arr);
	  preOrder(root);
    }
    
    public static void preOrder(Node root) {
    	if(root != null) {
    		root.preOrder();
    	}else {
    		System.out.println("�ǿ��������ܱ���");
    	}
    }
	public static Node createHuffmanTree(int[] arr) {
	  //��һ��Ϊ�˲�������
	  //1������arr����
	//2����arr��ÿ��Ԫ�ع���һ��Node
		//3����Node���뵽ArrayList��
		List<Node> nodes = new ArrayList<Node>();
		for(int value :arr) {
			nodes.add(new Node(value));
		}
		//���Ǵ���Ĺ�����һ��ѭ���Ĺ���
		while(nodes.size() >1) {
			
		
		
		
		//����
		Collections.sort(nodes);
		System.out.println("nodes = "+nodes);
		
		Node leftNode = nodes.get(0);
		Node rightNode = nodes.get(1);
		
		Node parent = new Node(leftNode.value + rightNode.value);
		parent.left = leftNode;
		parent.right = rightNode;
		
		nodes.remove(leftNode);
		nodes.remove(rightNode);
		
		nodes.add(parent);
		
		}
		//
		return nodes.get(0);
	  }
	

}

//�����ڵ���
//Ϊ����Node�����������Collextions��������
//��Node ʵ��Comparable�ӿ�
class Node implements Comparable<Node>{
	int value;
	Node left;
	Node right;
	
	//ǰ�����
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	
	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.value - o.value;	
	}
	
	
	
}