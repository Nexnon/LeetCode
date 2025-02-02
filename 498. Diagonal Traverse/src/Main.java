import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] test = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] test1 = new int[][]{{1,2},{3,4}};
        int[][] test2 = new int[][]{{3},{2}};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.findDiagonalOrder(test)));
    }
}