package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
 * 190807
 * 
 * 백준 1966번
 * -> 분류 : queue
 * 
 * [ 프린터 큐 ]
 * 
 * => 성공 
 */


// Document 객체 정의 (데이터마다 인덱스값을 저장하기 위해)
class Document{
	int data;	//data - 중요도 
	int index;	//index - 객체가 처음 들어왔을 때 index -> 후에 특정문서가 몇번째로 인쇄되는지 알아내기 위함.
}

public class p1966 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int testcase = sc.nextInt();
		
		for(int i=0; i<testcase; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			ArrayList<Integer> arr = new ArrayList<Integer>();	// 중요도만을 저장하는 ArrayList -> 중요도 최대값을 구할 때 쓰임.
			Queue<Document> que = new LinkedList<Document>(); 	// que에 Document 객체들을 저장.
			
			for(int j =0; j<N; j++) {
				Document dc = new Document();
				dc.data = sc.nextInt();	
				dc.index = j;			
				arr.add(dc.data);		// 중요도만 따로 arrayList에 저장
				que.add(dc);
			}
			
			int result = 0;
			Document tmp;

			while(!(que.isEmpty())) {
				if(que.peek().data >= Collections.max(arr)) {	//나갈 객체의 중요도가 기존 큐에 존재하는 중요도보다 크거나 같은지 
					tmp = que.poll();
					arr.set(tmp.index, 0);
					result++;	// 몇번째 출력 계산
					if(tmp.index == M)	// 나간 객체가 우리가 찾는 문서이면 break;
						break;
				}
				else {					// 나갈 객체의 중요도가 기존 큐에 존재하는 중요도보다 작으면 
					tmp = que.poll();	// poll한 뒤
					que.add(tmp);		// poll한 객체를 다시 큐에 넣는다.
				}
			}
			System.out.println(result);
			
		}
	}

}
