package programmers;

import java.util.*;
class p0000 {
	static int[][] map;
	
    static class Pair{
    	int i;
    	int j;
    	public Pair(int i, int j) {
    		this.i = i;
    		this.j = j;
    	}
    }
    
    static public void printmap(int[][] result) {
    	 for(int i=0; i<result.length; i++) {
         	for(int j=0; j<result[0].length; j++)
         		System.out.print(result[i][j]+" ");
         	System.out.println();
         }
         System.out.println("-------------------");
    }
    
    static public int[][] rebuild() {
    	int[][] result = new int[map.length][map[0].length];
    	for(int j=0; j<map[0].length; j++) {
        	Queue<Integer> que = new LinkedList<>();
        	for(int i=map.length-1; i>=0; i--) {
        		if(map[i][j] > 0)
        			que.offer(map[i][j]);
        	}
        	int idx = map.length-1;
        	while(!que.isEmpty()) {
        		result[idx--][j] = que.poll();
        	}
        }
        return result;
    }
    
    static public void solve(){
        int[][] moved = {{0,1},{1,0},{-1,0},{0,-1}};
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length ; j++){
                if(map[i][j] > 0){
                    Queue<Pair> que = new LinkedList<>();
                    Queue<Pair> tmpque = new LinkedList<>();
                    int[][] visited = new int[map.length][map[0].length];
                    visited[i][j] = 1;
                    que.offer(new Pair(i,j));
                    while(!que.isEmpty()) {
                    	Pair p = que.poll();
                    	tmpque.offer(p);
                    	for(int k=0; k<4; k++) {
                    		int next_i = p.i + moved[k][0];
                    		int next_j = p.j + moved[k][1];
                    		if(next_i>=0 && next_j >=0 && next_i<map.length && next_j<map[0].length) {
                    			if(visited[next_i][next_j] == 0 && map[next_i][next_j]== map[p.i][p.j]) {
                    				visited[next_i][next_j] = 1;
                    				que.offer(new Pair(next_i, next_j));
                    			}
                    		}
                    	}
                    }
                    if(tmpque.size()>=3) {
                    	while(!tmpque.isEmpty()) {
                    		Pair p = tmpque.poll();
                    		map[p.i][p.j] = 0;
                    	}
                    	map = rebuild();
                    	solve();
                    	return;
                    }
                }
            }
        }
        
        
    }
    
    static public String[] solution(int[][] macaron) {
        String[] answer = {};
        map = new int[6][6];
        
        for(int i=0; i<macaron.length ;i++){
            int loc = macaron[i][0]-1;
            int color = macaron[i][1];
            for(int k=5; k>=0; k--){
                if(map[k][loc] == 0) {
                    map[k][loc] = color;
                    break;
                }
            }
            solve();
            printmap(map);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
//    	int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
    	int[][] macaron = {{1,1},{1,2},{1,4},{2,1},{2,2},{2,3},{3,4},{3,1},{3,2},{3,3},{3,4},{4,4},{4,3},{5,4},{6,1}};
		solution(macaron);
	}
}