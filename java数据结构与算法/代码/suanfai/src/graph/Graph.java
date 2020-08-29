package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    
	private ArrayList<String> vertexList; //存储顶点集合
	
	private int numOfEdges;   //存储图对应的邻接矩阵
	
	private int[][] edges;   //表示边的数目
	
	//记录某个结点是否被访问
	private boolean[] isVisted;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int n = 8;
       //String VertexValue[] = {"A","B","C","D","E"};
       
       String VertexValue[] = {"1","2","3","4","5","6","7","8"};
       
       Graph graph = new Graph(n);
       
       for(String vertex:VertexValue) {
    	   graph.insertVertex(vertex);
       }
       
       //添加边
//       graph.insertEdge(0, 1, 1);
//       graph.insertEdge(0, 2, 1);
//       graph.insertEdge(1, 2, 1);
//       graph.insertEdge(1, 3, 1);
//       graph.insertEdge(1, 4, 1);
       
       
       graph.insertEdge(0, 1, 1);
       graph.insertEdge(0, 2, 1);
       graph.insertEdge(1, 3, 1);
       graph.insertEdge(1, 4, 1);
       graph.insertEdge(3, 7, 1);
       graph.insertEdge(4, 7, 1);
       graph.insertEdge(2, 5, 1);
       graph.insertEdge(2, 6, 1);
       graph.insertEdge(5, 6, 1);
       
       graph.showGraph();
       
       System.out.println("深度遍历");
       //graph.dfs(graph.isVisted,0);
       graph.bfs();
       //System.out.println();
       System.out.println("广度优先遍历");
       //graph.bfs(graph.isVisted,0);
       graph.bfs();
	}
	
	
	public Graph(int n) {
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
		isVisted = new boolean[8];
	}
	
	//得到第一个邻接结点的下标
	
	public int getFirstNeighbor(int index) {
		for(int j = 0; j< vertexList.size();j++) {
			if(edges[index][j]>0) {
				return j;
			}
		}
		return -1;
	}
	
	//根据前一个邻接结点的下标来获取下一个邻接结点
	
	public int getNextNeighbor(int v1,int v2) {
		for(int j = v2+1;j < vertexList.size();j++) {
			if(edges[v1][j]>0) {
				return j;
			}
		}
		return -1;
	}
	
	
	public void dfs(boolean[] isVisted,int i) {
		
		System.out.print(getVertex(i)+"->");
		
		//将该节点设置为已经访问过
		
		isVisted[i] = true;
		int w = getFirstNeighbor(i);
		
		while(w!=-1) {
			if(!isVisted[w]) {
				dfs(isVisted,w);
			}
			
			w = getNextNeighbor(i,w);
		}
	}
	
    //对一个结点进行广度优先遍历的方法
	
	private void bfs(boolean[] isVisted, int i) {
		int u; //表示队列的头结点对应的下标
		int w; //表示邻接结点
		
		//队列，结点访问的顺序
		
		LinkedList queue = new LinkedList();
		//访问结点
		System.out.print(getVertex(i)+"->");
		
		isVisted[i] = true;
		
		//将结点加入队列
		
		queue.addLast(i);
		
		while( ! queue.isEmpty()) {
			//取出队列的头结点下标
			u = (Integer)queue.removeFirst();
			//得到第一个邻接点的下标
			w = getFirstNeighbor(u);
			
			while(w != -1) {
				//是否访问过
				
				if(!isVisted[w]) {
					System.out.print(getVertex(w)+"->");
					isVisted[w] = true;
					//入队列
					queue.addLast(w);
				}
				
				//如果访问过，以u为前驱点，找w后面的下一个邻接点
				
				w = getNextNeighbor(u, w);//体现出广度优先
			}
		}
		
	}
	//遍历所有的节点，都进行广度优先搜索
	public void bfs() {
		isVisted = new boolean[vertexList.size()];
		for(int i =0;i<getNumOfVertex();i++) {
			if(!isVisted[i]) {
				bfs(isVisted,i);
			}
		}
	}
	
	//图中常用的方法
	//返回结点个数
	
	public void dfs() {
		isVisted = new boolean[vertexList.size()];
		for(int i =0;i<getNumOfVertex();i++) {
			if(!isVisted[i]) {
				dfs(isVisted,i);
			}
		}
	}
	
	public int getNumOfVertex() {
		return vertexList.size();
	}
	
	//
	public int getNumOfEdges() {
		return numOfEdges;
	}
	
	//返回结点i（下标）对应的数据：0-》A
	public String getVertex(int i) {
		return vertexList.get(i);
	}
	
	//插入结点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
    
	public int getWeight(int v1,int v2) {
		return edges[v1][v2];
	}
	//添加边
	/**
	 * 
	 * @param v1 表示点的下标。即是第几个顶点
	 * @param v2 第二个顶点对应的下标
	 * @param weight
	 */
	public void insertEdge(int v1,int v2,int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	
	//显示矩阵
	
	public void showGraph() {
		for(int[] link : edges) {
			System.err.println(Arrays.toString(link));
		}
	}
}
