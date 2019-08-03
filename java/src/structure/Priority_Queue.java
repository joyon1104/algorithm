package structure;

import java.util.PriorityQueue;

/*
 * Priority Queue (우선순위 큐)
 * - 기존 큐와 다르게 우선순위가 높은 데이터가 먼저 출력
 */

public class Priority_Queue {
	
	static class Vehicle implements Comparable<Vehicle>{
	    String name;
	    int time;
	    
	    public Vehicle(String name, int time) {
	        this.name = name;
	        this.time = time;
	    }
	    public String getName() {
	        return this.name;
	    }
	    public int getTime() {
	        return this.time;
	    }
	    
	    //우선순위 기준이 됨.
	    @Override
	    public int compareTo(Vehicle target) {
	        // 자신의 값이 작으면 -1
	        // 자신의 값과 같으면 0
	        // 자신보다 값이 크면 1
	        if(this.time < target.getTime()) return -1;
	        else if(this.time > target.getTime()) return 1;
	        return 0;
	    }
	}

	
	public static void main(String[] args) {
		PriorityQueue<Vehicle> pQueue = new PriorityQueue<Vehicle>();
		
        pQueue.offer(new Vehicle("대중교통", 70));
        pQueue.offer(new Vehicle("자가용", 45));
        pQueue.offer(new Vehicle("도보", 400));
        pQueue.offer(new Vehicle("자전거", 125));
        
        // 시간이 작은 것부터 출력됨.
        while(!pQueue.isEmpty()) {
            Vehicle v = pQueue.poll();
            System.out.println(v.getName() + " 시간 :" + v.getTime());
        }
    }
}
