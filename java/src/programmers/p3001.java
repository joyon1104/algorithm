package programmers;

import java.util.*;

class p3001 {
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    static ArrayList<String> anslist = new ArrayList<String>();
    
    public String[] solution(String[][] tickets) {
        
        for(int i=0; i<tickets.length; i++){
            for(int j=0; j<tickets[0].length; j++){
                if(map.containsKey(tickets[i][j]) == false){
                    map.put(tickets[i][j], 0);
                }
            }
        }
        ArrayList<String> list = new ArrayList<String>();
        list.add("ICN");
        
        int[] check = new int[tickets.length];
        
        DFS("ICN", tickets, list,check, 0);
        
        String[] answer = new String[anslist.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = anslist.get(i);
        }
        
        return answer;
    }
    
    public static void DFS(String dept,String[][] tickets, ArrayList<String> list, int[] check, int n){
        if(n == check.length){
            getAnswer(list);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(dept) && check[i] == 0){
                check[i] = 1;
                list.add(tickets[i][1]);
                DFS(tickets[i][1], tickets,list,check,n+1);
                check[i]=0;
                list.remove(list.size()-1);
            }
        }
        return;
    }
    
    public static void getAnswer(ArrayList<String> list){
        if(anslist.size() == 0)
            anslist.addAll(list);
        else{
            for(int i=0; i<list.size(); i++){
                if(!((list.get(i)).equals(anslist.get(i)))){
                    if((anslist.get(i)).compareTo(list.get(i))>0){
                        anslist.clear();
                        anslist.addAll(list);
                    }
                    break;    
                }
            }
        }
    }
}
