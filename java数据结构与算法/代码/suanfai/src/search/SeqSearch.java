package search;

public class SeqSearch {
    public static void main(String[] args) {
	      int arr[] = {1,9,11,-1,34,89};
	      int index = seqsearch(arr,33);
	      if(index == -1) {
	    	  System.out.println("没有找到");
	      }else {
	    	  System.out.println("找到，下标="+ index);
	      }
	      
}
    public static int seqsearch(int[] arr,int value) {
    	for(int i = 0;i<arr.length;i++) {
    		if(arr[i] == value) {
    			return i;
    		}
    	}
    	return -1;
    }
}
