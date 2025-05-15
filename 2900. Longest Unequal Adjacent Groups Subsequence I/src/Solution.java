import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int group = groups[0];
        result.add(words[0]);
        for(int i = 1; i < words.length; i++) {
            if(group != groups[i]) {
                result.add(words[i]);
                group = groups[i];
            }
        }
        return result;
    }
}
