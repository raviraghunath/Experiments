package Arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindNthMostFrequentNumberInArray {

	public static void main(String[] args) {
		method1(new int[]{1,1,1,2,2,2,2,2,2,3,3,2,2,4,4,4,4,5});
	}

	private static void method1(int [] array){
		HashMap<Integer, Integer> map= new HashMap<>();
		for(int i=0,n=array.length;i<n;i++){
			int ele = array[i];
			if(!map.containsKey(ele)){
				map.put(ele, 1);
			}else{
				int j= map.get(ele);
				map.put(ele,++j);
			}
		}
		System.out.println(map);
		TreeMap<Integer, Integer> tMap = new TreeMap<Integer,Integer>(new cl1(map));
		tMap.putAll(map);
		System.out.println(tMap);
	}
	
	static class cl1 implements Comparator<Integer>{
		Map<Integer, Integer> map ;
		cl1(Map<Integer, Integer> map){
			this.map=map;
		}
		@Override
		public int compare(Integer o1, Integer o2) {
			if(map.get(o1)>map.get(o2)){
				return 1;
			}
			if(map.get(o1)<map.get(o2)){
				return -1;
			}
			return 0;
		}
		
	}
}
