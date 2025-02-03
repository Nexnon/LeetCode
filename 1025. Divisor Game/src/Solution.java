import java.util.*;

public class Solution {

    public boolean divisorGameALT(int n) {
        return n % 2 == 0;
    }
    public boolean divisorGame(int n) {
        Set<Integer> loseNum = new HashSet<>();
        loseNum.add(1);
        if(n == 1){
            return false;
        }
        int i = 1;
        while(i <= n){
            Set<Integer> setX = setX(i);
            if(loseNum.stream().noneMatch(setX::contains)){
                loseNum.add(i);
            }
            i++;
        }
        return !loseNum.contains(n);
    }

    public Set<Integer> setX(int n){
        Set<Integer> setX = new HashSet<>();
        if (n < 2){
            return new HashSet<>();
        }
        for (int i = 1; i < n; i++){
            if(n % i == 0){
                setX.add(n-i);
            }
        }
        return setX;
    }
}
