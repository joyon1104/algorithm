package baekjoon;


import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class p16637_O {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String t = sc.next();
 
        int[] arrN = new int[n/2+1];
        int[] buho = new int[n/2];
        int idx1 = 0;
        int idx2 = 0;
        // 숫자와 부호 나눠서 받기
        for(int i=0;i<t.length();i++){
            if(i%2==0) arrN[idx1++] = t.charAt(i)-'0';
            else buho[idx2++] = t.charAt(i);
        }
        // 앞에서 부터 연산이니 Queue를 이용해보자
        makePowerSet(n/2,arrN,buho);
        System.out.println(result);
    }
 
    static int result = Integer.MIN_VALUE;
    private static void solve(boolean[] preCul,int[] arrN,int[] arrBuho){
        Queue<Integer> queue = new LinkedList<>();
        // 첫 숫자 담기
        queue.add(arrN[0]);
        // 우선 연산해주기
        for(int i=0;i<preCul.length;i++){
            // 우선 연산이라면 앞의 숫자를 빼서 연산해주기
            if(preCul[i]){
                int tN = ((LinkedList<Integer>) queue).pollLast();
                switch (arrBuho[i]){
                    case '+':
                        queue.add(tN+arrN[i+1]);
                        break;
                    case '-':
                        queue.add(tN-arrN[i+1]);
                        break;
                    case '*':
                        queue.add(tN*arrN[i+1]);
                        break;
                }
                if(i<preCul.length-1) preCul[i+1] = false;
            }else {
                queue.add(arrBuho[i]);
                queue.add(arrN[i+1]);
            }
        }
        // 남은 연산해주기
        int tResult = queue.poll();
        while(!queue.isEmpty()){
            int buho = queue.poll();
            int tN = queue.poll();
            switch (buho){
                case '+':
                    tResult += tN;
                    break;
                case '-':
                    tResult -= tN;
                    break;
                case '*':
                    tResult *= tN;
                    break;
            }
        }
        result = Math.max(result,tResult);
    }
    private static void makePowerSet(long n,int[] arrN,int[] arrBuho){
        boolean[] preCul = new boolean[(int)n];
 
        for(long i=0;i<(1<<n);i++){
            // 조합 만들기
            for(long j=0;j<n;j++){
                if(((1<<j)&i)>0){
                    preCul[(int)j] = true;
                }
            }
            // 만든 조합으로 연산하기
            solve(preCul,arrN,arrBuho);
            for(int j=0;j<n;j++)
                preCul[j] = false;
        }
    }
}