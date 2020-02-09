package structure;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * List (ArrayList) 
 * - 빈틈없는 데이터 적재
 * - 순서가 있는 데이터의 모임
 * - 빈 element를 허용하지 않음.
 * 
 * < ArrayList & LinkedList >
 * - 인덱스를 이용한 검색이 많을 때 -> ArrayList
 * - 추가 / 삭제가 많을 때 -> LinkedList
 * 
 */

public class List {

	public static void main(String[] args) {
		
		// 1)ArrayList
		
		// 정의
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		// 추가 (index 0부터 차례로 추가됨)
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		System.out.println(arrayList);
		
		// 수정
		arrayList.set(1, 4);
		System.out.println(arrayList);
		
		// 삭제 (index값으로 삭제) -> String arrayList의 경우 삭제하고싶은 값을 입력하여 삭제할 수 있음.
		arrayList.remove(1);
		System.out.println(arrayList);
		
		
		/*
		 * ArrayList 함수
		 * arrayList.get(i) - i번째 값 불러오기 (= 배열 arr[i])
		 * arrayList.size() - 리스트 개수 불러오기 (= 배열 arr.length) 
		 * arrayList.clear() - 초기화
		 * list.indexOf("SuChang") -  앞에서 부터 "SuChang"의 위치 찾기
	     * list.lastIndexOf("SuChang") - 뒤에서 부터 "SuChang"의 위치 찾기
		 * Collections.sort(arrayList) - 정렬 메소드
		 */
		
		
		// 2)LinkedList
		LinkedList<String> linkedList = new LinkedList<String>();
		
		// 추가
		linkedList.add("A");
		linkedList.add("B");
		linkedList.add("C");
		System.out.println(linkedList);
		
		//수정
		linkedList.set(1, "D");
		System.out.println(linkedList);
		
		// 삭제 (index값으로 삭제)
		linkedList.remove(1);
		System.out.println(linkedList);

	}
}
