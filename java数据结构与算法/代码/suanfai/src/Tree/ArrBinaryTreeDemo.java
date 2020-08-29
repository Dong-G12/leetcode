package Tree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] arr = {1,2,3,4,5,6,7};
         ArrBinaryTree arrayBinary = new ArrBinaryTree(arr);
         
         //arrayBinary.preOrder(0);
         arrayBinary.infixOrder(0);
	}

}


class ArrBinaryTree{
	private int[] arr;//存储数据节点的数组
	
	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	//重载preOrder
	public void preOrder() {
		this.arr = arr;
	}
	//index表示数组的下标
	public void preOrder(int index) {
		//如果数组为空，或者arr.length = 0
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}
		System.out.println(arr[index]);
		
		//向左递归遍历
		if((index*2+1) < arr.length) {
		    preOrder(2*index + 1);
		    }
		//向右递归遍历
		if((index*2+2) < arr.length) {
		    preOrder(2*index + 2);
		    }
	}
	public void infixOrder(int index) {
		//如果数组为空，或者arr.length = 0
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}
		//向左递归遍历
		if((index*2+1) < arr.length) {
		    infixOrder(2*index + 1);
		    }
		System.out.println(arr[index]);
		//向右递归遍历
		if((index*2+2) < arr.length) {
		    infixOrder(2*index + 2);
		    }
	}
	
	
}