package KMP;

public class ViolenceMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "I am a String";  
//		char arr[] = str.toCharArray();  
//		for (int i = 0; i < arr.length; i++)  { 
//			System.out.println("arr[" + i + "]=" + arr[i]); 
//			}
		
		String str1 = "���� �й�����й� �й�����й�����й����"; 
		String str2 = "�й�����й���-"; 
		
		int index = violencematch(str1,str2);
		System.out.println("index=" + index);
	}
	
	//����ƥ���㷨
	
	public static int violencematch(String str1,String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		int s1Len = s1.length;
		int s2Len = s2.length;
		
		int i = 0;
		int j = 0;
		while(i<s1Len && j < s2Len) {
			if(s1[i] == s2[j]) {
				i++;
				j++;
			}else {
				i = i-j+1;
				j = 0;
			}
		}
		
		//�ж��Ƿ�ƥ��ɹ�
		
		if(j == s2Len) {
			return i-j;
		}else {
			return -1;
		}
	}

}
