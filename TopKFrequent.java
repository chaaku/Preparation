import java.util.*;

class Pair{
	    int num;
	    int count;
	    public Pair(int num, int count){
	        this.num=num;
	        this.count=count;
	    }
	}	 

	public class TopKFrequent {
		
		public static List<Integer> topKFrequent(int[] nums, int k) {
	        //count the frequency for each element
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int num: nums){
	            if(map.containsKey(num)){
	                map.put(num, map.get(num)+1);
	            }else{
	                map.put(num, 1);
	            }
	        }
	        // create a min heap
	        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
	            public int compare(Pair a, Pair b){
	                return a.count-b.count;
	            }
	        });
	 
	        //maintain a heap of size k. 
	        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	            Pair p = new Pair(entry.getKey(), entry.getValue());
	            queue.offer(p);
	            if(queue.size()>k){
	                queue.poll();
	            }
	        }
	 
	        //get all elements from the heap
	        List<Integer> result = new ArrayList<Integer>();
	        while(queue.size()>0){
	            result.add(queue.poll().num);
	        }
	        //reverse the order
	        Collections.reverse(result);
	 
	        return result;
	    }
		
		public static void main(String[] args) {
			
			int [] nums = {1,1,1,2,2,3,4,4,4,4,6,6,6,6};
			int k =2;
			
			List<Integer> list = topKFrequent(nums,k);		
			list.forEach(System.out::println);
			
		}
	}