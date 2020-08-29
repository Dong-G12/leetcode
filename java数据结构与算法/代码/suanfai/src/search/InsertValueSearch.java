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
    
	//插值查找算法也要求数组是有序的
	public static int insertValueSearch(int[] arr,int left,int right,int findVal) {
		//注意findVal < arr[0] || findVal < arr[arr.length-1]，必须需要，否则得到的值可能越界
		System.out.println("查找次数");
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
