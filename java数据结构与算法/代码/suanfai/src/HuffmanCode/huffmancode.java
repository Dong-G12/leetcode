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
         
         System.out.println("ѹ����Ľ��"+Arrays.toString(huffmanCodeBytes)+"    ����Ϊ"+huffmanCodeBytes.length);
         
         //��ν����ݽ��н�ѹ�����룩
         
         System.out.println(byteToBitString((byte)1));
         
         //����byteTostring
         
         
//         List<Node> nodes = new ArrayList<Node>();
//         
//         nodes = getNodes(contentBytes);
//         
//         System.out.println("nodes=" + nodes);
//         
//         //
//         System.out.println("�շ�����");
//         Node huffmanTreeRoot = createHuffmanTree(nodes);
//         System.out.println("ǰ�����");
//         
//         huffmanTreeRoot.preOrder();
//         
//         
//         
//         //���Թ���������
//         
//         //getCodes(huffmanTreeRoot,"",stringBuilder);
//         Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);
//         System.out.println("���ɵĹ����������"+huffmanCodes);
//         
//        
//         byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
//         
//         System.out.println("huffmanCodeBytes"+ Arrays.toString(huffmanCodeBytes));
//         
	}
	//������ݵĽ�ѹ
	/**
	 * ��һ��byteת��һ�������Ƶ��ַ���
	 * @param b
	 * @return
	 */
	private static String byteToBitString(byte b) {
		int temp = b; 
		temp |= 256;
		System.out.println(temp);
		String str = Integer.toBinaryString(temp); //���ص���temp��Ӧ�Ķ����ƵĲ���
		System.out.println(str);
		return str.substring(str.length() - 8);
	}
	
	//ʹ��һ����������ǰ��ķ�����װ�������������ǵ���
    private static byte[] huffmanZip(byte[] bytes) {
    	
    	List<Node> nodes = new ArrayList<Node>();
        nodes = getNodes(bytes);
        
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        
        //��Ӧ�ĺշ������루���ݺշ�������
        Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);
        
        //�������ɵĺշ�������ѹ���õ�ѹ����ĺշ��������ֽ�����
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }
	
	//��дһ����������һ���ַ�����Ӧ��byte[]���飬ͨ�����ɵĺշ������������һ���շ������������һ���շ�������ѹ�����byte[]
	/**
	 * 
	 * @param bytes ԭʼ�ַ�����Ӧ��byte[]
	 * @param huffmanCodes ���ɵĺշ�������map
	 *
	 * @return ���غշ������봦����byte[]
	 */
	
	private static byte[]  zip(byte[] bytes,Map<Byte,String> huffmanCodes) {
		//1.������huffmanCodes ��  bytes ת�ɺշ��������Ӧ���ַ���
		
		StringBuilder stringBuilder2 = new StringBuilder();
		
		for(byte b:bytes) {
			stringBuilder.append(huffmanCodes.get(b));
			
		}
		//System.out.println("����stringBuilder= "+stringBuilder.toString());
	
	    //��1010100011111....ת��byte[]
		
		int len;
		if(stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length()/8;
		}else {
			len = stringBuilder.length()/8 + 1;
		}
		//����һ���洢ѹ�����byte����
		
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;
		for(int i = 0;i< stringBuilder.length();i+=8) {//��Ϊÿ8λ��Ӧһ��byte�����Բ���+8
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
	     
	
	
	//���ɺշ�������Ӧ�ĺշ��������
	//˼·��
	//1�����շ������������Map<Byte,String>��״
	//32-��01 ��97-��100
	//�����ɺշ��������ʾ����Ҫȥƴ��·��������һ��StringBuilder,�洢ĳ��Ҷ�ӽڵ��·��
	
	static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
	static StringBuilder stringBuilder = new StringBuilder();
	
	
	//����get code����
	private static Map<Byte,String> getCodes(Node root){
		if(root == null) {
			return null;
		}
		
		getCodes(root.left,"0",stringBuilder);
		getCodes(root.right,"1",stringBuilder);
		return huffmanCodes;
	}
	
	
	/**
	 * ���ܣ��������node�ڵ������Ҷ�ӽڵ�ĺշ�������õ��������뵽huffmancodes������
	 * @param node ����ڵ�
	 * @param code ·�������ӽڵ���0�����ӽڵ���1
	 * @param stringBuilder:����ƴ��·��
	 */
	
    public static void getCodes(Node node,String code,StringBuilder stringBuilder) {
    	     StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
    	     
    	     stringBuilder2.append(code);
    	     if(node != null) {
    	    	 //�жϵ�ǰnode��Ҷ�ӽڵ㻹�Ƿ�Ҷ�ӽڵ�
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
			System.out.println("�շ�����Ϊ��");
		}
	}
	
	public static List<Node> getNodes(byte[] bytes){
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		
		//�洢ÿһ��byte���ֵĴ���-��map[key,value]
		Map<Byte,Integer> counts = new HashMap<>();
		for(byte b:bytes) {
			Integer count = counts.get(b);
			if(count == null) {
				counts.put(b,1);
			}else {
				counts.put(b,count+1);
			}
		}
		
		//��ÿһ����ֵ��ת��һ��Node����
		
		for(Map.Entry<Byte, Integer> entry:counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		
		return nodes;
	}
	
	//ͨ��list������Ӧ
	private static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size() >1) {
			//����
			Collections.sort(nodes);
			
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parent = new Node(null,leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			
			//���µĶ����������뵽nodes
			nodes.add(parent);
			
			}
			//
			return nodes.get(0);
		  
		
	}
	
}

class Node implements Comparable<Node>{
	
	Byte data;//������ݱ������硰a�� -->97
	int weight;
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
	
