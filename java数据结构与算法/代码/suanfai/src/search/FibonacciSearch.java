package search;

import java.util.Arrays;

public class FibonacciSearch {
	public static int maxSize = 20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println("index="+fibSearch(arr, 1234));
	}
	//因为后面 mid = low +f(k-1)-1,需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
    public static int[] fib() {
    	int[] f = new int[maxSize];
    	f[0] = 1;
    	f[1] = 1;
    	for(int i=2;i<maxSize;i++) {
    		f[i] = f[i-1]+f[i-2];
    	}
    	return f;
    	
    }
    //斐波那契查找算法
    public static int fibSearch(int[] a,int key) {
    	int low = 0;
    	int high = a.length-1;
    	int k = 0;//表示斐波那契分割数值的下标
    	int mid = 0;
    	int f[] = fib();
    	while(high>f[k] - 1) {
    		k++;
    	}
    	//因为f[k]可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
    	int[] temp = Arrays.copyOf(a, f[k]);
    	//实际上需要使用a数组最后的数填充temp
    	for(int i = high+1;i<temp.length;i++) {
    		temp[i] = a[high];
    	}
    	System.out.println(Arrays.toString(temp));
    	//使用while来循环处理
        while(low<=high) {
        	mid = low + f[k-1]-1;
        	if(key<temp[mid]) {
        		high = mid -1;
        		//为什么是k--
        		//1,全部元素 = 前面的元素 + 后边的元素
        		//因为前面有f[k-1]个元素，所以可以继续拆分成f[k-2]+f[k-3]
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
