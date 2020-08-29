package search;

import java.util.Arrays;

public class FibonacciSearch {
	public static int maxSize = 20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println("index="+fibSearch(arr, 1234));
	}
	//��Ϊ���� mid = low +f(k-1)-1,��Ҫʹ�õ�쳲��������У����������Ҫ�Ȼ�ȡ��һ��쳲���������
    public static int[] fib() {
    	int[] f = new int[maxSize];
    	f[0] = 1;
    	f[1] = 1;
    	for(int i=2;i<maxSize;i++) {
    		f[i] = f[i-1]+f[i-2];
    	}
    	return f;
    	
    }
    //쳲����������㷨
    public static int fibSearch(int[] a,int key) {
    	int low = 0;
    	int high = a.length-1;
    	int k = 0;//��ʾ쳲������ָ���ֵ���±�
    	int mid = 0;
    	int f[] = fib();
    	while(high>f[k] - 1) {
    		k++;
    	}
    	//��Ϊf[k]���ܴ���a�ĳ��ȣ����������Ҫʹ��Arrays�࣬����һ���µ����飬��ָ��a[]
    	int[] temp = Arrays.copyOf(a, f[k]);
    	//ʵ������Ҫʹ��a�������������temp
    	for(int i = high+1;i<temp.length;i++) {
    		temp[i] = a[high];
    	}
    	System.out.println(Arrays.toString(temp));
    	//ʹ��while��ѭ������
        while(low<=high) {
        	mid = low + f[k-1]-1;
        	if(key<temp[mid]) {
        		high = mid -1;
        		//Ϊʲô��k--
        		//1,ȫ��Ԫ�� = ǰ���Ԫ�� + ��ߵ�Ԫ��
        		//��Ϊǰ����f[k-1]��Ԫ�أ����Կ��Լ�����ֳ�f[k-2]+f[k-3]
        		k--;
        	}else if(key > temp[mid]){
        		low = mid +1;
        		k -= 2;
        	}else {
        		if(mid <= high) {
        			return mid;
        		}else {
        			return high;
        		}
        	}
        }
        return -1;
    }
    
    
}
