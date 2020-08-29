package Tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //int arr[] = {4,12,8,5,2,3,2,1,10,4,9};
//         adjustHeap(arr, 4, arr.length);
//         System.out.println("第一次"+Arrays.toString(arr));
		int[] arr = new int[8000000];
		for(int i=0; i<80000;i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datelStr = simpleDateFormat.format(date1);
		System.out.println("排序前的时间是=" + datelStr);
        heapSort(arr);
        Date date2 = new Date();
		String date2lStr = simpleDateFormat.format(date2);
		System.out.println("排序后的时间是=" + date2lStr);
	}
	
	//编写一个堆排序的方法
	public static void heapSort(int arr[]) {
		System.out.println("堆排序!");
		int temp = 0;
		for(int i = arr.length/2 - 1;i>=0;i--) {
			adjustHeap(arr,i,arr.length);
		}
		for(int j = arr.length-1;j>0;j--) {
			
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
			
		}
		
		//System.out.println(Arrays.toString(arr));
	}
	
	//将一个数组（二叉树），调整为一个大顶堆
	/**
	 * 功能：完成将以i对应的非叶子节点的树调整成大顶堆
	 * @param arr
	 * @param i 非叶子节点在数组中的索引
	 * @param length 表示多少个元素调整
	 */
	public static void adjustHeap(int arr[],int i,int length) {
		int temp = arr[i];//先取出当前元素的值，保存在临时变量
		for(int k = i*2 + 1;k<length; k = k*2 +1) {
			if(k+1<length && arr[k]<arr[k+1]) {//说明左子节点小于右子节点的值
				k++;
			}
			if(arr[k] > temp) {//如果子节点大于父节点
				arr[i] = arr[k];
				i = k;
			}else {
				break;
			}
		}//当for循环结束后,以i为父节点的树的最大值放在了最顶上（局部）
		
		arr[i] = temp;
	} 

}
