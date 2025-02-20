public class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] result = new char[word1.length() + word2.length()];
        int pointerW1 = 0;
        int pointerW2 = 0;
        for(int i = 0; i < result.length; i++){
            if((i % 2 == 0 || pointerW2 >= word2.length())&& pointerW1 < word1.length()){
                result[i] = word1.charAt(pointerW1);
                pointerW1++;
            } else if(pointerW2 < word2.length()){
                result[i] = word2.charAt(pointerW2);
                pointerW2++;
            }
        }
        return String.copyValueOf(result);
    }
}
