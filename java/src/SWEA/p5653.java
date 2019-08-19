package SWEA;

import java.util.*;

/*
 * 190818
 * 
 * SW Expert Academy
 * [모의 SW 역량테스트] 줄기세포배양 
 * 
 * ->실패 
 * 참고 : https://godute.tistory.com/7
 * 
 * BFS
 * 
 */

class Cell {
    public int i, j, time, life;
    public boolean init;
    public Cell(int i, int j, int time, int life, boolean init) {
        this.i = i;
        this.j = j;
        this.time = time;
        this.life = life;
        this.init = init;
    }
}
public class p5653 {
    public static int T;
    public static int N, M, K;
    public static int[][] Grid = new int[350][350];
    public static int[][] depth = new int[350][350];
    public static boolean[][] Visited = new boolean[350][350];
    public static int[][] d = { {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static Queue<Cell> q = new LinkedList<Cell>();
    
    
    public static int BFS() {
        int result = 0;
        while(!q.isEmpty()) {
            Cell cell = q.poll();
            if(cell.life == -Grid[cell.i][cell.j])
                continue;
            if(cell.time == K) {
                result++;
                continue;
            }
            if(cell.init) {
                cell.life = Grid[cell.i][cell.j];
            }
            if(cell.life > 0) {
                Cell new_cell = new Cell(cell.i, cell.j, cell.time + 1, cell.life - 1, false);
                q.offer(new_cell);
                continue;
            }
            else if(cell.life == 0) {
                Cell c = new Cell(cell.i, cell.j, cell.time + 1, cell.life -1, false);
                q.offer(c);
                for(int k = 0; k < 4; k++) {
                    int next_i = cell.i + d[k][0];
                    int next_j = cell.j + d[k][1];
                    if(!Visited[next_i][next_j]) {
                        Visited[next_i][next_j] = true;
                        Grid[next_i][next_j] = Grid[cell.i][cell.j];
                        depth[next_i][next_j] = cell.time + 1;
                        Cell new_cell = new Cell(next_i, next_j, cell.time + 1, cell.life, true);
                        q.offer(new_cell);
                    }
                    else if(Visited[next_i][next_j] && depth[next_i][next_j] == cell.time + 1) {
                        if(Grid[next_i][next_j] < Grid[cell.i][cell.j])
                            Grid[next_i][next_j] = Grid[cell.i][cell.j];
                    }
                }
            }
            else if(cell.life != -Grid[cell.i][cell.j]) {
                Cell new_cell = new Cell(cell.i, cell.j, cell.time + 1, cell.life - 1, false);
                q.offer(new_cell);
                continue;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            for(int i= 0; i<N; i++) {
                for(int j =0; j < M; j++) {
                    Grid[150 + i][150 + j] = sc.nextInt();
                    if(Grid[150+i][150 + j] != 0) {
                        Visited[150 + i][150 + j] = true;
                        depth[150 + i][150 + j] = 0;
                        Cell cell = new Cell(150 + i, 150 + j, 0, Grid[150 + j][150 + j], true);
                        q.offer(cell);
                    }
                }
            }
            System.out.println("#" + test_case + " " + BFS());
            for(int i = 0; i < 350; i++) {
                for(int j = 0; j< 350; j++) {
                    Grid[i][j] = 0;
                    Visited[i][j] = false;
                    depth[i][j] = 0;
                }
            }
        }
    }
}