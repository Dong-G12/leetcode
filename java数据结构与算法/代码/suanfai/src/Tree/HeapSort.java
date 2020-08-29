package Tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //int arr[] = {4,12,8,5,2,3,2,1,10,4,9};
//         adjustHeap(arr, 4, arr.length);
//         System.out.println("��һ��"+Arrays.toString(arr));
		int[] arr = new int[8000000];
		for(int i=0; i<80000;i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datelStr = simpleDateFormat.format(date1);
		System.out.println("����ǰ��ʱ����=" + datelStr);
        heapSort(arr);
        Date date2 = new Date();
		String date2lStr = simpleDateFormat.format(date2);
		System.out.println("������ʱ����=" + date2lStr);
	}
	
	//��дһ��������ķ���
	public static void heapSort(int arr[]) {
		System.out.println("������!");
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
	
	//��һ�����飨��������������Ϊһ���󶥶�
	/**
	 * ���ܣ���ɽ���i��Ӧ�ķ�Ҷ�ӽڵ���������ɴ󶥶�
	 * @param arr
	 * @param i ��Ҷ�ӽڵ��������е�����
	 * @param length ��ʾ���ٸ�Ԫ�ص���
	 */
	public static void adjustHeap(int arr[],int i,int length) {
		int temp = arr[i];//��ȡ����ǰԪ�ص�ֵ����������ʱ����
		for(int k = i*2 + 1;k<length; k = k*2 +1) {
			if(k+1<length && arr[k]<arr[k+1]) {//˵�����ӽڵ�С�����ӽڵ��ֵ
				k++;
			}
			if(arr[k] > temp) {//����ӽڵ���ڸ��ڵ�
				arr[i] = arr[k];
				i = k;
			}else {
				break;
			}
		}//��forѭ��������,��iΪ���ڵ���������ֵ��������ϣ��ֲ���
		
		arr[i] = temp;
	} 

}
