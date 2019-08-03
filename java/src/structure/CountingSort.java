package structure;

// 정리 다시 할 것!
// 참고 : 
// https://m.blog.naver.com/PostView.nhn?blogId=writer0713&logNo=221144576738&proxyReferer=https%3A%2F%2Fwww.google.com%2F

public class CountingSort {

	
	public static void main(String[] args) {

	    int[] arr = {0,4,16,15,8,7,13,14,2,5};

	    int[] result = countingSort(arr);

	    for(int item : result) {
	        System.out.print(item + " ");
	    }
	}

	private static int[] countingSort(int[] arr) {

	    int max = getMax(arr);

	    int[] countArr = new int[max + 1]; // 0 ~ max
	    int[] resultArr = new int[arr.length]; // 결과를 담을 배열

	    // 배열에 있는 숫자들의 개수를 세어서 countArr에 저장
	    for(int i = 0; i < arr.length; i++) {
	        countArr[arr[i]]++;
	    }

	    // countArr의 이전 값과 현재 값을 더하는 과정
	    for(int i = 1; i < countArr.length; i++) {
	        countArr[i] += countArr[i - 1];
	    }

	    for(int i = arr.length - 1; i >= 0; i--) {
	        resultArr[--countArr[arr[i]]] = arr[i]; // countArr[arr[i]]는 인자가 들어갈 n번째 자리이므로 실제 배열에서는 - 1을 한 Index가 되어야 한다.
	    }

	    return resultArr;

	}

	private static int getMax(int[] arr) {

	    int max = arr[0];

	    for(int i = 1; i < arr.length; i++) {
	        if(arr[i] > max) {
	            max = arr[i];
	        }
	    }

	    return max;

	}
}
