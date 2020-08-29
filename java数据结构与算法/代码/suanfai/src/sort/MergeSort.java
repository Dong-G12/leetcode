package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //int arr[] = {8,4,5,1,3,6,2};
		int[] arr = new int[80000];
		int temp[] = new int[arr.length];
		for(int i=0; i<80000;i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datelStr = simpleDateFormat.format(date1);
		System.out.println("排序前的时间是=" + datelStr);
		mergeSort(arr, 0, arr.length-1, temp);
		// 希尔排序的第一轮排序
        Date date2 = new Date();
		String date2lStr = simpleDateFormat.format(date2);
		System.out.println("排序后的时间是=" + date2lStr);
        //System.out.println("归并排序=" + Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
	  if(left < right) {
		  int mid = (left+right)/2; 
		  //向左递归
		  mergeSort(arr,left,mid,temp);
		  //向右递归
		  mergeSort(arr,mid+1,right,temp);
		  merge(arr, left, mid, right, temp);
	  }
	
	}
	
	public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i = left;
		int j = mid+1;
		int t = 0;//指向temp数组的当前索引
//		System.out.print(left);
//		System.out.print(right);
//		System.out.println();
		//先把左右两边的数据按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完毕为止
		while(i<=mid && j<= right) {
			if(arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t+=1;
				i+=1;
			}else {
				temp[t] = arr[j];
				t+=1;
				j+=1;

			}
		}
		while(i<=mid) {
			temp[t] =arr[i];
			t+=1;
			i+=1;
		}
		while(j<=right) {
			temp[t] =arr[j];
			t+=1;
			j+=1;
		}
		
		//并不是每次都拷贝所有的
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t+=1;
			tempLeft += 1;
		}
		
	}
}
