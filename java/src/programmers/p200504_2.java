package programmers;

/*
 * [가사검색]
 * Trie 사용
 * -> 참고 : https://velog.io/@ptm0304/2020%EC%B9%B4%EC%B9%B4%EC%98%A4%EA%B3%B5%EC%B1%84-%EA%B0%80%EC%82%AC-%EA%B2%80%EC%83%89
 * -> 정렬 후 이분탐색도 가능하다고 함.
 */
import java.util.*;

class p200504_2 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie root = new Trie('*');
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie prev = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                Trie curr = new Trie(c);
                prev = prev.putChild(curr, word.length());
            }
        }
         
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            Trie trav = root;
            if (query.charAt(0) == '?') continue;
            for (int j = 0; j < query.length(); j++) {
                char c = query.charAt(j);
                if (c == '?') {
                    answer[i] = trav.getNumChildrenWithLen(query.length());
                    break;
                }
                trav = trav.getChild(c);
                if (trav == null) {
                    answer[i] = 0;
                    break;
                }
                
            }
        }
        
        //reverse
        Trie rootReverse = new Trie('*');
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie prev = rootReverse;
            for (int j = word.length() - 1; j >= 0; j--) {
                char c = word.charAt(j);
                Trie curr = new Trie(c);
                prev = prev.putChild(curr, word.length());
            }
        }
         
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            Trie trav = rootReverse;
            if (query.charAt(0) != '?') continue;
            for (int j = query.length() - 1; j >= 0; j--) {
                char c = query.charAt(j);
                if (c == '?') {
                    answer[i] = trav.getNumChildrenWithLen(query.length());
                    break;
                }
                trav = trav.getChild(c);
                if (trav == null) {
                    answer[i] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    
    class Trie {
        char c;
        HashMap<Character, Trie> children;
        HashMap<Integer, Integer> numChildrenWithLen;
        
        Trie(char c) {
            this.c = c;
            children = new HashMap<Character, Trie>();
            numChildrenWithLen = new HashMap<Integer, Integer>();
        }
        
        Trie putChild(Trie t, int len) {
            if (!children.containsKey(t.c)) {
                children.put(t.c, t);
            }
            if (numChildrenWithLen.containsKey(len)) {
                numChildrenWithLen.put(len, numChildrenWithLen.get(len) + 1);
            }
            else {
                numChildrenWithLen.put(len, 1);
            }
            return children.get(t.c);
        }
        
        Trie getChild(char c) {
            return children.get(c);
        }
        
        int getNumChildrenWithLen(int len) {
            if (numChildrenWithLen.containsKey(len)) return numChildrenWithLen.get(len);
            return 0;
        }
    }
}
