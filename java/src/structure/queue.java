package structure;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Queue (큐)
 * - FIFO (First In First Out) 
 * - 큐를 구현한 클래스인 LinkedList, priorityQueue, priorityBlockingQueue 를 생성하여 사용
 * - BFS(너비우선탐색) 구현 시 큐가 사용됨. 
 */
public class queue {
	
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		
		//데이터 입력
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		queue.offer("E");
		
		//데이터 삭제 -> 첫번째 항목부터 삭제됨. 
		queue.remove();
		
		System.out.println(queue);
		
		System.out.println(queue.peek());	// 큐의 가장 맨 앞 값을 반환, 제거되지는 않음.
		System.out.println(queue.poll()); 	// 큐의 가장 맨 앞 값을 반환하고 해당 값은 제거됨.
		System.out.println(queue.isEmpty()); // 큐가 비었으면 true, 아니면 false를 리턴 
		
	}
}
