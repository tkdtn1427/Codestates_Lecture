package Section2.DailyCoding2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


//리팩토링 필요
public class _45_robotPath2 {
    public static void main(String[] args) {
        int[][] room = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1},
        };
        int[] src = new int[]{3, 0};
        int sDir = 1;
        int[] dst = new int[]{2, 2};
        int dDir = 2;
        int output = robotPath2(room, src, sDir, dst, dDir);
        System.out.println(output);

        for(int i=0; i<room.length; i++){
            System.out.println(Arrays.toString(room[i]));
        }
    }

//    static int robotPath2(int[][] room, int[] src, int sDir, int[] dst, int dDir) {
//
//        int[] up = new int[]{-1,0,1};
//        int[] right = new int[]{0,1,2};
//        int[] down = new int[]{1,0,3};
//        int[] left = new int[]{0,-1,4};
//        int count =0;
//
//        room[src[0]][src[1]] = 1;
//
//        if(sDir == 1){
//            move(room,src,sDir,dst,dDir,up,count+1);
//            move(room,src,sDir,dst,dDir,right,count);
//            move(room,src,sDir,dst,dDir,down,count);
//            move(room,src,sDir,dst,dDir,left,count);
//        }else if(sDir == 2){
//            move(room,src,sDir,dst,dDir,up,count);
//            move(room,src,sDir,dst,dDir,right,count+1);
//            move(room,src,sDir,dst,dDir,down,count);
//            move(room,src,sDir,dst,dDir,left,count);
//        }else if(sDir == 3){
//            move(room,src,sDir,dst,dDir,up,count);
//            move(room,src,sDir,dst,dDir,right,count);
//            move(room,src,sDir,dst,dDir,down,count+1);
//            move(room,src,sDir,dst,dDir,left,count);
//        }else{
//            move(room,src,sDir,dst,dDir,up,count);
//            move(room,src,sDir,dst,dDir,right,count);
//            move(room,src,sDir,dst,dDir,down,count);
//            move(room,src,sDir,dst,dDir,left,count+1);
//        }
//
//
//        return room[dst[0]][dst[1]];
//    }
//
//    static void move(int[][] room, int[] src, int sDir, int[]dst, int dDir, int[] rot, int count){
//        int add_num = rotated(sDir,rot[2]);
//        if(add_num != 0) {
//            count += add_num + 1;
//        }
//
//        sDir = rot[2];
//        int[] prev = new int[]{src[0],src[1]};
//
//        prev[0] += rot[0];
//        prev[1] += rot[1];
//
//        if(prev[0] >= 0 && prev[1] >= 0 && prev[0] < room.length && prev[1] < room[0].length && room[prev[0]][prev[1]] != 1){
//            if(room[prev[0]][prev[1]] == 0){
//                room[prev[0]][prev[1]] = count;
//            }else if(room[prev[0]][prev[1]] > count){
//                room[prev[0]][prev[1]] = count;
//            }else{
//                return ;
//            }
//        }else{
//            return ;
//        }
//
//        if(prev[0] == dst[0] && prev[1] == dst[1]){
//            room[prev[0]][prev[1]] += rotated(sDir, dDir);
//            return ;
//        }
//
//        int[] up = new int[]{-1,0,1};
//        int[] right = new int[]{0,1,2};
//        int[] down = new int[]{1,0,3};
//        int[] left = new int[]{0,-1,4};
//
//        move(room,prev,sDir,dst,dDir,up,count);
//        move(room,prev,sDir,dst,dDir,right,count);
//        move(room,prev,sDir,dst,dDir,down,count);
//        move(room,prev,sDir,dst,dDir,left,count);
//    }
//
//    static int rotated(int pre, int next){
//        int tmp = Math.abs(pre - next);
//
//        if(tmp == 2) return 2;
//        else if(tmp ==0) return 0;
//        else{
//            return 1;
//        }
//    }


//===================================================================================

    static int robotPath2(int[][] room, int[] src, int sDir, int[] dst, int dDir) {
        // 가로와 세로의 길이
        int R = room.length;
        int C = room[0].length;

        // 4가지 방향: 위(1), 오른쪽(2), 아래(3), 왼쪽(4)
        // 차례대로 [방향, 상하이동, 좌우이동]
        int[][] MOVES = new int[][]{
                {1, -1, 0}, // UP
                {2, 0, 1}, // RIGHT
                {3, 1, 0}, // DOWN
                {4, 0, -1} // LEFT
        };

        // 각 위치별 최소의 동작으로 도달 가능한 경우의 방향을 저장
        int[][] directions = new int[R][C];
        // 각 위치별 최소 동작의 수를 저장. 편의상 거리(dist)로 표현
        int[][] dist = new int[R][C];

        for(int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                directions[row][col] = 0;
                dist[row][col] = Integer.MAX_VALUE;
            }
        }

        // bfs 구현을 위해 큐를 선언한다.
        Queue<Integer[]> queue = new LinkedList<>();

        // 출발 지점의 좌표
        int sRow = src[0], sCol = src[1];
        directions[sRow][sCol] = sDir;
        dist[sRow][sCol] = 0;

        // 목표 지점의 좌표
        int dRow = dst[0], dCol = dst[1];
        queue.offer(new Integer[]{sRow, sCol});

        while(!queue.isEmpty()) {
            Integer[] data = queue.poll();
            int row = data[0], col = data[1];
            int dir = directions[row][col];

            for(int[] move : MOVES) {
                int nDir = move[0], rDiff = move[1], cDiff = move[2];
                // 이동할 좌표
                int nRow = row + rDiff;
                int nCol = col + cDiff;

                // 유효한 좌표가 아니거나
                // 해당 좌표가 장애물(1)인 경우 건너뛴다.
                if (!isValid(nRow, nCol, R, C) || room[nRow][nCol] == 1) continue;

                // 현재 위치의 방향과 목표 위치의 방향과의 차이
                int dDiff = Math.abs(nDir - dir);
                int candidate;

                if(dDiff == 0) {
                    // 차이가 없는 경우
                    // 출발 지점에서의 방향과 이동하려는 방향이 같은 경우
                    // 직진만 하면 되지만 그러기 위해서는 1로 초기화 되어야 한다.
                    candidate = (isValid(row, col, R, C) && dist[row][col] != 0) ? dist[row][col] : 1;
                } else if(dDiff == 2) {
                    // 2번 회전해야 하는 경우: 회전 2 + 직진 1
                    candidate = dist[row][col] + 3;
                } else {
                    // 1번만 회전해도 되는 경우: 회전 1 + 직진 1
                    candidate = dist[row][col] + 2;
                }

                if (nRow == dRow && nCol == dCol) {
                    // 다음에 도달하는 곳이 목표 지점인 경우
                    // 목표 방향까지 고려해서 필요한 거리를 계산한다.
                    int eDiff = Math.abs(nDir - dDir);
                    if (eDiff == 0) {
                        candidate = candidate;
                    } else if (eDiff == 2) {
                        candidate = candidate + 2;
                    } else {
                        candidate = candidate + 1;
                    }
                }

                if (candidate < dist[nRow][nCol]) {
                    // 유망한 좌표는 큐에 삽입한다.
                    queue.offer(new Integer[]{nRow, nCol});
                    dist[nRow][nCol] = candidate;
                    // 방향은 전부 같다.
                    directions[nRow][nCol] = nDir;
                }
            }
        }
        return dist[dRow][dCol];
    }

    // 유효성 검사(이동이 가능한지 여부를 판단)를 위한 메서드
    static boolean isValid(int row, int col, int R, int C) {
        return (row >= 0 && row < R && col >= 0 && col < C);
    }
}
