import java.util.Arrays;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] startPoint = new int[50000];
        int[] endPoint = new int[50000];
        int[] degree = new int[50000];

        for(int i = 0; i < nums.length; i++){
            degree[nums[i]]++;
            if(degree[nums[i]] == 1){
                startPoint[nums[i]] = i;
            }
            endPoint[nums[i]] = i;
        }
        int max_degree = 0;
        int min_array = 50001;
        for(int i = 0; i < degree.length; i++){
            if(degree[i] >= max_degree){
                max_degree = degree[i];
            }
        }
        for(int i = 0; i < degree.length; i++) {
            if (degree[i] == max_degree) {
                if (endPoint[i] - startPoint[i] < min_array) {
                    min_array = endPoint[i] - startPoint[i] + 1;
                }
            }
        }
        return min_array;
    }
}
