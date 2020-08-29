package digui;

public class Queue8 {
    // ����һ��max��ʾ���ж��ٸ��ʺ�
	int max = 8;
	//����һ������array������ʺ����λ�õĽ��
	int[] array = new int[max];
	static int count = 0;
	static int judgecount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		//����
		
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("һ����%d�ⷨ",count);
		System.out.println();
		System.out.printf("һ���жϳ�ͻ%d�ⷨ��",judgecount);
	}
	//��дһ�����������õ�n���ʺ�
	//�ر�ע�⣺ÿһ��check����һ��forѭ��
	private void check(int n) {
		if(n==max) {
			print();
			return;
		}
		
		//���η���ʺ󣬲��ж��Ƿ��ͻ
		for(int i=0;i<max;i++) {
			//�Ȱѵ�ǰ����ʺ� �ŵ����еĵ�һ��
			array[n] = i;
			//�ж�
			if(judge(n)) {
				//���ŷ�n+1���ʺ󣬿�ʼ�ݹ�
				check(n+1);
			}
		}
	}
	//�鿴�����Ƿ��õ�n���ʺ󣬾�ȥ���ûʺ��Ƿ��ǰ���Ѿ��ڷŵĻʺ��ͻ
	/**
	 * n��ʾ��n���ʺ�
	 */
	private boolean judge(int n) {
		judgecount++;
		for(int i=0;i<n;i++) {
			//array[i] == array[n],�ж��Ƿ���ͬһ��
			//Math.abs(n-i) == Math.abs(array[n] - array[i])���Ƿ���ͬһб��
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
    //дһ�����������ʺ�ڷŵ�λ�����
	private void print() {
		count++;
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
