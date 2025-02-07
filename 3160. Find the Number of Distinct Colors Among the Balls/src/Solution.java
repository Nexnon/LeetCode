import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] result = new int[queries.length];
        Map<Integer, Integer> balls = new HashMap<>();
        Map<Integer, Integer> countColors = new HashMap<>();
        for(int i = 0; i < queries.length; i++){
            int numberBall = queries[i][0];
            int colorBall = queries[i][1];
            if(balls.get(numberBall) != null)
                countColors.compute(balls.get(numberBall), (k, v) -> v != null && v != 0 ? (v-1 == 0 ? null : v-1): null);
            countColors.compute(colorBall, (k, v) -> v == null ? 1 : v + 1);
            balls.put(numberBall, colorBall);
            result[i] = countColors.values().size();
        }
        return result;
    }
}
