package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class selectsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        int[] arr = {1091,80,9,-19,123,45,678};
		int[] arr = new int[80000];
		for(int i=0; i<80000;i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datelStr = simpleDateFormat.format(date1);
		System.out.println("排序前的时间是=" + datelStr);
        selectSort(arr);
        //System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
		String date2lStr = simpleDateFormat.format(date2);
		System.out.println("排序后的时间是=" + date2lStr);
	}
	
	//选择排序
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}

}
