package programmers;

/*
 * [베스트앨범]
 */
import java.util.*;
class p200319_3 {
    public class Song implements Comparable<Song>{
        String genre;
        int play;
        public Song(String genre, int play){
            this.genre = genre;
            this.play = play;
        }
        @Override
        public int compareTo(Song target){
            if(this.play > target.play)
                return -1;
            else if(this.play < target.play)
                return 1;
            return 0;
        }
    }

    public class Pair implements Comparable<Pair>{
        int idx;
        int nplay;
        public Pair(int idx, int nplay){
            this.idx = idx;
            this.nplay = nplay;
        }
        @Override
        public int compareTo(Pair target){
            if(this.nplay > target.nplay)
                return -1;
            else if(this.nplay < target.nplay)
                return 1;
            return 0;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, PriorityQueue<Pair>> hm2 = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(!hm.containsKey(genres[i])){
                hm.put(genres[i],plays[i]);
                hm2.put(genres[i],new PriorityQueue<>());
            }
            else
                hm.put(genres[i],hm.get(genres[i])+plays[i]);
            hm2.get(genres[i]).add(new Pair(i,plays[i])); 
        }

        PriorityQueue<Song> pq1 = new PriorityQueue<>();
        for(String k : hm.keySet())
            pq1.add(new Song(k,hm.get(k)));

        ArrayList<Integer> arrlist = new ArrayList<>();
        while(!pq1.isEmpty()){
            String tmp = pq1.poll().genre;
            if(hm2.get(tmp).size()==1)		// 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
                arrlist.add(hm2.get(tmp).poll().idx);
            else{
                arrlist.add(hm2.get(tmp).poll().idx);
                arrlist.add(hm2.get(tmp).poll().idx);
            }
        }
        //System.out.println(arrlist);
        int[] answer = new int[arrlist.size()];
        for(int i=0; i<answer.length ;i++)
            answer[i] = arrlist.get(i);
        return answer;
    }
}