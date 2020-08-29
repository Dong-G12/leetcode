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
	private int[] arr;//�洢���ݽڵ������
	
	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	
	//����preOrder
	public void preOrder() {
		this.arr = arr;
	}
	//index��ʾ������±�
	public void preOrder(int index) {
		//�������Ϊ�գ�����arr.length = 0
		if(arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
		}
		System.out.println(arr[index]);
		
		//����ݹ����
		if((index*2+1) < arr.length) {
		    preOrder(2*index + 1);
		    }
		//���ҵݹ����
		if((index*2+2) < arr.length) {
		    preOrder(2*index + 2);
		    }
	}
	public void infixOrder(int index) {
		//�������Ϊ�գ�����arr.length = 0
		if(arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
		}
		//����ݹ����
		if((index*2+1) < arr.length) {
		    infixOrder(2*index + 1);
		    }
		System.out.println(arr[index]);
		//���ҵݹ����
		if((index*2+2) < arr.length) {
		    infixOrder(2*index + 2);
		    }
	}
	
	
}