package search;


import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
public static void main(String[] args) {
	//使用二分查找的前提是该数组是有序的
	int arr[] = {1,8,10,89,1000,1234};
//	int resIndex = binarySearch(arr, 0, arr.length-1, 2);
//	System.out.println("resIndex=" + resIndex);
	List<Integer> resIndexList = binarySearch2(arr, 0, arr.length-1, 2);
	System.out.println("resIndex=" + resIndexList);
	
}
   public static int binarySearch(int[] arr,int left,int right,int findVal) {
	   
	   //当left > right时，说明没找到
	   int mid = (left + right) / 2;
	   int midVal = arr[mid];
	   if(left>right) {
		   return -1;
	   }
	   if(findVal > midVal) {
		   return binarySearch(arr,mid+1,right,findVal);
		   
	   }else if(findVal < midVal) {
		   return binarySearch(arr,left,mid-1,findVal);
	   }else {
		   
		   return mid;
	   }
			   
   }
public static List<Integer> binarySearch2(int[] arr,int left,int right,int findVal) {
	   
	   //当left > right时，说明没找到
	   int mid = (left + right) / 2;
	   int midVal = arr[mid];
	   if(left>right) {
		   return new ArrayList<Integer>();
	   }
	   if(findVal > midVal) {
		   return binarySearch2(arr,mid+1,right,findVal);
		   
	   }else if(findVal < midVal) {
		   return binarySearch2(arr,left,mid-1,findVal);
	   }else {
		   List<Integer> resIndexlist = new ArrayList<Integer>();
		   int temp = mid-1;
		   while(true) {
			   if(temp<0 || arr[temp] != findVal) {
				   break;
			   }
			   resIndexlist.add(temp);
			   temp -= 1;
		   }
		   resIndexlist.add(mid);
		   temp = mid+1;
		   while(true) {
			   if(temp>arr.length-1 || arr[temp] != findVal) {
				   break;
			   }
			   resIndexlist.add(temp);
			   temp += 1;
		   }
		   
		   return resIndexlist;
	   }
			   
   }
}
