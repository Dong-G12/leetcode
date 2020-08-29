package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Bubblesoft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {3,9,-1,10,20};
        //����ð������
		//����һ��ð��������ٶȣ���80000������
		int[] arr = new int[80000];
		for(int i=0; i<80000;i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datelStr = simpleDateFormat.format(date1);
		System.out.println("����ǰ��ʱ����=" + datelStr);
		
		bubbleSort(arr);
		Date date2 = new Date();
		String date2lStr = simpleDateFormat.format(date2);
		System.out.println("������ʱ����=" + date2lStr);
               
	}
    public static void bubbleSort(int[] arr) {
         int temp = 0;
         boolean flag = false;//��ʾ�Ƿ���й�����
         for(int i=1;i<arr.length;i++) {
           for(int j=0;j<arr.length-i;j++) {
         	  if(arr[j]>arr[j+1]) {
         		flag = true;
         		temp = arr[j];
         		arr[j] = arr[j+1];
         		arr[j+1] = temp;
         	  }
           }
           
           if(!flag) {
         	  break;
           }else {
         	  flag = false; //����flag�������´��ж�
           }
         }
    }
}
