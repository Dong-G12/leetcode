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
		System.out.println("����ǰ��ʱ����=" + datelStr);
		mergeSort(arr, 0, arr.length-1, temp);
		// ϣ������ĵ�һ������
        Date date2 = new Date();
		String date2lStr = simpleDateFormat.format(date2);
		System.out.println("������ʱ����=" + date2lStr);
        //System.out.println("�鲢����=" + Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
	  if(left < right) {
		  int mid = (left+right)/2; 
		  //����ݹ�
		  mergeSort(arr,left,mid,temp);
		  //���ҵݹ�
		  mergeSort(arr,mid+1,right,temp);
		  merge(arr, left, mid, right, temp);
	  }
	
	}
	
	public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i = left;
		int j = mid+1;
		int t = 0;//ָ��temp����ĵ�ǰ����
//		System.out.print(left);
//		System.out.print(right);
//		System.out.println();
		//�Ȱ��������ߵ����ݰ��չ�����䵽temp���飬ֱ���������ߵ��������У���һ�ߴ������Ϊֹ
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
		
		//������ÿ�ζ��������е�
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t+=1;
			tempLeft += 1;
		}
		
	}
}
