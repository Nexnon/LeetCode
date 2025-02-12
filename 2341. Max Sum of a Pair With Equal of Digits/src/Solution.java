import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> sumDigits = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int sumD = getSumDigits(nums[i]);
            if(!sumDigits.containsKey(sumD)){
                sumDigits.put(sumD, new ArrayList<>());
            }
            sumDigits.get(sumD).add(nums[i]);
        }
        int result = -1;
        for(List<Integer> list: sumDigits.values()){
            if(list.size() < 2){
                continue;
            }
            list.sort(Integer::compareTo);
            result = Math.max(result, list.get(list.size() - 1) + list.get(list.size() - 2));
        }
        return result;
    }

    private int getSumDigits(int num){
        int result = 0;
        while (num > 0){
            result += num % 10;
            num = num / 10;
        }
        return result;
    }
}
