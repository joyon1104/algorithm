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
        
        System.out.println("ȸ�� �ϱ� ��");
        print(n, A);

        System.out.println("�ð� ���� 90�� ȸ��");
        int[][] rightResult = rightRotate(n, A);
        print(n, rightResult);

        System.out.println("�ݽð� ���� 90�� ȸ��");
        int[][] leftResult = leftRotate(n, A);
        print(n, leftResult);

        System.out.println("�� �Ʒ� ������");
        int[][] reverseTBResult = reverseTopBottom(n, A);
        print(n, reverseTBResult);

        System.out.println("�� �� ������");
        int[][] reverseLRResult = reverseLeftRight(n, A);
        print(n, reverseLRResult);

    }

    // �ðԹ������� 90�� ȸ��, ���������� 90�� ȸ��
    public static int[][] rightRotate(int n, int[][] A) {
        int[][] B = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                B[i][j] = A[n-j-1][i];
            }
        }

        return B;
    }

    // �ݽð� �������� 90�� ȸ��, 270��, -90��, �������� 90��
    public static int[][] leftRotate(int n, int[][] A) {
        int[][] B = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                B[i][j] = A[j][n-i-1];
            }
        }
        return B;
    }

    // ��, �Ʒ��� ������
    public static int[][] reverseTopBottom(int n, int[][] A) {
        int[][] B = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                B[i][j] = A[n-i-1][j];
            }
        }

        return B;
    }

    // �¿�� ������ ȸ��
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