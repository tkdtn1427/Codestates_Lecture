package Section2.Data_Structure;
import java.lang.reflect.Array;
import java.util.*;

public class _12_linked_edges {
    public static void main(String[] args) {
        int result = connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5},
        });
        System.out.println(result);
    }

//    static int connectedVertices(int[][] edges) {
//        // TODO:
//        List<List<Integer>> edge = new ArrayList<>();
//        for (int[] arr : edges) {
//            List<Integer> arr_l = new ArrayList<Integer>();
//            arr_l.add(arr[0]);
//            arr_l.add(arr[1]);
//            edge.add(arr_l);
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> num = new ArrayList<>();
//        boolean find = false;
//
//        num.add(edge.get(0).get(0));
//        num.add(edge.get(0).get(1));
//        result.add(num);
//        edge.remove(0);
//
//        while (edge.size() != 0) {
//            find = false;
//            //[0 1] [4 5] [5 1]
//            for (int i = 0; i < edge.size(); i++) {
//                for (List<Integer> tmp : result) {
//                    if (tmp.contains(edge.get(i).get(0)) || tmp.contains(edge.get(i).get(1))){
//                        tmp.add(edge.get(i).get(0));
//                        tmp.add(edge.get(i).get(1));
//                        edge.remove(i);
//                        find = true;
//                        break;
//                    }
//                }
//                if(find == true){
//                    break;
//                }
//            }
//            if(find == false){
//                List<Integer> tmp = new ArrayList<>();
//                tmp.add(edge.get(0).get(0));
//                tmp.add(edge.get(0).get(1));
//                result.add(tmp);
//                edge.remove(0);
//            }
//
//        }
//        return result.size();
//    }

    static int connectedVertices(int[][] edges) {
        int max=0;
        for(int i=0; i<edges.length; i++){
            for(int j=0; j<edges[0].length; j++){
                if(max < edges[i][j])  max=edges[i][j];
            }
        }

        boolean visit[] = new boolean[max+1];
        int[][] result = new int[max+1][max+1];
        int count=0;

        for(int[] tmp : edges){
            result[tmp[0]][tmp[1]] = 1;
            result[tmp[1]][tmp[0]] = 1;
        }

        for(int i=0; i<visit.length; i++){
            System.out.println(Arrays.toString(visit));;
            System.out.println();
            if(!visit[i]){
                count++;
                //dfs_search(visit,i,result);
                bfs_search(visit,i,result);
            }
        }
        return count;
    }

    static void dfs_search(boolean[] visit, int num, int[][] result){
        visit[num] = true;
        for(int i=0; i<visit.length; i++){
            if(result[num][i] == 1 && !visit[i]){
                dfs_search(visit,i,result);
            }
        }
    }

    static void bfs_search(boolean[] visit, int num, int[][] result){
        List<Integer> list = new ArrayList<>();
        visit[num] = true;

        list.add(num);
        while(list.size() != 0){
            int row = list.remove(0);
            for(int i=0; i<visit.length; i++){
                if(result[row][i] == 1 && !visit[i]){
                    visit[i] = true;
                    list.add(i);
                }
            }
        }
    }
}
