package search;

import java.util.Arrays;

public class InsertValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//           int[] arr =new int[100];
//           for(int i =0;i<100;i++) {
//        	   arr[i] = i+1;  
//           }
		   int arr[] = {1,8,10,89,1000,1234};
           int index = insertValueSearch(arr, 0, arr.length-1,1);
           System.out.println(index);
	}
    
	//��ֵ�����㷨ҲҪ�������������
	public static int insertValueSearch(int[] arr,int left,int right,int findVal) {
		//ע��findVal < arr[0] || findVal < arr[arr.length-1]��������Ҫ������õ���ֵ����Խ��
		System.out.println("���Ҵ���");
		if(left > right || findVal < arr[0] || findVal > arr[arr.length-1] ) {
			return -1;
		}
		int mid = left +(right - left)*(findVal-arr[left])/(arr[right] - arr[left]);
		int midVal = arr[mid];
		if(findVal > midVal) {
			   return insertValueSearch(arr,mid+1,right,findVal);
			   
		   }else if(findVal < midVal) {
			   return insertValueSearch(arr,left,mid-1,findVal);
		   }else {
			  return mid; 
		   }
	}
}
