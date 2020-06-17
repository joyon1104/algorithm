package programmers;
/*
 * [여행경로]
 * -bfs로 풀면 일부 테스트케이스에서 만족하지 않음 
 * 	=> 모든 티켓을 탐색하며 모든 방법을 찾은 후 알파벳 순서로 정답경로를 찾아야 함.
 */
import java.util.*;
class p200319_1 {
    static ArrayList<String> result = new ArrayList<>();;
    static void dfs(ArrayList<String>arrlist,String[][] tickets, int[] visited, int cnt){
        if(cnt== visited.length){
            if(result.size()==0)
                result.addAll(arrlist);
            else{
                boolean check = true;
                for(int i=0; i<result.size(); i++){
                    if(result.get(i).compareTo(arrlist.get(i)) > 0){
                        check = false;
                        break;
                    }
                    else if(result.get(i).compareTo(arrlist.get(i)) < 0)
                        break;
                }
                if(check==false){
                    result.clear();
                    result.addAll(arrlist);
                }
            }
        }
        else{
            for(int i=0; i<tickets.length; i++){
                if(visited[i]==0 && tickets[i][0].equals(arrlist.get(arrlist.size()-1))){
                    visited[i] = 1;
                    arrlist.add(tickets[i][1]);
                    dfs(arrlist,tickets,visited,cnt+1);
                    visited[i] = 0;
                    arrlist.remove(arrlist.size()-1);
                }
            }
        }
    }
    public String[] solution(String[][] tickets) {
        ArrayList<String> arrlist = new ArrayList<>();
        int[] visited = new int[tickets.length];
        arrlist.add("ICN");
        dfs(arrlist,tickets,visited,0);
        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }
}
