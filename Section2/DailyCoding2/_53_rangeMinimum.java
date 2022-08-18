package Section2.DailyCoding2;

import java.util.Arrays;

public class _53_rangeMinimum {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 11, 12, 3, 6, 7, 8, 9};
        int[][] ranges = new int[][]{
                {4, 7},
                {0, 2}
        };
        int[] mins = rangeMinimum(arr, ranges);
//        System.out.println(mins);
        System.out.println(Arrays.toString(mins));
    }

//    static int[] rangeMinimum(int[] arr, int[][] ranges) {
//
//        int[] result = new int[ranges.length];
//        int idx =0;
//
//        for(int i=0; i<ranges.length; i++){
//            int start = ranges[i][0];
//            int end = ranges[i][1];
//
//            int[] temp = Arrays.copyOfRange(arr,start,end+1);
//            int min = Arrays.stream(temp).min().orElse(0);
//            result[idx++] = min;
//        }
//
//        return result;
//    }

//======================================================================

    static int[] tree;

    static int[] rangeMinimum(int[] arr, int[][] ranges) {
        // 트리 전체의 높이(루트 노트에서 가장 깊은 리프 노드까지의 거리)를 구하고
        // 전체 배열의 크기를 구한다.
        double log2 = Math.log(arr.length) / Math.log(2);
        double height = Math.ceil(log2);
        double size = Math.pow(2, height + 1) - 1;
        tree = new int[(int)size];
        Arrays.fill(tree, 0);
        createMinTree(arr, 0, arr.length - 1, tree, 0);
        return mins(ranges, arr);
    }

    static int findMin(int ts, int te, int rs, int re, int idx) {
        if (rs <= ts && te <= re) {
            return tree[idx];
        }

        if (te < rs || re < ts) {
            return Integer.MAX_VALUE;
        }

        int mid = (ts + te) / 2;
        return Math.min(
                findMin(ts, mid, rs, re, 2 * idx + 1),
                findMin(mid + 1, te, rs, re, 2 * idx + 2)
        );
    }

    static int[] mins(int[][] range, int[] arr) {
        int[] result = new int[range.length];
        for(int i = 0; i < range.length; i++) {
            int start = range[i][0];
            int end = range[i][1];
            result[i] = (findMin(0, arr.length - 1, start, end, 0));
        }
        return result;
    }

    static int createMinTree(int[] arr, int ts, int te, int[] tree, int idx) {
        if(ts == te) {
            tree[idx] = arr[ts];
            return arr[ts];
        }
        int mid = (ts + te) / 2;
        tree[idx] = Math.min(
                createMinTree(arr, ts, mid, tree, (idx * 2) + 1),
                createMinTree(arr, mid + 1, te, tree, (idx * 2) + 2)
        );
        return tree[idx];
    }
}
