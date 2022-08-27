package Section2.DailyCoding2;

import java.util.ArrayList;
import java.util.List;



//Reset and Resolve
public class _57_decompression {
    public static void main(String[] args) {
        int[][] image = new int[][]{
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1}
        };
        String result = decompression(image);
        System.out.println(result);
    }

    static StringBuilder result;
    static String decompression(int[][] image) {
        result = new StringBuilder("");
        recur(image,image.length,0,0);

        return result.toString();
    }

    static void recur(int[][] image, int size,int row, int col){

        boolean find = false;
        int first = image[row][col];

        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(first != image[i][j]){
                    result.append("X");
                    recur(image,size/2,row,col);
                    recur(image,size/2,row,col+size/2);
                    recur(image,size/2,row+size/2,col);
                    recur(image,size/2,row+size/2,col+size/2);
                    find = true;
                    break;
                }
            }
            if(find == true) break;
        }

        if(find == false) result.append(first);
    }
}