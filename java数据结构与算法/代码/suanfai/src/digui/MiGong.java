package digui;

public class MiGong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          //�ȴ�����ά����ģ���Թ�
		
		int[][] map = new int[8][7];
		//ʹ��1��ʾǽ
		for(int i=0;i<7;i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for(int i=0;i<8;i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		map[1][2] = 1;
		map[2][2] = 1;
		//�����ͼ
		for(int i=0;i<8;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		//ʹ�õݹ���ݸ�С����·
		
		setWay(map,1,1);
		System.out.println("С���߹���·��");
		for(int i=0;i<8;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
    //ʹ�õݹ��С����·
	/**
	 * ���С���ܵ�map[6][5]ʱ����˵��ͨ·�ҵ�
	 * ��map[i][j]Ϊ0ʱ��ʾ�õ�û���߹���1��ʾǽ��2��ʾͨ·�����ߣ�3��ʾ�õ��Ѿ��߹��������߲�ͨ��
	 * �����Թ�ʱ��Ҫȷ��һ�����ԣ���->��->��->��
	 * @param map ��ͼ
	 * @param i  ��ʾ�ӵ�ͼ���ĸ�λ�ó���
	 * @param j  ��ʾ�ӵ�ͼ���ĸ�λ�ó���
	 * @return �ҵ�ͨ·������true�����򷵻�false
	 */
	public static boolean setWay(int[][] map,int i, int j) {
		if(map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j] == 0) {
				map[i][j] = 2;//�ٶ��õ������ͨ
				if(setWay(map,i+1,j)) {
					return true;
				}else if(setWay(map,i,j+1)) {
					return true;
				}else if(setWay(map,i-1,j)) {
					return true;
				}else if(setWay(map,i,j-1)) {
					return true;
				}else {
					map[i][j] = 3;
					return false;
				}
			}else {return false;}
				
		}
	}
}
