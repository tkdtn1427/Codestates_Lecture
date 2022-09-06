package Section2.DailyCoding2;

import java.util.Arrays;

public class _60_countislands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'0', '1', '0', '1', '0','1'},
                {'1','0','1','0','1','0'},
                {'0','1','0','1','0','1'},
                {'1','0','1','0','1','0'},
                {'0','1','0','1','0','1'}
        };
        int result = countIslands(grid);
        System.out.println(result);
    }

    static int countIslands(char[][] grid) {
        int count=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    recur(grid,i,j);
                    count++;
                }
            }
        }
        for(char[] tmp : grid) System.out.println(Arrays.toString(tmp));
        return count;
    }

    static void recur(char[][] grid,int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return ;

        if(grid[row][col] == '1'){
            grid[row][col] = 'x';
            recur(grid,row+1,col);
            recur(grid,row-1,col);
            recur(grid,row,col+1);
            recur(grid,row,col-1);
        }else{
            return ;
        }
    }
}
