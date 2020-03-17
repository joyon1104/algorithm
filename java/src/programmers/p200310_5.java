package programmers;

/*
 * [단체사진 찍기]
 * 참고 : https://keepgoing0328.tistory.com/entry/2017-%EC%B9%B4%EC%B9%B4%EC%98%A4%EC%BD%94%EB%93%9C-%EB%B3%B8%EC%84%A0-%EB%8B%A8%EC%B2%B4%EC%82%AC%EC%A7%84-%EC%B0%8D%EA%B8%B0-java
 */

import java.util.*;
class p200310_5 {
  public int solution(int n, String[] data) {
        // 캐릭터마다 새로운 번호를 매칭 
        hm = new HashMap<Character, Integer>();
        hm.put('A', 0);
        hm.put('C', 1);
        hm.put('F', 2);
        hm.put('J', 3);
        hm.put('M', 4);
        hm.put('N', 5);
        hm.put('R', 6);
        hm.put('T', 7);
        
        permute = new int[8];
        selected = new boolean[8];
        count = 0;
        
        // dfs ( pos, data ): pos번째 캐릭터 위치를 정하고, pos+1 번째 구하고.. 끝까지! 순열 구한다
        // 그리고 조건data를 통과하는지 확인 
        dfs(0,  data);
 
        return count;
    }
 
    static HashMap<Character, Integer> hm;
    static int[] permute ;
    static boolean[] selected ;
    static int count;
    
    // permute에서 pos번째 케릭터의 위치를 고른다.  
    static void dfs(int pos, String[] data) {
        
        if(pos == 8) { // 하나의 permute이 완성 
            char compare;
            int c1, c2, digit;
            for(int i = 0 ; i < data.length ; i++) {
                c1 = permute[hm.get(data[i].charAt(0))];
                c2 = permute[hm.get(data[i].charAt(2))];
                compare = data[i].charAt(3);
                digit = data[i].charAt(4)-'0';
                if(compare == '>') {
                    if(Math.abs(c1-c2) -1 <= digit) 
                        return;
                }else if(compare == '<') {
                    if(Math.abs(c1-c2) -1  >= digit)
                        return;
                }else {
                    if(Math.abs(c1-c2) - 1 != digit)
                        return;
                }
            }
            count++;
            return;
        }
        
        // pos번째 캐릭터가 위치 가능한 모든 i 
        for(int i = 0 ; i < 8 ; i++) { 
            if(!selected[i]) {
                selected[i] = true;
                permute[pos] = i;
                dfs(pos+1, data);
                selected[i] = false;
            }
        }
    }
}
