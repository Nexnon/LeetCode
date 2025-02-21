public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder pattern = new StringBuilder();
        String maxPattern = "";
        String minStr = str1.length() < str2.length() ? str1 : str2;
        String maxStr = str1.equals(minStr) ? str2 : str1;
        for(int i = 0; i < minStr.length(); i++){
            pattern.append(minStr.charAt(i));
            if(str1.length() % pattern.length() != 0 || str2.length() % pattern.length() != 0){
                continue;
            }
            boolean flag = false;
            for(int j = 0; j < maxStr.length(); j++){
                if(maxStr.charAt(j) != pattern.charAt(j % pattern.length())
                        ||  minStr.charAt(j % minStr.length()) != pattern.charAt(j % pattern.length())){
                    System.out.println(pattern.toString() + " " + maxStr.charAt(j));
                    flag = true;
                    break;
                }
            }
            if(!flag){
                maxPattern = pattern.toString();
            }
        }
        return maxPattern;
    }
}
