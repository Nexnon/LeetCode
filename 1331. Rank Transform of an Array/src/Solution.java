import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] result = new int[arr.length];
        List<Integer> list = new HashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toList())).stream().sorted().collect(Collectors.toList());
        for(int i = 0; i < result.length; i++){
            result[i] = Collections.binarySearch(list, arr[i])+1;
        }
        return result;
    }
}
