package structure;

import java.util.Scanner;

public class Array_Rotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        int n = sc.nextInt();
        int[][] A = new int[n][n];
        */
        int n = 3;
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};

        // Filling data.
        int K = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                A[i][j] = K++;
            }
        }
        
        System.out.println("회전 하기 전");
        print(n, A);

        System.out.println("시계 방향 90도 회전");
        int[][] rightResult = rightRotate(n, A);
        print(n, rightResult);

        System.out.println("반시계 방향 90도 회전");
        int[][] leftResult = leftRotate(n, A);
        print(n, leftResult);

        System.out.println("위 아래 뒤집기");
        int[][] reverseTBResult = reverseTopBottom(n, A);
        print(n, reverseTBResult);

        System.out.println("좌 우 뒤집기");
        int[][] reverseLRResult = reverseLeftRight(n, A);
        print(n, reverseLRResult);

    }

    // 시게방향으로 90도 회전, 오른쪽으로 90도 회전
    public static int[][] rightRotate(int n, int[][] A) {
        int[][] B = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                B[i][j] = A[n-j-1][i];
            }
        }

        return B;
    }

    // 반시계 방향으로 90도 회전, 270도, -90도, 왼쪽으로 90도
    public static int[][] leftRotate(int n, int[][] A) {
        int[][] B = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                B[i][j] = A[j][n-i-1];
            }
        }
        return B;
    }

    // 위, 아래로 뒤집기
    public static int[][] reverseTopBottom(int n, int[][] A) {
        int[][] B = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                B[i][j] = A[n-i-1][j];
            }
        }

        return B;
    }

    // 좌우로 뒤집기 회전
    public static int[][] reverseLeftRight(int n, int[][] A) {
        int[][] B = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                B[i][j] = A[i][n-j-1];
            }
        }

        return B;
    }

    public static void print(int n, int[][] array){
        // print
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}