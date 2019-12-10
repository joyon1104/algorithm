package structure;
import java.util.*;

public class Hashset {
	public static void main(String[] args) {
	
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("BB");
		arr.add("AA");
		arr.add("AA");
		arr.add("BB");
		arr.add("BB");
		arr.add("CC");
		System.out.println(arr.toString());
		
		HashSet<String> hashset = new HashSet<String>(arr);
		System.out.println(hashset);
		
		ArrayList<String> arr2 = new ArrayList<String>(hashset);
		System.out.println(arr2.toString());
		System.out.println(arr2.get(1));
		
		int[] array = {3,4,1,5,8,6};
		System.out.println(Arrays.toString(array));
		
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		String str = "100.121.11";
		String[] sarr = str.split(".");
		System.out.println(Arrays.toString(sarr));
		
		//.(dot)로 split하기
		sarr = str.split("\\.");
		System.out.println(Arrays.toString(sarr));
	
	}

}



