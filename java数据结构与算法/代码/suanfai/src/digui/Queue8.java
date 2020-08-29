package digui;

public class Queue8 {
    // 定义一个max表示共有多少个皇后
	int max = 8;
	//定义一个数组array，保存皇后放置位置的结果
	int[] array = new int[max];
	static int count = 0;
	static int judgecount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		//测试
		
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("一共有%d解法",count);
		System.out.println();
		System.out.printf("一共判断冲突%d解法次",judgecount);
	}
	//编写一个方法，放置第n个皇后
	//特别注意：每一次check都有一个for循环
	private void check(int n) {
		if(n==max) {
			print();
			return;
		}
		
		//依次放入皇后，并判断是否冲突
		for(int i=0;i<max;i++) {
			//先把当前这个皇后 放到该行的第一列
			array[n] = i;
			//判断
			if(judge(n)) {
				//接着放n+1个皇后，开始递归
				check(n+1);
			}
		}
	}
	//查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
	/**
	 * n表示第n个皇后
	 */
	private boolean judge(int n) {
		judgecount++;
		for(int i=0;i<n;i++) {
			//array[i] == array[n],判断是否在同一列
			//Math.abs(n-i) == Math.abs(array[n] - array[i])，是否在同一斜线
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
    //写一个方法，将皇后摆放的位置输出
	private void print() {
		count++;
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
