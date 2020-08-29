package huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
	  int arr[] = {13,7,8,3,29,6,1};
	  //创建赫夫曼树的方法
	  Node root = createHuffmanTree(arr);
	  preOrder(root);
    }
    
    public static void preOrder(Node root) {
    	if(root != null) {
    		root.preOrder();
    	}else {
    		System.out.println("是空树，不能遍历");
    	}
    }
	public static Node createHuffmanTree(int[] arr) {
	  //第一步为了操作方便
	  //1，遍历arr数组
	//2，将arr的每个元素构成一个Node
		//3，将Node放入到ArrayList中
		List<Node> nodes = new ArrayList<Node>();
		for(int value :arr) {
			nodes.add(new Node(value));
		}
		//我们处理的过程是一个循环的过程
		while(nodes.size() >1) {
			
		
		
		
		//排序
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

//创建节点类
//为了让Node对象持续排序Collextions集合排序
//让Node 实现Comparable接口
class Node implements Comparable<Node>{
	int value;
	Node left;
	Node right;
	
	//前序遍历
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