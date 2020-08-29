package digui;

public class MiGong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          //先创建二维数组模拟迷宫
		
		int[][] map = new int[8][7];
		//使用1表示墙
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
		//输出地图
		for(int i=0;i<8;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		//使用递归回溯给小球找路
		
		setWay(map,1,1);
		System.out.println("小球走过的路径");
		for(int i=0;i<8;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
    //使用递归给小球找路
	/**
	 * 如果小球能到map[6][5]时，则说明通路找到
	 * 当map[i][j]为0时表示该点没有走过，1表示墙，2表示通路可以走，3表示该点已经走过，但是走不通。
	 * 在走迷宫时需要确定一个策略，下->右->上->左
	 * @param map 地图
	 * @param i  表示从地图的哪个位置出发
	 * @param j  表示从地图的哪个位置出发
	 * @return 找到通路，返回true，否则返回false
	 */
	public static boolean setWay(int[][] map,int i, int j) {
		if(map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j] == 0) {
				map[i][j] = 2;//假定该点可以走通
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
