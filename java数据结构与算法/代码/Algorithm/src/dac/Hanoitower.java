package dac;

public class Hanoitower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         hanoitower(5,'A','B','C');
	}
    //��ŵ�����ƶ�����
	//ʹ�÷����㷨
	
	public static void hanoitower(int num,char a,char b,char c) {
		if(num == 1) {
			System.out.println("��1���̴� "+a+"->"+c);
		}else {
			//�Ȱ��������������A->B���ƶ����̻�ʹ�õ�c��
			hanoitower(num-1,a,c,b);
			//�����������A->C
			System.out.println("��"+num+"���̴� "+a+"->"+c);
			//��B���������̴�B��>C���ƶ�������ʹ�õ�a��
			hanoitower(num-1,b,a,c);
		}
	}
}
