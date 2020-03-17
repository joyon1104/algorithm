package structure;
import java.util.*;

public class Replace_test {
	public static void main(String[] args) {
		String c = "))()((()";
		c = c.replaceAll("\\(\\)","");
		System.out.println(c);
	}
}
