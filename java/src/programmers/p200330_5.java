package programmers;
/*
 * [�湮 ����]
 * -> 4���� �迭 ��� -> ������ �������� ���� �����ϸ� ����.
 */
class p200330_5 {
    // ��,�Ʒ�,������,���ʼ���
    static int[] intX = { 0, 0, 1,-1 } ;
    static int[] intY = { 1,-1, 0, 0 } ;
    
    public static int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visits = new boolean[11][11][11][11];
        char[] dirss = dirs.toCharArray();
        
        int index = 0 ;
        int x = 0 ;
        int y = 0 ;
        int nextX = 5;
        int nextY = 5;
        
        for ( int i = 0 ; i < dirss.length; i ++ ) {
            int dir = dirss[i];
            if( dir == 'U') index = 0; 
            else if( dir == 'D') index = 1;
            else if( dir == 'R') index = 2;
            else if( dir == 'L') index = 3;
            
            x = nextX ;
            y = nextY ;
            nextX += intX[index];
            nextY += intY[index];
            
            if ( nextX < 0 || nextX > 10 || nextY < 0 || nextY > 10 ) {
                nextX -= intX[index];
                nextY -= intY[index];
                continue;
            }
            if ( !visits[x][y][nextX][nextY] ) {
                visits[x][y][nextX][nextY] = true;
                visits[nextX][nextY][x][y] = true;
                answer++;
            }            
        }
        
        return answer;
    }
}