package horse;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessboard {
	private static int X; //棋盘的列数
	
    private static int Y; //棋盘的行数
    
    //创建一个数组，标记棋盘的各个位置是否被访问过
    private static boolean visited[];
    
    //使用一个属性，标记是否棋盘的所有位置都被访问
    private static boolean finished;
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		//测试骑士周游算法是否正确
		
		X=8;
		Y=8;
		int row = 1;
		int column = 1;
		
		//创建棋盘
		
		int[][] chessboard = new int[X][Y];
		visited = new boolean[X*Y];
		
		//测试一下耗时
		
		long start = System.currentTimeMillis();
		traversalChessboard(chessboard, row-1, column-1, 1);
		
		long end = System.currentTimeMillis();
		
		System.out.println("共耗时："+ (end - start)+"毫秒");
		
		//输出棋盘的最后情况
		
		for(int[] rows: chessboard) {
			for(int step:rows) {
				System.out.print(step+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * 完成骑士周游问题的算法
	 * @param chessboard 棋盘
	 * @param row 马儿当前的行 从0 开始
	 * @param column 马儿当前的列 从0 开始
	 * @param step 是第几步，初始位置是第一步
	 */
	public static void traversalChessboard(int[][] chessboard,int row,int column,int step) {
		chessboard[row][column] = step;
		visited[row*X + column] = true; //标记该位置已经访问
		
		//获取当前位置可以走的下一个位置的集合
		
		ArrayList<Point> ps = next(new Point(column,row));
		
		//对ps的所有的Point对象的下一步的位置的数目，进行非递减排序
		sort(ps);
		while(!ps.isEmpty()) {
			Point p = ps.remove(0);//取出下一个可以走的位置
			
			//判断该点是否已经访问过
			
			if(!visited[p.y * X + p.x]) {
				traversalChessboard(chessboard,p.y,p.x,step+1);	
			}	
		}
		
		//step<X*Y 有两种情况，1，棋盘到目前位置，仍然没有走完。2，棋盘处于回溯过程中
		if(step < X*Y && !finished) {
			chessboard[row][column] = 0;
			visited[row*X + column] = false;
		}else {
			finished = true;
		}
	}
	
	/**
	 * 根据当前位置(Point对象)，计算马儿还能走哪些位置，并放入到一个集合中（ArrayList），最多有8个位置
	 * @param curPoint
	 * @return
	 */
	public static ArrayList<Point> next(Point curPoint){
		//创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<Point>();
        
        Point p1 = new Point();
        //
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y-1) >= 0) {
//        	ps.add(p1);
        	ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y-2) >= 0) {
//        	ps.add(p1);
        	ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y-2) >= 0) {
//        	ps.add(p1);
        	ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y-1) >= 0) {
//        	ps.add(p1);
        	ps.add(new Point(p1));
        }
        
        if((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
//        	ps.add(p1);
        	ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
//        	ps.add(p1);
        	ps.add(new Point(p1));
        }
        
        if((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
//        	ps.add(p1);
        	ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
//        	ps.add(p1);
        	ps.add(new Point(p1));
        }
        
        return ps;
	}
	
	//根据当前这一步的所有下一步的选择位置，进行非递减排序,先走下一步选择较少的，减少回溯的可能
	
	public static void sort(ArrayList<Point> ps) {
		ps.sort(new Comparator<Point>(){

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				//获取到o1的下一步的所有位置的个数
				int count1 = next(o1).size();
				int count2= next(o2).size();
				if(count1 < count2) {
					return -1;
				}else if(count1 > count2) {
					return 0;
				}else {
					return 1;
				}
			}	
		});
	}
}
