package dac;

public class Hanoitower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         hanoitower(5,'A','B','C');
	}
    //汉诺塔的移动方法
	//使用分治算法
	
	public static void hanoitower(int num,char a,char b,char c) {
		if(num == 1) {
			System.out.println("第1个盘从 "+a+"->"+c);
		}else {
			//先把最上面的所有盘A->B，移动过程会使用到c塔
			hanoitower(num-1,a,c,b);
			//把最下面的盘A->C
			System.out.println("第"+num+"个盘从 "+a+"->"+c);
			//把B塔的所有盘从B—>C，移动过程中使用到a塔
			hanoitower(num-1,b,a,c);
		}
	}
}
