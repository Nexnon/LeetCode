public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char err1 = 0;
        char err2 = 1;
        int c  = 0;
        for(int i = 0; i < s1.length(); i++){
            if(ch1[i] != ch2[i]){
                c++;
                if(err1 == 0){
                    err1 = ch1[i];
                    err2 = ch2[i];
                } else if(err1 != ch2[i] || err2 != ch1[i]){
                        return false;
                }
            }
        }
        return c == 0 || c == 2;
    }
}
