package sort;

import java.util.Arrays;

public class quicksort2 {
   public static void main(String[] args) {
	    int a1[] = { 6, 1, 4,7, 2, 3};
		int a2[] = { 0, 0, 5, 7, 3, 6, 4, 1, 2, 8 };
		QuickSort(a1, 0, 5);
		QuickSort(a2, 0, 9);
		
		
		System.out.println("��������=" + Arrays.toString(a1));
		
		System.out.println("��������=" + Arrays.toString(a2));
		
		
		
}
   public static void QuickSort(int a[], int p, int r)
   {
   	
   		if (p < r)
   		{
   			int q = Partition(a, p, r);//��ѡa[q],����a[]
   									   //�ݹ�������ֲ�����
   			QuickSort(a, p, q);
   			QuickSort(a, q, r);
   		}
   	
   	
   }
   public static int Partition(int a[], int p, int r)
   {
   	int i = p, j = r;
   	int x = a[p];//ȡ��һ��Ԫ����Ϊ�Ƚϻ�׼
   	int temp = 0;//���ڽ������м���
   	while (i<j)
   	{
   		while (a[j] >= x && i < j) {  
   		j--;
   		}//������������
   		while (a[i] <= x && i < j) {   
   	    i++;
   	    }//������������
   		

   		//Swap(a[i], a[j]);
   		temp = a[i];
   		a[i] = a[j];
   		a[j] = temp; 
   	}
   	//��׼ֵ��λ����������ѡ���Ļ�׼ֵ������������һ��Ԫ�أ��϶�<=x�����Է��ڵ�һλû�����⣩
   	a[p] = a[j];
   	a[j] = x;
   	return j;//�����м��������ֵ
   }
//   public static  boolean JudgeDisc(int a[],int p ,int r)
//   {
//   	boolean disc = true;
//   	for (int i = p; i < r; i++)
//   	{
//   		if (a[i] < a[i + 1])
//   		{
//   			disc = false;
//   			break;
//   		}
//   	}
//   	return disc;
//   }
//   public static  boolean JudgeInc(int a[], int p, int r)
//   {
//   	boolean inc = true;
//   	for (int i = p; i < r; i++)
//   	{
//   		if (a[i] > a[i + 1])
//   		{
//   			inc = false;
//   			break;
//   		}
//   	}
//   	return inc;
//   }
}
