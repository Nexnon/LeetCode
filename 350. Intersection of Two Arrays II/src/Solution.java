import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numsMap = new HashMap<>();
        if (nums1.length < nums2.length) {
            for (int k : nums1) {
                if (numsMap.containsKey(k)) {
                    numsMap.put(k, numsMap.get(k) + 1);
                } else {
                    numsMap.put(k, 1);
                }
            }
            for (int j : nums2) {
                if (numsMap.containsKey(j) && numsMap.get(j) > 0) {
                    numsMap.put(j, numsMap.get(j) - 1);
                    result.add(j);
                }
            }
        }
        else{
            for (int j : nums2) {
                if (numsMap.containsKey(j)) {
                    numsMap.put(j, numsMap.get(j) + 1);
                } else {
                    numsMap.put(j, 1);
                }
            }
            for(int j : nums1){
                if (numsMap.containsKey(j) && numsMap.get(j) > 0) {
                    numsMap.put(j, numsMap.get(j) - 1);
                    result.add(j);
                }
            }
        }
        return result.stream().mapToInt(a -> a).toArray();
    }
}
