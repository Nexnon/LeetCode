import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> product_frequency = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                product_frequency.compute(nums[i] * nums[j], (k, v) -> v == null ? 1 : v + 1);
            }
        }
        int result = 0;
        for(int v: product_frequency.values()){
            if(v > 1){
                result += (v*(v-1)/2)*8;
            }
        }
        System.out.println(product_frequency);
        return result;
    }
}
