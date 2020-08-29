package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
   
	
	public static void main(String[] args) {
	  //int[] arr = {53,3,542,748,14,214,567,23,567,789};
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
		}
		
		System.out.println("����ǰ");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ����=" + date1Str);
	    radixSort(arr);
	    Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ����=" + date2Str);
	  //System.out.println(Arrays.toString(arr));
} 
	public static void radixSort(int[] arr) {
		//��ά�������10��һά����
		//Ϊ�˷�ֹ��������ʱ�������������ÿһ��һά����ֻ�ܶ���Ϊarr.length
		//����������ʹ�ÿռ任ʱ��ľ����㷨
		int[][] bucket = new int[10][arr.length];
		
		//�õ�����������λ��
		int max = arr[0];
		for(int i = 1;i<arr.length;i++){
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		//max���Ͽ��ַ�������ַ�����Ȼ�������䳤��
		int maxLength = (max+"").length();
		//Ϊ�˼�¼ÿ��Ͱ�з�����ٸ����ݣ�����һ��һά��������¼����Ͱ��ÿ�η������ݵĸ���
		
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
				// ���Ͱ�������ݲŷ��뵽ԭ����
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
