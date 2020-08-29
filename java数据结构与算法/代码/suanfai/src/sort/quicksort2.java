package sort;

import java.util.Arrays;

public class quicksort2 {
   public static void main(String[] args) {
	    int a1[] = { 6, 1, 4,7, 2, 3};
		int a2[] = { 0, 0, 5, 7, 3, 6, 4, 1, 2, 8 };
		QuickSort(a1, 0, 5);
		QuickSort(a2, 0, 9);
		
		
		System.out.println("快速排序=" + Arrays.toString(a1));
		
		System.out.println("快速排序=" + Arrays.toString(a2));
		
		
		
}
   public static void QuickSort(int a[], int p, int r)
   {
   	
   		if (p < r)
   		{
   			int q = Partition(a, p, r);//挑选a[q],划分a[]
   									   //递归继续划分并排序
   			QuickSort(a, p, q);
   			QuickSort(a, q, r);
   		}
   	
   	
   }
   public static int Partition(int a[], int p, int r)
   {
   	int i = p, j = r;
   	int x = a[p];//取第一个元素作为比较基准
   	int temp = 0;//用于交换的中间项
   	while (i<j)
   	{
   		while (a[j] >= x && i < j) {  
   		j--;
   		}//从右往左搜索
   		while (a[i] <= x && i < j) {   
   	    i++;
   	    }//从左往右搜索
   		

   		//Swap(a[i], a[j]);
   		temp = a[i];
   		a[i] = a[j];
   		a[j] = temp; 
   	}
   	//基准值定位，交换首项选出的基准值和搜索完的最后一个元素（肯定<=x，所以放在第一位没有问题）
   	a[p] = a[j];
   	a[j] = x;
   	return j;//返回中间项的索引值
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
