package KMP;

import java.util.Arrays;

public class KMPalgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String str1 = "BBC ABCDAB ABCDABCDABDE";
         
         String str2 = "ABCDABD";
         
         int[] next = kmpNext("ABCDABD");
         System.out.println(Arrays.toString(next));
         
         int index = kmpSearch(str1, str2, next);
         System.out.println("index = "+ index);
         
	}
	
	//д�����ǵ�kmp�����㷨
	/**
	 * 
	 * @param str1  ԭ�ַ���
	 * @param str2 �Ӵ�
	 * @param next ����ƥ���
	 * @return 
	 */
	public static int kmpSearch(String str1,String str2,int[] next) {
		for(int i = 0,j=0; i<str1.length();i++) {
			//��Ҫ����str1.charAt(i) != str2.charAt(j)
			//KMP�㷨���ĵ�
			while(j > 0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j-1];
			}
			if(str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if(j==str2.length()) {
				return i-j+1;
			}
		}
		return -1;
	}
	
	//�õ�һ���ַ����Ĳ���ƥ���
	public static  int[] kmpNext(String dest) {
		//����һ��next���飬���沿��ƥ��ֵ
		int[] next = new int[dest.length()];
		
		next[0] = 0; //����ַ����ǳ���Ϊ1������ ƥ��ֵ����0
		
		for(int i = 1,j=0;i<dest.length();i++) {
			//��dest.charAt(i) != dest.charAt(j),������Ҫ��next[j-1]��ȡ�µ�j
			//ֱ�����Ƿ����е�dest.charAt(i) == dest.charAt(j)����ʱ���˳�
			
			while( j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j-1];
			}
			
			if(dest.charAt(i) == dest.charAt(j)) { //�������������ʱ������ƥ��ֵ����Ҫ��һ
				j++;
			}
			
			next[i] = j;
		}
		
		return next;
		
	}

}
