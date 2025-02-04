public class Main {
    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0,40000},
                {40000,0},
                {0,0},
                {40000,40000},
        };
        Solution solution = new Solution();
        System.out.println(solution.minAreaFreeRect1(points));
    }
}