package structure;

import java.util.Stack;

/*
 * Stack (스택)
 * - LIFO (Last In First Out)
 */

public class stack {
	
	public static void main(String[] args) {
		
		//Stack 정의 (타입 지정 안해도 됨)
		Stack<Integer> stack = new Stack<Integer>();
		Stack stack2 = new Stack();
		
		// 데이터 입력
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        
        // 데이터 출력
        System.out.println("마지막에 넣은 데이터부터 출력..");
        System.out.println(stack.pop());	// pop하면 stack에서 나오면서 삭제됨.
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
        // 에러 발생 -> 더 이상 스택안에 남아있는 데이터가 없기 때문 
        //System.out.println(stack.pop()); 
        
        System.out.println("---------------");
        
        // 데이터 입력
        stack.push(5);
        stack.push(4);
        stack.push(3);
        
        System.out.println(stack.size());    // 사이즈 확인
        System.out.println(stack.peek());    // 데이터를 빼지 않고 현재 가장 위에 위치하는 데이터 확인
        System.out.println(stack.size());    // 사이즈 확인
        System.out.println(stack.search(4));	// 스택에서 데이터 4를 찾아 해당 인덱스를 출력

		
	}
}
