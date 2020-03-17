package programmers;
/*
 * [후보키]
 */
import java.util.*;

class p200314_3 {
    static int answer;
    static ArrayList<String> check;	//후보키를 담는 arraylist -> ex) ["0","12"] string형태로 담음.
    static void dfs(String[][]relation, ArrayList<Integer>arrlist,int[] visited, int n, int cnt){
        if(n==cnt){
        	// 구한 키(tmp)가 기존 후보키를 포함하는 키인지 확인
            String tmp = "";
            for(int x: arrlist)
                tmp += Integer.toString(x);
            for(String y: check){	// 기존 후보키의 원소 하나하나를 비교해야한다. (컬럼이 1~8까지여서 한글자씩 쪼개는게 가능했음!)
                boolean tf = false;
                for(int j=0; j<y.length();j++){
                    if(!tmp.contains(y.substring(j,j+1))){
                        tf = true;
                        break;
                    }
                }
                if(tf==false)	// 포함하는 키이면 아무것도 하지않고 return
                    return;
            }
            
            //후보키의 최소성을 만족하는 경우, 해당 키가 모든 튜플을 식별 가능한지 확인
            HashMap<String, Integer> hm = new HashMap<>();
            for(int i=0; i<relation.length; i++){
                String key = "";
                for(int x : arrlist)
                    key += relation[i][x] + " ";
                hm.put(key,1);
            }
            if(hm.size() == relation.length){	// 모든 튜플이 식별 가능한 경우
                answer ++;		//후보키 개수 증가
                check.add(tmp);	//후보키 추가
            }
        }
        else{
            int start = 0;
            if(cnt >=1)
                start = arrlist.get(cnt -1);	// 0,1,2와  1,0,2를 하나로 하기 함.
            for(int i=start; i<visited.length; i++){
                if(visited[i] == 0){
                    arrlist.add(i);
                    visited[i]=1;
                    dfs(relation,arrlist,visited,n,cnt+1);
                    visited[i]=0;
                    arrlist.remove(arrlist.size()-1);
                }
            }
        }
    }
    public int solution(String[][] relation) {
        answer = 0;
        check = new ArrayList<>();
        for(int i=1; i<=relation[0].length;i++){
            ArrayList<Integer> arrlist = new ArrayList<>(); //후보키가 될 컬럼인덱스를 담을 arrlist
            int[] visited = new int[relation[0].length];
            dfs(relation, arrlist, visited,i,0);
        }
        return answer;
    }
}