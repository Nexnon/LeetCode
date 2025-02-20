import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        List<Integer> intNums = new ArrayList<>();
        for(String s: nums){
            intNums.add(getNumFromBinaryString(s));
        }
        for(int i = 0; i < nums.length+1; i++){
            String s = String.format("%" + nums.length + "s",
                    Integer.toBinaryString(i)).replaceAll(" ", "0");;
            if(!intNums.contains(i)){
                return s;
            }
        }
        return Integer.toBinaryString(0);
    }

    private int getNumFromBinaryString(String num){
        int result = 0;
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '1'){
                result += (int) Math.pow(2, num.length() - i - 1);
            }
        }
        return result;
    }
}
