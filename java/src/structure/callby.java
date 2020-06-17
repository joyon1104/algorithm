package structure;

import java.util.ArrayList;
import java.util.Arrays;

public class callby {
	
	static class Circle{
		int radius;
		String name;
		
		public Circle(int radius, String name) {
			this.radius = radius;
			this.name = name;
		}
	}

	static void func(int[] map) {
		map[0] = 1;
	}
	
	static void func2(int a) {
		a += 2;
	}
	
	static void func3(String s) {
		s = "AAA";
	}
	
	static void func4(ArrayList arrlist) {
		arrlist.remove(0);
	}
	
	static void func5(Circle c) {
		c.name = "ball";
	}

	public static void main(String[] args) {
		int[] B = {0,1,1,1};
		func(B);
		System.out.println(Arrays.toString(B)); //{1,1,1,1} -> 변경됨 (call by reference)
		
		final int a = 0;
		// a +=2; -> final 붙이면 해당 줄은 에러 남. 
		System.out.println(a);
		func2(a);
		System.out.println(a);	//0	-> 변경안됨 (call by value)
		
		String s = "A";
		func3(s);
		System.out.println(s);	//A	-> 변경안됨 (call by value)
		
		ArrayList<Integer> arrlist = new ArrayList<>();
		arrlist.add(1);
		arrlist.add(2);
		func4(arrlist);
		System.out.println(arrlist);	//[2]	-> 변경됨 (call by reference)
		
		Circle c1 = new Circle(5,"pizza");
		func5(c1);
		
		System.out.println(c1.name);	//ball	-> 변경됨 (call by reference)
	
		int a1 = 5;
		double a2 = (float)a1;
		System.out.println(a2);
		Integer aa = new Integer(2); Integer b = new Integer(2); System.out.println( aa == b );
		//int cc = 9/0;
		
	}
}
