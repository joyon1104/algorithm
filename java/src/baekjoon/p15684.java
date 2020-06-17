package baekjoon;
import java.util.*;

/*
 * [��ٸ� ����]
 * - �׳� ��� �����ؾ����� �ʹ� ��������
 * - ��ó: https://suriisurii.tistory.com/75 [surisuri]
 */

public class p15684 {
 
    static int n,m,h,ans=4;
    static boolean[][] a;
    static boolean check(boolean[][] a) {
        for(int i=1; i<=m; i++) {
            int start = i, end = i;
            for(int j=1; j<=n; j++) {
                if(a[j][end]) {
                    ++end;
                    continue;
                }
                if(end==1) continue;
                if(!a[j][end]) {
                    if(a[j][end-1]) --end;
                }
            }
            if(start!=end) return false;
        }
        return true;
    }
    static void go(int x, int y, int cnt, boolean[][] a) {
        if(y==m+1) {
            ++x;
            y=1;
        }
        if(cnt==3 || (x==n && y==m)) {
            if(check(a))
                ans = Math.min(ans, cnt);
            return;
        }
         
        //��ġ ���ϰų�
        go(x, y+1, cnt, a);
         
        //������ ���μ��� ���� ��
        if(y==m || a[x][y] || (y!=1 && a[x][y-1]) || a[x][y+1]) return;
         
        //��ġ�ϰų�
        a[x][y] = true;
        go(x, y+1, cnt+1, a);
        a[x][y] = false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        h = in.nextInt();
        n = in.nextInt();
        a = new boolean[n+2][m+2];
         
        for(int i=0; i<h; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[x][y] = true;
        }
         
        go(1,1,0,a);
        System.out.println(ans==4?-1:ans);
        in.close();
    }
}

