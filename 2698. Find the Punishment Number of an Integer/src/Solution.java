import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int punishmentNumber(int n) {
        int result = 0;
        for(int i = 1; i <= n; i++){
            System.out.println(splitNum(i*i) + " " + i);
            if(splitNum(i*i).contains(i)){
                result += i*i;
            }
        }
        return result;
    }

    private Set<Integer> splitNum(int num){
        Set<Integer> result = new HashSet<>();
        result.add(num);
        if(num < 10){
            return result;
        }
        String numStr = ""+num;
        for(int i = 1; i < numStr.length(); i++){
            String leftSubNum = numStr.substring(0, i);
            String rightSubNum = numStr.substring(i);

            int leftNum = Integer.parseInt(leftSubNum);
            int rightNum = Integer.parseInt(rightSubNum);

            Set<Integer> leftSum = splitNum(leftNum);
            Set<Integer> rightSum = splitNum(rightNum);

            result.add(leftNum + rightNum);

            for(int j: leftSum){
                for(int k: rightSum){
                    result.add(j+k);
                }
            }
        }
        return result;
    }
}
