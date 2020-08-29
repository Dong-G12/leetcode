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
	
	//写出我们的kmp搜索算法
	/**
	 * 
	 * @param str1  原字符串
	 * @param str2 子串
	 * @param next 部分匹配表
	 * @return 
	 */
	public static int kmpSearch(String str1,String str2,int[] next) {
		for(int i = 0,j=0; i<str1.length();i++) {
			//需要处理str1.charAt(i) != str2.charAt(j)
			//KMP算法核心点
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
	
	//得到一个字符串的部分匹配表
	public static  int[] kmpNext(String dest) {
		//创建一个next数组，保存部分匹配值
		int[] next = new int[dest.length()];
		
		next[0] = 0; //如果字符串是长度为1，部分 匹配值就是0
		
		for(int i = 1,j=0;i<dest.length();i++) {
			//当dest.charAt(i) != dest.charAt(j),我们需要从next[j-1]获取新的j
			//直到我们发现有当dest.charAt(i) == dest.charAt(j)成立时才退出
			
			while( j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = next[j-1];
			}
			
			if(dest.charAt(i) == dest.charAt(j)) { //当这个条件满足时，部分匹配值就是要加一
				j++;
			}
			
			next[i] = j;
		}
		
		return next;
		
	}

}
