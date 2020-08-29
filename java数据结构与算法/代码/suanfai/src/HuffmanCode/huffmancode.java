package HuffmanCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class huffmancode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String content = "i like like like java do you like a java";
         
         
         byte[] contentBytes = content.getBytes();
         //System.out.println(Arrays.toString(contentBytes));
         System.out.println(contentBytes.length);
         byte[] huffmanCodeBytes = huffmanZip(contentBytes);
         
         System.out.println("压缩后的结果"+Arrays.toString(huffmanCodeBytes)+"    长度为"+huffmanCodeBytes.length);
         
         //如何将数据进行解压（解码）
         
         System.out.println(byteToBitString((byte)1));
         
         //测试byteTostring
         
         
//         List<Node> nodes = new ArrayList<Node>();
//         
//         nodes = getNodes(contentBytes);
//         
//         System.out.println("nodes=" + nodes);
//         
//         //
//         System.out.println("赫夫曼树");
//         Node huffmanTreeRoot = createHuffmanTree(nodes);
//         System.out.println("前序遍历");
//         
//         huffmanTreeRoot.preOrder();
//         
//         
//         
//         //测试哈夫曼编码
//         
//         //getCodes(huffmanTreeRoot,"",stringBuilder);
//         Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);
//         System.out.println("生成的哈弗曼编码表"+huffmanCodes);
//         
//        
//         byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
//         
//         System.out.println("huffmanCodeBytes"+ Arrays.toString(huffmanCodeBytes));
//         
	}
	//完成数据的解压
	/**
	 * 将一个byte转成一个二进制的字符串
	 * @param b
	 * @return
	 */
	private static String byteToBitString(byte b) {
		int temp = b; 
		temp |= 256;
		System.out.println(temp);
		String str = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码
		System.out.println(str);
		return str.substring(str.length() - 8);
	}
	
	//使用一个方法，将前面的方法封装起来，便于我们调用
    private static byte[] huffmanZip(byte[] bytes) {
    	
    	List<Node> nodes = new ArrayList<Node>();
        nodes = getNodes(bytes);
        
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        
        //对应的赫夫曼编码（根据赫夫曼树）
        Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);
        
        //根据生成的赫夫曼编码压缩得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }
	
	//编写一个方法，将一个字符串对应的byte[]数组，通过生成的赫夫曼编码表，生成一个赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]
	/**
	 * 
	 * @param bytes 原始字符串对应的byte[]
	 * @param huffmanCodes 生成的赫夫曼编码map
	 *
	 * @return 返回赫夫曼编码处理后的byte[]
	 */
	
	private static byte[]  zip(byte[] bytes,Map<Byte,String> huffmanCodes) {
		//1.先利用huffmanCodes 将  bytes 转成赫夫曼编码对应的字符串
		
		StringBuilder stringBuilder2 = new StringBuilder();
		
		for(byte b:bytes) {
			stringBuilder.append(huffmanCodes.get(b));
			
		}
		//System.out.println("测试stringBuilder= "+stringBuilder.toString());
	
	    //将1010100011111....转成byte[]
		
		int len;
		if(stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length()/8;
		}else {
			len = stringBuilder.length()/8 + 1;
		}
		//创建一个存储压缩后的byte数组
		
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;
		for(int i = 0;i< stringBuilder.length();i+=8) {//因为每8位对应一个byte，所以步长+8
			 String strByte;
			 if(i+8 > stringBuilder.length()) {
				 strByte = stringBuilder.substring(i);
			 }else {
			     strByte = stringBuilder.substring(i,i+8);
			 }
			 
			 huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2);
			 index++;
		}
		
		return huffmanCodeBytes;
	}
	     
	
	
	//生成赫夫曼树对应的赫夫曼编码表
	//思路：
	//1，将赫夫曼编码表存放在Map<Byte,String>形状
	//32-》01 ，97-》100
	//在生成赫夫曼编码表示，需要去拼接路径，定义一个StringBuilder,存储某个叶子节点的路径
	
	static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
	static StringBuilder stringBuilder = new StringBuilder();
	
	
	//重载get code方法
	private static Map<Byte,String> getCodes(Node root){
		if(root == null) {
			return null;
		}
		
		getCodes(root.left,"0",stringBuilder);
		getCodes(root.right,"1",stringBuilder);
		return huffmanCodes;
	}
	
	
	/**
	 * 功能：将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmancodes集合中
	 * @param node 传入节点
	 * @param code 路径：左子节点是0，右子节点是1
	 * @param stringBuilder:用于拼接路径
	 */
	
    public static void getCodes(Node node,String code,StringBuilder stringBuilder) {
    	     StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
    	     
    	     stringBuilder2.append(code);
    	     if(node != null) {
    	    	 //判断当前node是叶子节点还是非叶子节点
    	    	 if(node.data == null) {
    	    		 getCodes(node.left,"0",stringBuilder2);
    	    		 getCodes(node.right,"1",stringBuilder2);
    	    	 }else {
    	    		 huffmanCodes.put(node.data,stringBuilder2.toString());
    	    	 }
    	     }
    }
	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else {
			System.out.println("赫夫曼树为空");
		}
	}
	
	public static List<Node> getNodes(byte[] bytes){
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		
		//存储每一个byte出现的次数-》map[key,value]
		Map<Byte,Integer> counts = new HashMap<>();
		for(byte b:bytes) {
			Integer count = counts.get(b);
			if(count == null) {
				counts.put(b,1);
			}else {
				counts.put(b,count+1);
			}
		}
		
		//把每一个键值对转成一个Node对象
		
		for(Map.Entry<Byte, Integer> entry:counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		
		return nodes;
	}
	
	//通过list创建对应
	private static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size() >1) {
			//排序
			Collections.sort(nodes);
			
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parent = new Node(null,leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			
			//将新的二叉树，加入到nodes
			nodes.add(parent);
			
			}
			//
			return nodes.get(0);
		  
		
	}
	
}

class Node implements Comparable<Node>{
	
	Byte data;//存放数据本身，比如“a” -->97
	int weight;
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
	
	
	public Node(Byte data,int weight) {
		this.data = data;
		this.weight = weight;
	}

	
	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}


	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;	
	}
}	
	
