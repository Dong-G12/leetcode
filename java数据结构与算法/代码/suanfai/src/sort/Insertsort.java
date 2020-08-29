package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Insertsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[80000];
		for(int i=0; i<80000;i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datelStr = simpleDateFormat.format(date1);
		System.out.println("����ǰ��ʱ����=" + datelStr);
		insertSort(arr);
        //System.out.println(Arrays.toString(arr));
        Date date2 = new Date();
		String date2lStr = simpleDateFormat.format(date2);
		System.out.println("������ʱ����=" + date2lStr);
		
//		int[] arr = {101,34,119,1,-1,89};
//		insertSort(arr);
//		System.out.println(Arrays.toString(arr));
	}
    //��������
	
	public static void insertSort(int[] arr) {
		//������������
		int insertVal = 0;
		int insertIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			 insertVal = arr[i];
			 insertIndex = i-1;

			// insertIndex>=0,��֤�ڸ�insertVal�Ҳ���λ��ʱ����Խ��
			// insertVal < arr[insertIndex],�������������û���ҵ�����λ��
			// ����Ҫ��arr[insertIndex]����
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			if(insertIndex + 1 == i) {
			arr[insertIndex + 1] = insertVal;
			}
			// ���˳�whileѭ��ʱ��˵�������λ���ҵ���insertIndex +1
		}
	}
}
