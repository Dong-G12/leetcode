package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		//创建广播电台，放入到Map中
		
		HashMap<String,HashSet<String>> broadcasts = new HashMap<String,HashSet<String>>();
		
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");
		
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		
		HashSet<String> hashSet4 = new HashSet<String>();
	
		hashSet4.add("上海");
		hashSet4.add("天津");
		
		HashSet<String> hashSet5 = new HashSet<String>();
		
		hashSet5.add("杭州");
		hashSet5.add("大连");
		
		
		//加入到Map
		broadcasts.put("K1",hashSet1);
		broadcasts.put("K2",hashSet2);
		broadcasts.put("K3",hashSet3);
		broadcasts.put("K4",hashSet4);
		broadcasts.put("K5",hashSet5);
		
		//存放所有的地区
		
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("北京");
		allAreas.add("上海");
		allAreas.add("天津");
		allAreas.add("广州");
		allAreas.add("深圳");
		allAreas.add("成都");
		allAreas.add("杭州");
		allAreas.add("大连");
		System.out.println("ffsf");
		
		//创建ArrayList,存放选择的电台集合
		
		ArrayList<String> selects = new ArrayList<String>();
		
		
		//定义一个临时的集合，在遍历的过程中，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
		
		HashSet<String> tempSet = new HashSet<String>();
		
		String maxKey = null;
		while(allAreas.size() != 0) {
			//每进行一次while，需要将maxKey = null
			maxKey = null;
			for(String key: broadcasts.keySet()) {
				tempSet.clear();
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				
				//求出tempSet 和allAreas 集合的交集，交集会赋给tempSet
				tempSet.retainAll(allAreas);
				
			
				//下面这句话体现出贪婪算法的特点，每次都选最优的
				if(tempSet.size() > 0 && (maxKey == null|| tempSet.size() > broadcasts.get(maxKey).size())){
					maxKey = key;
				}
			}
			
			if(maxKey != null) {
				selects.add(maxKey);
				
				//将maxKey指向的广播电台覆盖的地区，从allareas去掉
				
				allAreas.removeAll(broadcasts.get(maxKey));
				
			}
			
		}
		System.out.println("得到的选择结果是"+ selects);
		
		
	}

}
