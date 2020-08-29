package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
   
	
	public static void main(String[] args) {
	  //int[] arr = {53,3,542,748,14,214,567,23,567,789};
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}
		
		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);
	    radixSort(arr);
	    Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
	  //System.out.println(Arrays.toString(arr));
} 
	public static void radixSort(int[] arr) {
		//二维数组包含10个一维数组
		//为了防止放入数的时候，数据溢出，则每一个一维数组只能定义为arr.length
		//基数排序是使用空间换时间的经典算法
		int[][] bucket = new int[10][arr.length];
		
		//得到数组中最大的位数
		int max = arr[0];
		for(int i = 1;i<arr.length;i++){
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		//max加上空字符串变成字符串，然后再求其长度
		int maxLength = (max+"").length();
		//为了记录每个桶中放入多少个数据，定义一个一维数组来记录各个桶的每次放入数据的个数
		
		int[] bucketElementCounts = new int[10];
		for (int i = 0,n=1; i < maxLength; i++,n*=10) {
			for (int j = 0; j < arr.length; j++) {
				//int digitOfElment = (int) (arr[j]/Math.pow(10, i) % 10);
				int digitOfElment = arr[j] / n % 10;
				bucket[digitOfElment][bucketElementCounts[digitOfElment]] = arr[j];
				bucketElementCounts[digitOfElment]++;
			}
			int index = 0;
			for (int k = 0; k < bucketElementCounts.length; k++) {
				// 如果桶中有数据才放入到原数组
				if (bucketElementCounts[k] != 0) {
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						arr[index] = bucket[k][l];
						index++;
					}
				}
				bucketElementCounts[k] = 0;
			}

		}
	}
}
